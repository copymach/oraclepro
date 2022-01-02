package com.javaex.phone;

import java.util.List;


public class PhoneAppVer1 {

	public static void main(String[] args) {

		List<PersonVo> list;
		PhoneDao phoneDao = new PhoneDao();

//		연락처 입력하기 1, '둘리', '010-1212-2323', '02-3232-3434');
		PersonVo ps01 = new PersonVo(1, "영심이", "010-2323-3232", "02-5555-6666"); 
		phoneDao.ContactsInput(ps01);

		phoneDao.ContactsRemove(1);

		phoneDao.ContactsUpdate(ps01);
		
		
		System.out.println("================================");
		list = phoneDao.PersonSelect(); 
		for (int i = 0; i < list.size(); i++) {
			PersonVo vo = list.get(i);
			System.out.println(vo.getPersonId() + ", " + vo.getHp() + ", " + vo.getCompany() );
		}
		System.out.println("================================");

		
	}

}
