package com.yedam.tradeBoard;

import java.util.List;
import java.util.Scanner;

import com.yedam.board.BoardService;
import com.yedam.member.MemberService;


public class TradeBoardrepService {
	
Scanner sc = new Scanner(System.in);
	
	public void gettradeBoardRepList() {
		int boardNo = TradeBoardService.tradeboardInfo.getBoardNo();
		List<TradeBoardrep> list = TradeBoardrepDAO.getInstance().gettradeBoardList(boardNo);
		if(list.isEmpty()) {
			System.out.println("               댓글 없음         ");
			System.out.println("=============================================");
		}else {
			for(TradeBoardrep br : list) {
				System.out.print("|"+br.getRepNo()+"\t");
				System.out.print("|"+br.getRepContent()+"\t");
				System.out.print("|"+br.getMemberFname()+"\t");
				System.out.print("|"+br.getRepDate()+"\t");
				System.out.println();
			}
			System.out.println("=============================================");
		}
	}
	
	public void tradeboardRepAdd() {
		
		System.out.println("내용 입력 > ");
		String tradeboardRepContent = sc.nextLine();
		
		TradeBoardrep tradeboardrep = new TradeBoardrep();
		tradeboardrep.setRepContent(tradeboardRepContent);
		
		TradeBoardrepDAO.getInstance().tradeboardrepAdd(tradeboardrep);
	}
		
	public void tradeboardRepContentEdit() {
		System.out.println("수정할 댓글 번호 입력 > ");
		int repNo = Integer.parseInt(sc.nextLine());
		if(MemberService.memberInfo.getMemberGrade().equals("A") || TradeBoardrepDAO.getInstance().tradeboardRepCheck(repNo).getMemberId().equals(MemberService.memberInfo.getMemberId())) {
			
		System.out.println("수정할 내용 입력 > ");
		String tradeboardRepContent = sc.nextLine();
		
		TradeBoardrep tradeboardrep = new TradeBoardrep();
		tradeboardrep.setRepNo(repNo);
		tradeboardrep.setRepContent(tradeboardRepContent);
		
		TradeBoardrepDAO.getInstance().tradeboardRepContentEdit(tradeboardrep);
		}else {
			System.out.println("본인만 가능");
		}
	}
		
	
	public void tradeboardRepDelete() {
		System.out.println("삭제할 댓글 번호 입력 > ");
		int repNo = Integer.parseInt(sc.nextLine());
		//int boardNo = BoardService.boardInfo.getBoardNo();
		if(MemberService.memberInfo.getMemberGrade().equals("A")|| TradeBoardrepDAO.getInstance().tradeboardRepCheck(repNo).getMemberId().equals(MemberService.memberInfo.getMemberId())) {
			int result = TradeBoardrepDAO.getInstance().tradeboardRepDelete(repNo);
			if(result > 0) {
				System.out.println("삭제 완료");
				result = 0;
			}else {
				System.out.println("삭제 실패");
			}
		}else {
			System.out.println("본인만 가능");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
