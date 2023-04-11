package com.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardService {
	public static Board boardInfo = null;
	Scanner sc = new Scanner(System.in);
		int menu = 0;
		
	
	
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
	
	public void getBoardList() {
		List<Board> list = BoardDAO.getInstance().getBoardList();
		for(Board bd : list) {
			System.out.print("|"+bd.getBoardNo()+"\t");
			System.out.print("|"+bd.getBoardTitle()+"\t\t");
			System.out.print("|"+bd.getMemberFname()+"\t");
			System.out.print("|"+bd.getBoardDate()+"\t");
			System.out.print(bd.getBoardViews()+"\t");
			System.out.println();
		}
		
	}
	
	public void getBoardContent() {
		System.out.println("읽을 게시글 번호 입력 > ");
		int boardNo = Integer.parseInt(sc.nextLine());
		Board bd = BoardDAO.getInstance().getBoardContent(boardNo);
		System.out.println("=====================================");
		System.out.println("            "+ bd.getBoardTitle());
		System.out.println(bd.getBoardNo()+ "      " + bd.getMemberFname()+bd.getBoardDate()+bd.getBoardViews());
		System.out.println("=====================================");
		System.out.println(" " +bd.getBoardContent());
		System.out.println("=====================================");
		
	}
	
	
	
	
	
	
	
	
	
		
}
