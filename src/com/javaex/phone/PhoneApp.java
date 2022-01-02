package com.javaex.phone;

import java.util.List;


public class PhoneApp {

	public static void main(String[] args) {

		List<PersonVo> list;
		PhoneDao phoneDao = new PhoneDao();

//		연락처 입력하기 '둘리', '아기공룡', '1992-03-01', 1);
		PersonVo ps01 = new PersonVo ("영심이", "말괄량이", 1);
		phoneDao.ContactsInput(ps01);

		phoneDao.ContactsRemove(1);

		System.out.println("================================");
		list = phoneDao.PersonSelect(); 
		for (int i = 0; i < list.size(); i++) {
			PersonVo vo = list.get(i);
			System.out.println(vo.getPersonId() + ", " + vo.getHp() + ", " + vo.getCompany() );
		}
		System.out.println("================================");

		
	}

}
