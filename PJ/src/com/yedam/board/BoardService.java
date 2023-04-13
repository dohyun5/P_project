package com.yedam.board;

import java.util.List;
import java.util.Scanner;

import com.yedam.member.MemberService;

public class BoardService {
	Scanner sc = new Scanner(System.in);
	public static Board boardInfo = null;
	BoardrepService br = new BoardrepService();
	
	public void getBoardList() {
		List<Board> list = BoardDAO.getInstance().getBoardList();
		if(list.isEmpty()) {
			System.out.println("                    게시글 없음          ");
		}else {
			for(Board bd : list) {
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
		
		Board board = new Board();
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		
		BoardDAO.getInstance().boardAdd(board);
		
	}
	
	
	public void getBoardContent() {
		System.out.println("읽을 게시글 번호 입력 > ");
		int boardNo = Integer.parseInt(sc.nextLine());
		Board bd = BoardDAO.getInstance().getBoardContent(boardNo);
//		System.out.println("=====================================");
//		System.out.println("            "+ bd.getBoardTitle());
//		System.out.println(bd.getBoardNo()+ "      " + bd.getMemberFname()+bd.getBoardDate()+bd.getBoardViews());
//		System.out.println("=====================================");
//		System.out.println(" " +bd.getBoardContent());
		boardInfo = bd;
	}
	
	
	
	
	public void getBoardContent2() {
		int boardNo = BoardService.boardInfo.getBoardNo();
		Board bd = BoardDAO.getInstance().getBoardContent(boardNo);
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
		br.getBoardRepList();
	}
	
	
	
	public void boardTitleEdit() {
		System.out.println("제목 수정할 글 번호 입력 >  ");
		int boardNo = Integer.parseInt(sc.nextLine());
		if (MemberService.memberInfo.getMemberGrade().equals("A")||BoardDAO.getInstance().getBoardContent(boardNo).getMemberId().equals(MemberService.memberInfo.getMemberId())) {
			
		System.out.println("수정할 제목 입력 > ");
		String boardTitle = sc.nextLine();
		
		Board board = new Board();
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		
		BoardDAO.getInstance().boardTitleEdit(board);
		}else {
			System.out.println("본인만 가능");
		}
		
	}
	
	public void boardContentEdit() {
		System.out.println("내용 수정할 글 번호 입력 >  ");
		int boardNo = Integer.parseInt(sc.nextLine());
		if(MemberService.memberInfo.getMemberGrade().equals("A") || BoardDAO.getInstance().getBoardContent(boardNo).getMemberId().equals(MemberService.memberInfo.getMemberId())){
			System.out.println("수정할 내용 입력 > ");
			String boardContent = sc.nextLine();
			
			Board board = new Board();
			board.setBoardNo(boardNo);
			board.setBoardContent(boardContent);
			
			BoardDAO.getInstance().boardContentEdit(board);
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
			BoardDAO.getInstance().boardDelete(boardNo);
			System.out.println("삭제 완료");
		}else {
			System.out.println("본인만 가능");
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
