package com.yedam.app;

import java.util.Scanner;

import com.yedam.member.MemberService;


public class ManageMent {
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	int menu2 = 0;
	int menu3 = 0;
	MemberService ms = new MemberService();
	
	public ManageMent() {
		userOrMgr();
	}
	
	private void userOrMgr() {
		while(true) {
			menu();
			if(MemberService.memberInfo.getMemberGrade().equals("A")) {
				if(menu == 1) {
					ms.memberAdd();
				}else if(menu == 2) {
					while(true) {
					menu2();						
					if(menu2 == 1) {
						ms.getMemberList();
					}else if(menu2 == 2) {
						ms.getMember();
					}else if(menu2 == 3) {
						ms.getMemberG();
					}else if(menu2 == 4) {
						ms.getMemberDv();
					}else if(menu2 == 5) {
						break;
					}
				}
				}else if(menu == 3) {
					while(true) {
						menu3();
						if(menu3 == 1) {
							ms.memberPwUpdate();
						}else if(menu3 == 2) {
							ms.memberFnameUpdate();
						}else if(menu3 == 3) {
							ms.memberGradeUpdate();
						}else if(menu3 == 4) {
							break;
						}
					}
				}else if (menu == 4){
					ms.memberDvUpdate();
				}else if (menu == 5){
					
				}else if(menu == 99) {
					ms.logout();
					break;
				}
			}
				else if(MemberService.memberInfo.getMemberGrade().equals("B")) {
				if(menu == 1) {
					ms.memberPwUpdate2();
				}else if(menu == 2) {
					ms.memberFnameUpdate2();
				}else if(menu == 3) {
					ms.nowDv();
				}else if(menu == 4) {
					
				}else if(menu == 5) {
					
				}else if(menu == 99) {
					ms.logout();
					break;
				}
				}
				else if(MemberService.memberInfo.getMemberGrade().equals("C")) {
					if(menu == 1) {
						ms.memberPwUpdate2();
					}else if(menu == 2) {
						ms.memberFnameUpdate2();
					}else if(menu == 3) {
						ms.nowDv();
					}else if(menu == 4) {
						
					}else if(menu == 5) {
						
					}else if(menu == 99) {
						ms.logout();
						break;
					}
				}
				
		}
	}
	
	private void menu() {
		if(MemberService.memberInfo.getMemberGrade().equals("A")) {
			System.out.println("1. 회원 등록 | 2.회원 조회 | 3. 회원 정보 수정 | 4. 인화 및 배송 정보 변경 | 5. 게시판 관리 | 99. 로그아웃");
		}else if(MemberService.memberInfo.getMemberGrade().equals("B")) {
			System.out.println("1. 비밀번호 수정 | 2. 활동명 수정 | 3. 인화 현황 조회 | 4. 탈퇴 | 5. 게시판 접근 | 99. 로그 아웃");
		}else if(MemberService.memberInfo.getMemberGrade().equals("C")) {
			System.out.println("1. 비밀번호 수정 | 2. 활동명 수정 | 3. 인화 현황 조회 | 4. 탈퇴 | 5. 게시판 접근 | 99. 로그 아웃");
		}
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void menu2() {
		System.out.println("1. 전체 조회 | 2. 선택 조회 | 3. 등급별 조회 | 4. 상황별 조회 | 5. 상위 메뉴");
		System.out.println("입력 > ");
		menu2 = Integer.parseInt(sc.nextLine());
	}
	
	private void menu3() {
		System.out.println("1. 비밀번호 수정 | 2. 활동명 수정 | 3. 등급 수정 | 4. 상위 메뉴");
		System.out.println("입력 > ");
		menu3 = Integer.parseInt(sc.nextLine());
	}
	
	
	
}
