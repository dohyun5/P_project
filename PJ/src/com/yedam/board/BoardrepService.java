package com.yedam.board;

import java.util.List;
import java.util.Scanner;

public class BoardrepService {
	
	Scanner sc = new Scanner(System.in);
	
	
	public void getBoardRepList() {
		int boardNo = BoardService.boardInfo.getBoardNo();
		List<Boardrep> list = BoardrepDAO.getInstance().getBoardList(boardNo);
		if(list.isEmpty()) {
			System.out.println("           댓글 없음         ");
			System.out.println("=====================================");
		}else {
			for(Boardrep br : list) {
				System.out.print("|"+br.getRepNo()+"\t");
				System.out.print("|"+br.getRepContent()+"\t");
				System.out.print("|"+br.getMemberFname()+"\t");
				System.out.print("|"+br.getRepDate()+"\t");
				System.out.println();
			}
			System.out.println("=====================================");
		}
	}
	
	public void boardRepAdd() {
		
		System.out.println("내용 입력 > ");
		String boardRepContent = sc.nextLine();
		
		Boardrep boardrep = new Boardrep();
		boardrep.setRepContent(boardRepContent);
		
		BoardrepDAO.getInstance().boardrepAdd(boardrep);
		
		
		
		
	}
		
	public void boardRepContentEdit() {
		System.out.println("수정할 댓글 번호 입력 > ");
		int RepNo = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 내용 입력 > ");
		String boardRepContent = sc.nextLine();
		
		Boardrep boardrep = new Boardrep();
		boardrep.setRepNo(RepNo);
		boardrep.setRepContent(boardRepContent);
		
		BoardrepDAO.getInstance().boardRepContentEdit(boardrep);
		
	}
	
	public void boardRepDelete() {
		System.out.println("삭제할 댓글 번호 입력 > ");
		int repNo = Integer.parseInt(sc.nextLine());
		
		int result = BoardrepDAO.getInstance().boardRepDelete(repNo);
		if(result > 0) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
