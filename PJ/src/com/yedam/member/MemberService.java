package com.yedam.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService {
	public static Member memberInfo = null;
	Scanner sc = new Scanner(System.in);
	
	public void login() {
		Member member = new Member();
		
		System.out.println("ID > ");
		String id = sc.nextLine();
		
		System.out.println("PW > ");
		String pw = sc.nextLine();
		
		member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(pw.equals(member.getMemberPw())) {
				System.out.println("로그인 성공");
				System.out.println("Hello" + member.getMemberFname() + "님");
				memberInfo = member;
			}else {
				System.out.println("PW 오류");
			}
		}else {
			System.out.println("ID 오류");
		}
	}
		
		public void logout() {
			if(memberInfo != null) {
				memberInfo = null;
				System.out.println("log out!");
			}
		}
		
		public void memberAdd() {
			String memberId = "";
			String memberFname = "";
			
			while(true) {
				System.out.println("ID > ");
				memberId = sc.nextLine();
				if(MemberDAO.getInstance().login(memberId) == null) {
					System.out.println("사용할 수 있는 ID");
					break;
				}else {
					System.out.println("ID중복, 재입력");
				}
			}
			
			System.out.println("PW > ");
			String memberPw = sc.nextLine();
			System.out.println("이름 > ");
			String memberName = sc.nextLine();
			while(true) {
				System.out.println("활동명 > ");
				memberFname = sc.nextLine();
				if(MemberDAO.getInstance().login2(memberFname) == null) {
					System.out.println("사용할 수 있는 활동명");
					break;
				}else {
					System.out.println("활동명 중복, 재입력");
				}
			}
			
			Member member = new Member();
			
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			member.setMemberName(memberName);
			member.setMemberFname(memberFname);
			
			MemberDAO.getInstance().memberAdd(member);
			
		}
		
		public void getMemberList() {
			List<Member> list = MemberDAO.getInstance().getMemberList();
			System.out.println("====================================================");
			System.out.println("ID\tPW\tName\tFname\t필름인화 상태\t등급");
			System.out.println("====================================================");
			for(int i=0; i<list.size();i++) {
				System.out.print(list.get(i).getMemberId() + "\t");
				System.out.print(list.get(i).getMemberPw() + "\t");
				System.out.print(list.get(i).getMemberName() + "\t");
				System.out.print(list.get(i).getMemberFname() + "\t");
				System.out.print(list.get(i).getMemberDv() + "\t\t");
				System.out.print(list.get(i).getMemberGrade());
				System.out.println();
			}
			System.out.println("====================================================");
		}
		
		public void getMember() {
			System.out.println("조회할 ID > ");
			String memberId = sc.nextLine();
			Member mem = MemberDAO.getInstance().getMember(memberId);
			
			if(mem != null) {
				System.out.println("ID\tPW\tName\tFname\t필름인화 상태\t등급");
				System.out.println("====================================================");
				System.out.print(mem.getMemberId()+ "\t");
				System.out.print(mem.getMemberPw()+ "\t");
				System.out.print(mem.getMemberName()+ "\t");
				System.out.print(mem.getMemberFname()+ "\t");
				System.out.print(mem.getMemberDv()+ "\t\t");
				System.out.print(mem.getMemberGrade());
				System.out.println();
			}
			
		}
		
		public void getMemberG() {
			System.out.println("조회할 등급 > ");
			String memberGrade = sc.nextLine();
			List<Member> list = MemberDAO.getInstance().getMemberG(memberGrade);
			System.out.println("====================================================");
			System.out.println("ID\tPW\tName\tFname\t필름인화 상태\t등급");
			System.out.println("====================================================");
			for(int i=0; i<list.size();i++) {
				System.out.print(list.get(i).getMemberId() + "\t");
				System.out.print(list.get(i).getMemberPw() + "\t");
				System.out.print(list.get(i).getMemberName() + "\t");
				System.out.print(list.get(i).getMemberFname() + "\t");
				System.out.print(list.get(i).getMemberDv() + "\t\t");
				System.out.print(list.get(i).getMemberGrade());
				System.out.println();
			}
			System.out.println("====================================================");
			
			
		}
			
		public void getMemberDv() {
			System.out.println("검색 조건 > ");
			String memberDv = sc.nextLine();
			List<Member> list = MemberDAO.getInstance().getMemberDv(memberDv);
			System.out.println("====================================================");
			System.out.println("ID\tPW\tName\tFname\t필름인화 상태\t등급");
			System.out.println("====================================================");
			for(int i=0; i<list.size();i++) {
				System.out.print(list.get(i).getMemberId() + "\t");
				System.out.print(list.get(i).getMemberPw() + "\t");
				System.out.print(list.get(i).getMemberName() + "\t");
				System.out.print(list.get(i).getMemberFname() + "\t");
				System.out.print(list.get(i).getMemberDv() + "\t\t");
				System.out.print(list.get(i).getMemberGrade());
				System.out.println();
			}
			System.out.println("====================================================");
			
			
		}
		
	public void memberPwUpdate() {
		System.out.println("변경할 사용자 ID입력 > ");
		String id = sc.nextLine();
		System.out.println("변경할 비밀번호 입력 > ");
		String pw = sc.nextLine();
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		int result = MemberDAO.getInstance().memberPwUpdate(member);
		if(result > 0) {
			if(id.equals(memberInfo.getMemberId())) {
				memberInfo = MemberDAO.getInstance().login(id);
			}System.out.println("변경 성공");
		}else {
			System.out.println("PW 변경 실패");
		}
		
		
	}
	
	public void memberFnameUpdate() {
		String id = "";
		String fname= "";
		System.out.println("변경할 사용자 ID입력 > ");
		id = sc.nextLine();
		while(true) {
			System.out.println("변경할 활동명 입력 > ");
			fname = sc.nextLine();
			
			if(MemberDAO.getInstance().login2(fname) == null) {
				System.out.println("사용할 수 있는 활동명");
				break;
			}else {
				System.out.println("활동명 중복, 재입력");
			}
		}
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberFname(fname);
		int result = MemberDAO.getInstance().memberFnameUpdate(member);
		if(result > 0) {
			if(id.equals(memberInfo.getMemberId())) {
				memberInfo = MemberDAO.getInstance().login(id);
				
			}System.out.println("변경 성공");
		}else {
			System.out.println("활동명 변경 실패");
		}
	}
	
	public void memberGradeUpdate() {
		System.out.println("변경할 사용자 ID입력 > ");
		String id = sc.nextLine();
		System.out.println("변경할 등급 입력 > ");
		String grade = sc.nextLine();
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberGrade(grade);
		
		int result = MemberDAO.getInstance().memberGradeUpdate(member);
		if(result > 0) {
			if(id.equals(memberInfo.getMemberId())) {
				memberInfo = MemberDAO.getInstance().login(id);
				
			}System.out.println("변경 성공");
		}else {
			System.out.println("등급 변경 실패");
		}
	}
		
	public void memberDvUpdate() {
		System.out.println("변경할 사용자 ID입력 > ");
		String id = sc.nextLine();
		System.out.println("변경사항 입력 > ");
		String dv = sc.nextLine();
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberDv(dv);
		
		int result = MemberDAO.getInstance().memberDvUpdate(member);
		if(result > 0) {
			if(id.equals(memberInfo.getMemberId())) {
				memberInfo = MemberDAO.getInstance().login(id);
			}System.out.println("변경 성공");
		}else {
			System.out.println("변경 실패");
		}
	}	
		
	public void memberPwUpdate2() {
		String id = memberInfo.getMemberId();
		System.out.println("변경할 비밀번호 입력 > ");
		String pw = sc.nextLine();
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		int result = MemberDAO.getInstance().memberPwUpdate(member);
		if(result > 0) {
			if(id.equals(memberInfo.getMemberId())) {
				memberInfo = MemberDAO.getInstance().login(id);
			}System.out.println("변경 성공");
		}else {
			System.out.println("PW 변경 실패");
		}
		
		
	}
	
	public void memberFnameUpdate2() {
		String id = "";
		String fname= "";
		id = memberInfo.getMemberId();
		while(true) {
			System.out.println("변경할 활동명 입력 > ");
			fname = sc.nextLine();
			
			if(MemberDAO.getInstance().login2(fname) == null) {
				System.out.println("사용할 수 있는 활동명");
				break;
			}else {
				System.out.println("활동명 중복, 재입력");
			}
		}
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberFname(fname);
		int result = MemberDAO.getInstance().memberFnameUpdate(member);
		if(result > 0) {
			if(id.equals(memberInfo.getMemberId())) {
				memberInfo = MemberDAO.getInstance().login(id);
				
			}System.out.println("변경 성공");
		}else {
			System.out.println("활동명 변경 실패");
		}
	}
	
	
	public void nowDv() {
		String id = memberInfo.getMemberId();
		
		Member member = new Member();
		member.setMemberId(id);
		int result = MemberDAO.getInstance().memberPwUpdate(member);
		if(result > 0) {
			if(id.equals(memberInfo.getMemberId())) {
				memberInfo = MemberDAO.getInstance().login(id);
			}System.out.println("조회 성공");
		}else {
			System.out.println("조회 실패");
		}
		
		
	}
		
		
		
		
		
		
		
		
	
}
