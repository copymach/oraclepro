-- 오라클 phonedb 계정 생성하기
 

-- system 계정에서 실행하기 

-- 계정 생성 id phonedb / pw phonedb
CREATE USER phonedb IDENTIFIED BY phonedb;

-- 폰db 계정에 role2 주기 (객체 제어, 테이블 생성 권한)
grant resource, connect to phonedb;


--계정 권한 보기
SELECT grantee, privilege
FROM DBA_SYS_PRIVS
WHERE grantee = 'RESOURCE';

--계정리스트 보기(참고)
select * from all_users;

--오라클 접속에서 오른쪽 클릭 - 새 접속 누르고 name 에 이름 적고 id pw 적고 test 이후 저장

-- system 계정에서 실행하는 쿼리 종료




-- system 계정 이후 생성한 phonedb에서 실행하는 쿼리 
--테이블 person 생성하기 4개의 튜플
create table person(
person_id   number(5) primary key,
name        VARCHAR2(30) NOT NULL,
hp          VARCHAR2(20),
company     VARCHAR2(20)
);


--테이블 상태 확인
select * from person;
 
--테이블 삭제 초기화
drop table person;

--id 번호 자동생성 꼬일때 초기화 (리셋)
drop SEQUENCE seq_person_id; 

--시퀀스 조회
SELECT * FROM USER_SEQUENCES;

-- person id번호 자동생성을 위한 시퀀스(sequence)
create sequence seq_person_id
increment by 1
start with 1
nocache
;


--person 정보 입력하기 (자동생성id, 이름, hp, company)
INSERT INTO person VALUES (seq_person_id.nextval, '이효리', '010-1111-1111', '02-1111-1111' );

INSERT INTO person VALUES (seq_person_id.nextval, '정우성', '010-2222-2222', '02-2222-2222' );

INSERT INTO person VALUES (seq_person_id.nextval, '유재석', '010-3333-3333', '02-3333-3333' );

INSERT INTO person VALUES (seq_person_id.nextval, '이정재', '010-4444-4444', '02-4444-4444' );

INSERT INTO person VALUES (seq_person_id.nextval, '서장훈', '010-5555-5555', '02-5555-5555' );


-- (person id 3번)의 정보를 변경하기
UPDATE person
SET hp = '010-1212-1212'
WHERE author_id = 3 ;

--author 테이블에서 person2 (id 2) 데이터를 삭제
TRUNCATE TABLE person WHERE author_id = 2;

DELETE FROM person WHERE author_id = 2 ;



--커밋 
commit;

--롤백
rollback;


