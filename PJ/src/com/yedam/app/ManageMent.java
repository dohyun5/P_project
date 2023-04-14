package com.yedam.app;

import java.util.Scanner;

import com.yedam.board.BoardService;
import com.yedam.board.BoardrepService;
import com.yedam.member.MemberService;
import com.yedam.tradeBoard.TradeBoardService;
import com.yedam.tradeBoard.TradeBoardrepService;


public class ManageMent {
	Scanner sc = new Scanner(System.in);
	int menu = 0;
	MemberService ms = new MemberService();
	BoardService bs = new BoardService();
	TradeBoardService ts = new TradeBoardService();
	BoardrepService br = new BoardrepService();
	TradeBoardrepService tbs = new TradeBoardrepService();
	
	
	
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
						ms.getMemberList();
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
					//ms.getFilmMemberList();
					while(true) {
						ms.getFilmMemberList();
						filmSelMenu();
						if(menu == 1) {
							ms.memberDvUpdate();
						}else if(menu == 2) {
							break;
						}
						
					}
				}else if (menu == 5){
					while(true) {
						selectBoard();
						if(menu == 1) {
							while(true) {
								boardMenu();
								if(menu == 1) {
									bs.getBoardContent();
									while(true) {
										bs.getBoardContent2();
										replyMenu2();
										if(menu == 1) {
											while(true) {
												bs.getRep();
												replyMenu();
												if(menu == 1) {
													//bs.getBoardContent2();
													br.boardRepAdd();
												}else if(menu == 2) {
													br.boardRepContentEdit();
												}else if(menu == 3) {
													br.boardRepDelete();
												}else if(menu == 4) {
													break;
												}
											}
										}else if (menu == 2) {
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
									ts.getBoardContent();
									while(true) {
										ts.getBoardContent2();
										replyMenu2();
										if(menu == 1) {
											while(true) {
												ts.getRep();
												replyMenu();
												if(menu == 1) {
													//bs.getBoardContent2();
													tbs.tradeboardRepAdd();
												}else if(menu == 2) {
													tbs.tradeboardRepContentEdit();
												}else if(menu == 3) {
													tbs.tradeboardRepDelete();
												}else if(menu == 4) {
													break;
												}
											}
										}else if (menu == 2) {
											break;
										}
									}
								}else if(menu == 2) {
									ts.boardAdd();
								}else if(menu == 3) {
									while(true) {
										boardEdit();
										if(menu == 1) {
											ts.boardTitleEdit();
											break;
										}else if (menu == 2) {
											ts.boardContentEdit();
											break;
										}else if (menu == 3) {
											break;
										}
									}
								}else if(menu == 4) {
									ts.boardDelete();
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
					while(true) {
						ms.getfilmContent();
						filmMenu();
						if(menu == 1) {
							ms.filmUpdate();
						}else if(menu == 2) {
							ms.nowDv();
						}else if(menu == 3) {
							break;
						}
					}
				}else if(menu == 5) {
					ts.getBoardContent3();
					System.out.println("=========================================================================");
					System.out.println("|번호\t|제목\t\t\t|판매자\t|작성일\t\t|거래상태  |조회수");
					System.out.println("=========================================================================");
					ts.tradeNow();
					tradeIngMenu();
					while(true) {
						if(menu == 1) {
							ts.tradeChange();
							System.out.println("=========================================================================");
							System.out.println("|번호\t|제목\t\t\t|판매자\t|작성일\t\t|거래상태   |조회수");
							System.out.println("=========================================================================");
							ts.tradeNow();
							tradeIngMenu();
						}else if(menu == 2) {
							break;
						}
					}
					
				}else if(menu == 6) {
					
					while(true) {
						selectBoard();
						if(menu == 1) {
							while(true) {
								boardMenu();
								if(menu == 1) {
									bs.getBoardContent();
									while(true) {
										bs.getBoardContent2();
										replyMenu2();
										if(menu == 1) {
											while(true) {
												bs.getRep();
												replyMenu();
												if(menu == 1) {
													//bs.getBoardContent2();
													br.boardRepAdd();
												}else if(menu == 2) {
													br.boardRepContentEdit();
												}else if(menu == 3) {
													br.boardRepDelete();
												}else if(menu == 4) {
													break;
												}
											}
										}else if (menu == 2) {
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
									ts.getBoardContent();
									while(true) {
										ts.getBoardContent2();
										replyMenu2();
										if(menu == 1) {
											while(true) {
												ts.getRep();
												replyMenu();
												if(menu == 1) {
													//bs.getBoardContent2();
													tbs.tradeboardRepAdd();
												}else if(menu == 2) {
													tbs.tradeboardRepContentEdit();
												}else if(menu == 3) {
													tbs.tradeboardRepDelete();
												}else if(menu == 4) {
													break;
												}
											}
										}else if (menu == 2) {
											break;
										}
									}
								}else if(menu == 2) {
									ts.boardAdd();
								}else if(menu == 3) {
									while(true) {
										boardEdit();
										if(menu == 1) {
											ts.boardTitleEdit();
											break;
										}else if (menu == 2) {
											ts.boardContentEdit();
											break;
										}else if (menu == 3) {
											break;
										}
									}
								}else if(menu == 4) {
									ts.boardDelete();
								}else if(menu == 5) {
									break;
								}
							}
						}else if(menu == 3) {
							break;
						}
						
					}
					
				}else if(menu == 7) {
					ms.memberDelete2();
					break;
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
						ms.getfilmContent();
						while(true) {
							filmMenu();
							if(menu == 1) {
								ms.filmUpdate();
							}else if(menu == 2) {
								ms.nowDv();
							}else if(menu == 3) {
								break;
							}
						}
					}else if(menu == 5) {
						while(true) {
							boardMenu();
							if(menu == 1) {
								bs.getBoardContent();
								while(true) {
									bs.getBoardContent2();
									replyMenu2();
									if(menu == 1) {
										while(true) {
											bs.getRep();
											replyMenu();
											if(menu == 1) {
												//bs.getBoardContent2();
												br.boardRepAdd();
											}else if(menu == 2) {
												br.boardRepContentEdit();
											}else if(menu == 3) {
												br.boardRepDelete();
											}else if(menu == 4) {
												break;
											}
										}
									}else if (menu == 2) {
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
						
					}else if(menu == 6) {
						ms.memberDelete2();
						break;
					}else if(menu == 99) {
						ms.logout();
						break;
					}
				}
				
		}
	}
	
	
	
	
	
	private void menu() {
		if(MemberService.memberInfo.getMemberGrade().equals("A")) {
			System.out.println("1. 회원 등록 | 2.회원 조회 | 3. 회원 정보 수정 | 4. 인화 및 배송 상태 변경 | 5. 게시판 관리 | 99. 로그아웃");
		}else if(MemberService.memberInfo.getMemberGrade().equals("B")) {
			System.out.println("1. 내 정보 조회 | 2. 비밀번호 수정 | 3. 활동명 수정 | 4. 인화 | 5. 중고 거래 조회 | 6. 게시판 | 7. 탈퇴 | 99. 로그 아웃");
		}else if(MemberService.memberInfo.getMemberGrade().equals("C")) {
			System.out.println("1. 내 정보 조회 | 2. 비밀번호 수정 | 3. 활동명 수정 | 4. 인화 | 5. 게시판 | 6. 탈퇴 | 99. 로그 아웃");
		}
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void menu2() {
		System.out.println("1. 전체 조회 | 2. 선택 조회 | 3. 등급별 조회 | 4. 인화상태별 조회 | 5. 상위 메뉴");
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
		System.out.println("\t\t\t팁 & 스킬 공유 게시판");
		System.out.println("================================================================");
		System.out.println("|글번호\t|제목\t\t\t|작성자\t|작성일\t      |조회수");
		System.out.println("================================================================");
		bs.getBoardList();
		System.out.println("================================================================");
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
		System.out.println("\t\t\t중고 거래 게시판");
		System.out.println("==========================================================================");
		System.out.println("|글번호\t|제목\t\t\t|작성자\t|작성일\t\t|거래상태 |조회수");
		System.out.println("==========================================================================");
		ts.getTradeBoardList();
		System.out.println("==========================================================================");
		System.out.println("1. 게시글 보기 | 2. 게시글 작성 | 3. 게시글 수정 | 4. 게시글 삭제 | 5. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	
	
	private void replyMenu() {
//		System.out.println("=========================댓글========================");
//		br.getBoardRepList();
		//System.out.println("====================================================");
		System.out.println("1. 댓글 작성 | 2. 댓글 수정 | 3. 댓글 삭제 | 4. 게시글로 돌아가기");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	private void replyMenu2() {
		System.out.println("1. 댓글보기 | 2. 목록 돌아가기");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	
	private void tradeIngMenu() {
		System.out.println("=========================================================================");
		System.out.println("1. 판매 상태 수정 | 2. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		
	}
	
	private void filmMenu() {
		System.out.println("1. 인화 신청 | 2. 인화 조회 | 3. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		
	}
	
	
	private void filmSelMenu() {
		System.out.println("1. 상태 변경 | 2. 상위 메뉴");
		System.out.println("입력 > ");
		menu = Integer.parseInt(sc.nextLine());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
