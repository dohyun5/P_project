package com.yedam.tradeBoard;

import java.util.List;
import java.util.Scanner;

import com.yedam.board.Board;
import com.yedam.board.BoardDAO;
import com.yedam.board.BoardService;
import com.yedam.member.MemberService;


public class TradeBoardService {
	Scanner sc = new Scanner(System.in);
	public static TradeBoard tradeboardInfo = null;
	TradeBoardrepService tbs = new TradeBoardrepService();
	
	
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
			System.out.print("|"+bd.getTradeIng()+"\t");
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
//		System.out.println("=====================================");
//		System.out.println("            "+ bd.getBoardTitle());
//		System.out.println(bd.getBoardNo()+ "      " + bd.getMemberFname()+bd.getBoardDate()+bd.getBoardViews());
//		System.out.println("=====================================");
//		System.out.println(" " +bd.getBoardContent());
		tradeboardInfo = bd;
	}
	
	
	
	
	public void getBoardContent2() {
		int boardNo = TradeBoardService.tradeboardInfo.getBoardNo();
		TradeBoard bd = TradeBoardDAO.getInstance().getBoardContent(boardNo);
		System.out.println("=====================================");
		System.out.println("            "+ bd.getBoardTitle());
		System.out.println("|"+bd.getBoardNo()+ "\t\t" +"| "+ bd.getMemberFname()+"| "+bd.getBoardDate());
		System.out.println("=====================================");
		System.out.println("\t" +bd.getBoardContent());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("=====================================");
		//br.getBoardRepList();
	}
	
	public void getRep() {
		System.out.println("================댓글================");
		tbs.gettradeBoardRepList();
	}
	
	
	
	public void boardTitleEdit() {
		System.out.println("제목 수정할 글 번호 입력 >  ");
		int boardNo = Integer.parseInt(sc.nextLine());
		if (MemberService.memberInfo.getMemberGrade().equals("A")||TradeBoardDAO.getInstance().getBoardContent(boardNo).getMemberId().equals(MemberService.memberInfo.getMemberId())) {
			
		System.out.println("수정할 제목 입력 > ");
		String boardTitle = sc.nextLine();
		
		TradeBoard tradeboard = new TradeBoard();
		tradeboard.setBoardNo(boardNo);
		tradeboard.setBoardTitle(boardTitle);
		
		TradeBoardDAO.getInstance().boardTitleEdit(tradeboard);
		}else {
			System.out.println("본인만 가능");
		}
		
	}
	
	public void boardContentEdit() {
		System.out.println("내용 수정할 글 번호 입력 >  ");
		int boardNo = Integer.parseInt(sc.nextLine());
		if(MemberService.memberInfo.getMemberGrade().equals("A") || TradeBoardDAO.getInstance().getBoardContent(boardNo).getMemberId().equals(MemberService.memberInfo.getMemberId())){
			System.out.println("수정할 내용 입력 > ");
			String boardContent = sc.nextLine();
			
			TradeBoard tradeboard = new TradeBoard();
			tradeboard.setBoardNo(boardNo);
			tradeboard.setBoardContent(boardContent);
			
			TradeBoardDAO.getInstance().boardContentEdit(tradeboard);
		}else {
			System.out.println("본인만 가능");
		}
	}
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(수정됨)");
//		Date boardDate = sdf.format(boardInfo.getBoardDate());
//		board.setBoardDate(boardDate);
		
		
		
	
	public void boardDelete() {
		
		System.out.println("삭제할 게시글 번호 입력 > ");
		int boardNo = Integer.parseInt(sc.nextLine());
		
		if(MemberService.memberInfo.getMemberGrade().equals("A") || BoardDAO.getInstance().getBoardContent(boardNo).getMemberId().equals(MemberService.memberInfo.getMemberId())) {
			TradeBoardDAO.getInstance().boardDelete(boardNo);
			System.out.println("삭제 완료");
		}else {
			System.out.println("본인만 가능");
		}
	}
	
	
	public void tradeNow() {
		List<TradeBoard> list = TradeBoardDAO.getInstance().getTradeBoardList2();
		if(list.isEmpty()) {
			System.out.println("                    게시글 없음          ");
		}else {
		for(TradeBoard bd : list) {
			System.out.print("|"+bd.getBoardNo()+"\t");
			System.out.print("|"+bd.getBoardTitle()+"\t\t");
			System.out.print("|"+bd.getMemberFname()+"\t");
			System.out.print("|"+bd.getBoardDate()+"\t");
			System.out.print("|"+bd.getTradeIng()+"\t");
			System.out.print("|"+bd.getBoardViews()+"\t");
			System.out.println();
			}
		
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
