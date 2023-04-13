package com.yedam.tradeBoard;

import java.util.ArrayList;
import java.util.List;

import com.yedam.board.BoardService;
import com.yedam.common.DAO;
import com.yedam.member.MemberService;

public class TradeBoardrepDAO extends DAO{
	
private static TradeBoardrepDAO tradeboardrepDao = new TradeBoardrepDAO();
	

	private TradeBoardrepDAO() {
		
	}
	
	public static TradeBoardrepDAO getInstance() {
		return tradeboardrepDao;
	}
	
	public List<TradeBoardrep> gettradeBoardList(int boardNo){
		List<TradeBoardrep> list = new ArrayList<>();
		TradeBoardrep tbr = null;
		
		try {
			conn();
			String sql = "select * from tradereply where board_no = ? order by rep_no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				tbr = new TradeBoardrep();
				tbr.setMemberId(rs.getString("member_id"));
				tbr.setMemberFname(rs.getString("member_fname"));
				tbr.setRepNo(rs.getInt("rep_no"));
				tbr.setRepContent(rs.getString("rep_content"));
				tbr.setRepDate(rs.getDate("rep_date"));
				list.add(tbr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public void tradeboardrepAdd(TradeBoardrep tradeboardrep) {
		int  result = 0;
		
		try {
			conn();
			String sql = "insert into tradereply values (?,?,(SELECT NVL(MAX(rep_no)+1,1) FROM tradereply where board_no = ?),?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			pstmt.setString(2, MemberService.memberInfo.getMemberFname());
			pstmt.setInt(3, TradeBoardService.tradeboardInfo.getBoardNo());
			pstmt.setInt(4, TradeBoardService.tradeboardInfo.getBoardNo());
			pstmt.setString(5, tradeboardrep.getRepContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
	}
	
	public void tradeboardRepContentEdit(TradeBoardrep tradeboardrep) {
		int result = 0;
		
		try {
			conn();
			String sql = "update tradereply set rep_content = ? where rep_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tradeboardrep.getRepContent());
			pstmt.setInt(2, tradeboardrep.getRepNo());
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("수정 성공");
			}else {
				System.out.println("수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
	}
	
	public int tradeboardRepDelete(int repNo) {
		int result = 0;
		
		try {
			conn();
			String sql = "delete from tradereply where rep_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, repNo);
			result = pstmt.executeUpdate();
			
			String sql2 = "update tradereply set rep_no = rep_no - 1 where rep_no > ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, repNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	public TradeBoardrep tradeboardRepCheck(int repNo) {
		TradeBoardrep tbr = null;
		try {
			conn();
			String sql = "select * from tradereply where rep_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, repNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				tbr = new TradeBoardrep();
				tbr.setRepNo(rs.getInt("rep_no"));
				tbr.setMemberFname(rs.getString("member_fname"));
				tbr.setRepContent(rs.getString("rep_content"));
				tbr.setMemberId(rs.getString("member_id"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return tbr;
	}
		
	
	
	
	
}
