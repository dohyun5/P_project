package com.yedam.tradeBoard;

import java.util.List;
import java.util.Scanner;

import com.yedam.board.Board;
import com.yedam.board.BoardDAO;
import com.yedam.board.BoardService;
import com.yedam.member.MemberDAO;
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
			System.out.print("|"+bd.getTradeIng()+"   ");
			System.out.print(bd.getBoardViews()+"\t");
			System.out.println();
			tradeboardInfo = bd;
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
		System.out.println("=======================================");
		System.out.println("            "+ bd.getBoardTitle());
		System.out.println("|"+bd.getBoardNo()+ "\t\t" +"| "+ bd.getMemberFname()+"| "+bd.getBoardDate());
		System.out.println("=======================================");
		System.out.println("\t" +bd.getBoardContent());
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("=======================================");
		//br.getBoardRepList();
	}
	
	public void getBoardContent3() {
		String memberId = MemberService.memberInfo.getMemberId();
		TradeBoard bd = TradeBoardDAO.getInstance().getBoardContent2(memberId);
		bd = TradeBoardService.tradeboardInfo;
	}
	
	
	
	
	
	
	
	public void getRep() {
		System.out.println("====================댓글=====================");
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
			System.out.print("|"+bd.getTradeIng()+"    ");
			System.out.print("|"+bd.getBoardViews()+"\t");
			System.out.println();
			}
		}
	}
	
	public void tradeChange() {
		System.out.println("정보 수정할 게시글 번호 입력 > ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		String id = TradeBoardDAO.getInstance().getBoardContent(boardNo).getMemberId();
		
		if (id.equals(MemberService.memberInfo.getMemberId())) {
			if(TradeBoardDAO.getInstance().getBoardContent(boardNo).getTradeIng().equals("거래완료")) {
				System.out.println("이미 완료처리된 게시글 입니다");
			}else {
				System.out.println("거래 상태를 입력하세요 > ");
				String tradeNow = sc.nextLine();
				if(tradeNow.equals("거래완료")) {
					System.out.println("완료처리 되었습니다");
					TradeBoard tradeboard = new TradeBoard();
					tradeboard.setBoardNo(boardNo);
					tradeboard.setTradeIng(tradeNow);
					int result2 = TradeBoardDAO.getInstance().getTradeIng(tradeboard);
					if(result2 > 0) {
						System.out.println("변경 성공");
					}else {
						System.out.println("변경 실패");
					}
				}else {
					System.out.println("구매자의 활동명을 입력하세요 > ");
					String tradeFname = sc.nextLine();
					
					TradeBoard tradeboard = new TradeBoard();
					tradeboard.setBoardNo(boardNo);
					tradeboard.setTradeFname(tradeFname);
					tradeboard.setTradeIng(tradeNow);
					
					int result = TradeBoardDAO.getInstance().getTradeIng(tradeboard);
					if(result > 0) {
						System.out.println("변경 성공");
					}else {
						System.out.println("변경 실패");
					}
				}
			}
			
		}else {
			System.out.println("작성자만 가능");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
