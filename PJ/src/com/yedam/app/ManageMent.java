package com.yedam.app;

import java.util.Scanner;

import com.yedam.board.BoardService;
import com.yedam.member.MemberService;


public class ManageMent {
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	MemberService ms = new MemberService();
	BoardService bs = new BoardService();
	
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
					if(menu == 1) {
						ms.getMemberList();
					}else if(menu == 2) {
						ms.getMember();
					}else if(menu == 3) {
						ms.getMemberG();
					}else if(menu == 4) {
						ms.getMemberDv();
					}else if(menu == 5) {
						break;
					}
				}
				}else if(menu == 3) {
					while(true) {
						menu3();
						if(menu == 1) {
							ms.memberPwUpdate();
						}else if(menu == 2) {
							ms.memberFnameUpdate();
						}else if(menu == 3) {
							ms.memberGradeUpdate();
						}else if(menu == 4) {
							ms.memberDelete();
						}else if(menu == 5) {
							break;
						}
					}
				}else if (menu == 4){
					ms.memberDvUpdate();
				}else if (menu == 5){
					while(true) {
						selectBoard();
						if(menu == 1) {
							while(true) {
								boardMenu();
								if(menu == 1) {
									while(true) {
										bs.getBoardContent();
										replyMenu();
										if(menu == 1) {
											
										}else if(menu == 2) {
											
										}else if(menu == 3) {
											
										}else if(menu == 4) {
											break;
										}
									}
								}else if(menu == 2) {
									bs.boardAdd();
								}else if(menu == 3) {
									while(true) {
										boardEdit();
										if(menu == 1) {
											bs.boardTitleEdit();
											break;
										}else if (menu == 2) {
											bs.boardContentEdit();
											break;
										}else if (menu == 3) {
											break;
										}
									}
								}else if(menu == 4) {
									bs.boardDelete();
								}else if(menu == 5) {
									break;
								}
							}
						}else if(menu == 2) {
							while(true) {
								tradeBoardMenu();
								if(menu == 1) {
									while(true) {
										replyMenu();
										if(menu == 1) {
											
										}else if(menu == 2) {
											
										}else if(menu == 3) {
											
										}else if(menu == 4) {
											break;
										}
									}	
								}else if(menu == 2) {
									
								}else if(menu == 3) {
									
								}else if(menu == 4) {
									
								}else if(menu == 5) {
									break;
								}
							}
						}else if(menu == 3) {
							break;
						}
					}
				}else if(menu == 99) {
					ms.logout();
					break;
				}
			}
				else if(MemberService.memberInfo.getMemberGrade().equals("B")) {
				if(menu == 1) {
					ms.getMemberMe();
				}else if(menu == 2) {
					ms.memberPwUpdate2();
				}else if(menu == 3) {
					ms.memberFnameUpdate2();
				}else if(menu == 4) {
					ms.nowDv();
				}else if(menu == 5) {
					ms.memberDelete2();
					break;
				}else if(menu == 6) {
					while(true) {
						selectBoard();
						if(menu == 1) {
							while(true) {
								boardMenu();
								if(menu == 1) {
									while(true) {
										
										replyMenu();
										if(menu == 1) {
											
										}else if(menu == 2) {
											
										}else if(menu == 3) {
											
										}else if(menu == 4) {
											break;
										}
									}
								}else if(menu == 2) {
									bs.boardAdd();
								}else if(menu == 3) {
									
								}else if(menu == 4) {
									
								}else if(menu == 5) {
									break;
								}
							}
						}else if(menu == 2) {
							while(true) {
								tradeBoardMenu();
								if(menu == 1) {
									
//									while(true) {
//										replyMenu();
//										if(menu == 1) {
//											
//										}else if(menu == 2) {
//											
//										}else if(menu == 3) {
//											
//										}else if(menu == 4) {
//											break;
//										}
//									}
								}else if(menu == 2) {
									bs.boardAdd();
								}else if(menu == 3) {
									
								}else if(menu == 4) {
									
								}else if(menu == 5) {
									break;
								}
							}
						}else if(menu == 3) {
							break;
						}
						
					}
				}else if(menu == 99) {
					ms.logout();
					break;
				}
				}
				else if(MemberService.memberInfo.getMemberGrade().equals("C")) {
					if(menu == 1) {
						ms.getMemberMe();
					}else if(menu == 2) {
						ms.memberPwUpdate2();
					}else if(menu == 3) {
						ms.memberFnameUpdate2();
					}else if(menu == 4) {
						ms.nowDv();
					}else if(menu == 5) {
						ms.memberDelete2();
						break;
					}else if(menu == 6) {
						while(true) {
							boardMenu();
							if(menu == 1) {
								while(true) {
									replyMenu();
									if(menu == 1) {
										
									}else if(menu == 2) {
										
									}else if(menu == 3) {
										
									}else if(menu == 4) {
										break;
									}
								}
							}else if(menu == 2) {
								
							}else if(menu == 3) {
								
							}else if(menu == 4) {
								
							}else if(menu == 5) {
								break;
							}
						}
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
			System.out.println("1. 내 정보 조회 | 2. 비밀번호 수정 | 3. 활동명 수정 | 4. 인화 현황 조회 | 5. 탈퇴 | 6. 게시판 접근 | 99. 로그 아웃");
		}else if(MemberService.memberInfo.getMemberGrade().equals("C")) {
			System.out.println("1. 내 정보 조회 | 2. 비밀번호 수정 | 3. 활동명 수정 | 4. 인화 현황 조회 | 5. 탈퇴 | 6. 게시판 접근 | 99. 로그 아웃");
		}
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void menu2() {
		System.out.println("1. 전체 조회 | 2. 선택 조회 | 3. 등급별 조회 | 4. 상황별 조회 | 5. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void menu3() {
		System.out.println("1. 비밀번호 수정 | 2. 활동명 수정 | 3. 등급 수정 | 4. 회원 제거 | 5. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void selectBoard() {
		System.out.println("1. 팁 & 스킬 공유 게시판 | 2. 중고 거래 게시판 | 3. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	public void boardMenu() {
		System.out.println("==================팁 & 스킬 공유 게시판==================");
		System.out.println("|글번호\t|제목\t\t|작성자\t|게시일\t      |조회수");
		System.out.println("====================================================");
		bs.getBoardList();
		System.out.println("====================================================");
		System.out.println("1. 게시글 보기 | 2. 게시글 작성 | 3. 게시글 수정 | 4. 게시글 삭제 | 5. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	public void boardEdit() {
		System.out.println("1. 제목 수정 | 2. 내용 수정 | 3. 수정 취소 ");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void tradeBoardMenu() {
		System.out.println("==================중고 거래 게시판==================");
		System.out.println("|글번호\t|제목\t\t|작성자\t|게시일\t|조회수");
		System.out.println("================================================");
		System.out.println("1. 게시글 보기 | 2. 게시글 작성 | 3. 게시글 수정 | 4. 게시글 삭제 | 5. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void replyMenu() {
		System.out.println("1. 댓글 작성 | 2. 댓글 수정 | 3. 댓글 삭제 | 4. 목록으로 돌아가기");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	
	
}
