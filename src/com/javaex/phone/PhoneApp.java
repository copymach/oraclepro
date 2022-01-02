package com.javaex.phone;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class PhoneApp {


	public static void main(String[] args) throws IOException {
		
		PhoneApp.begin();
		
		Scanner sc = new Scanner(System.in);
		
		boolean loop= true;
		
		while(loop) {
			PhoneApp.menu();
			int order = sc.nextInt();
			
			switch(order) {
				case 1 : //1.리스트
					PhoneApp.printList();
					break;
					
				case 2 : //2.등록
					PhoneApp.add(); //폰번호를 입력
					break;
					
				case 3 : //3.삭제
					PhoneApp.delete(); //삭제할 번호를 입력
					break;
					
				case 4 : //4.검색
					PhoneApp.search();
					break;
					
				case 5 : //5.종료
					PhoneApp.end();
					loop = false; // 이거 안넣으면 반복 안끝남					
					break;
					
				default :
					System.out.println("다시 입력해 주세요.");
					break;
			} //switch종료
			
		} // while 종료
		
	sc.close(); // 반복이 끝나면 스캐너 종료
	
	} // main 종료
	
	
	public static void begin() {
		System.out.println("------------------");
		System.out.println("전번 관리 프로그램");
		System.out.println("------------------");
	} //begin 종료
	
	public static void menu() {
		System.out.println("");
		System.out.println("1.리스트 \t 2.등록 \t 3.삭제 \t 4.검색 \t 5.종료");
		System.out.print("메뉴번호>");
	} // menu종료
	
	public static void end() {
		System.out.println(" 종료합니다 ");
	} // end종료
	
	
	public static void printList() {
		System.out.println("1.리스트>");
		
		List<PersonVo> list;
		PhoneDao phoneDao = new PhoneDao();
		
		list = phoneDao.PersonSelect(); 
		for (int i = 0; i < list.size(); i++) {
			PersonVo vo = list.get(i);
			System.out.println(vo.getPersonId() + ", " + vo.getHp() + ", " + vo.getCompany() );
		}
		
	} //printList 종료
	
	public static void add() {
//		이하 sc 스캐너 종료시 루프 에러 조심 
		Scanner sc = new Scanner(System.in);
		String name; // 이름
		String hp;  //휴대전화
		String company;  //회사전화
		
		System.out.println("2.등록> 이름 휴대전화 회사전화 순서 입력");
		System.out.print("이름> ");
		name = sc.nextLine();
		System.out.print("휴대전화> ");
		hp = sc.nextLine();
		System.out.print("회사전화> ");
		company = sc.nextLine();
		
		PhoneDao phoneDao = new PhoneDao();
		
		phoneDao.ContactsInput( new PersonVo(name, hp, company) );
		System.out.println("변경사항이 저장되었습니다.");
		
	} //add 종료
	
	
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("3.삭제> 지울 번호를 입력");
		System.out.print("번호>");
		int index = sc.nextInt();
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.ContactsRemove(index);
		System.out.println(index+"번이 삭제 되었습니다.");
		
	} // delete 종료
	
	public static void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("4.검색> 전화번호를 알고싶은 사람의 이름을 입력");
		System.out.print("이릅> ");
		String search = sc.nextLine();
		
		System.out.println("검색한 키워드"+search+"의 결과는...");
		System.out.println("검색기능은 곧 추가됩니다 comming soon");
		
//		search로 입력받은 사람의 전번을 출력
		
		/*for (PersonVo ps : pArray) {
			if (ps.getName().contains(search)) {
				System.out.println(pArray.indexOf(ps)+1+". "); //정수1을 추가한다
				ps.showInfo();
			}
		}*/
		
	} // search 종료


}
