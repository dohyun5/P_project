package com.yedam.tradeBoard;

import java.util.List;
import java.util.Scanner;


public class TradeBoardService {
	Scanner sc = new Scanner(System.in);
	public void getTradeBoardList() {
		List<TradeBoard> list = TradeBoardDAO.getInstance().getTradeBoardList();
		if(list.isEmpty()) {
			System.out.println("                    게시글 없음          ");
		}else {
		for(TradeBoard bd : list) {
			System.out.print("|"+bd.getBoardNo()+"\t");
			System.out.print("|"+bd.getBoardTitle()+"\t\t");
			System.out.print("|"+bd.getMemberFname()+"\t");
			System.out.print("|"+bd.getBoardDate()+"\t");
			System.out.print(bd.getBoardViews()+"\t");
			System.out.println();
			}
		
		}
	}
	
	public void boardAdd() {
		String boardTitle = "";
		String boardContent = "";
		System.out.println("제목 입력 > ");
		boardTitle = sc.nextLine();
		System.out.println("내용 입력 >");
		boardContent = sc.nextLine();
		
		TradeBoard board = new TradeBoard();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		TradeBoardDAO.getInstance().boardAdd(board);
		
	}
	
	public void getBoardContent() {
		System.out.println("읽을 게시글 번호 입력 > ");
		int boardNo = Integer.parseInt(sc.nextLine());
		TradeBoard bd = TradeBoardDAO.getInstance().getBoardContent(boardNo);
		System.out.println("=====================================");
		System.out.println("            "+ bd.getBoardTitle());
		System.out.println(bd.getBoardNo()+ "      " + bd.getMemberFname()+bd.getBoardDate()+bd.getBoardViews());
		System.out.println("=====================================");
		System.out.println(" " +bd.getBoardContent());
		System.out.println("=====================================");
		
	}
	
	public void boardTitleEdit() {
		System.out.println("제목 수정할 글 번호 입력 >  ");
		int boardNo = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 제목 입력 > ");
		String boardTitle = sc.nextLine();
		
		TradeBoard board = new TradeBoard();
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		
		TradeBoardDAO.getInstance().boardTitleEdit(board);
		
	}
	
	public void boardContentEdit() {
		System.out.println("내용 수정할 글 번호 입력 >  ");
		int boardNo = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 내용 입력 > ");
		String boardContent = sc.nextLine();
		
		TradeBoard board = new TradeBoard();
		board.setBoardNo(boardNo);
		board.setBoardContent(boardContent);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(수정됨)");
//		Date boardDate = sdf.format(boardInfo.getBoardDate());
//		board.setBoardDate(boardDate);
		
		
		TradeBoardDAO.getInstance().boardContentEdit(board);
		
	}
	
	public void boardDelete() {
		System.out.println("삭제할 게시글 번호 입력 > ");
		int boardNo = Integer.parseInt(sc.nextLine());
		
		int result = TradeBoardDAO.getInstance().boardDelete(boardNo);
		if(result > 0) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
