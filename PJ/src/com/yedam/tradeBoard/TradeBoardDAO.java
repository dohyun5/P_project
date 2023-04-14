package com.yedam.tradeBoard;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

public class TradeBoardDAO extends DAO{
private static TradeBoardDAO tradeboardDao = new TradeBoardDAO();
	
	private TradeBoardDAO() {
		
	}
		
	public static TradeBoardDAO getInstance() {
		return tradeboardDao;
	}
	
	
	
	
	
	public List<TradeBoard> getTradeBoardList(){
		List<TradeBoard> list = new ArrayList<>();
		TradeBoard bd = null;

		try {
			conn();
			String sql = "select * from tradeboard ORDER BY board_no";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				bd = new TradeBoard();
				bd.setMemberId(rs.getString("member_id"));
				bd.setMemberFname(rs.getString("member_fname"));
				bd.setMemberGrade(rs.getString("member_Grade"));
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setBoardTitle(rs.getString("board_title"));
				bd.setBoardContent(rs.getString("board_content"));
				bd.setBoardDate(rs.getDate("board_date"));
				bd.setBoardViews(rs.getInt("board_views"));
				bd.setTradeIng(rs.getString("trade_ing"));
				bd.setTradeFname(rs.getString("trade_fname"));
				list.add(bd);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return list;
		
		
	}
	
	public void boardAdd(TradeBoard board) {
		int result = 0;
		
		try {
			conn();
			String sql = "insert into tradeboard values (?,?,?,(SELECT NVL(MAX(board_no)+1,1) FROM tradeboard),?,?,sysdate,0,'판매중','없음')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			pstmt.setString(2, MemberService.memberInfo.getMemberFname());
			pstmt.setString(3, MemberService.memberInfo.getMemberGrade());
			pstmt.setString(4, board.getBoardTitle());
			pstmt.setString(5, board.getBoardContent());
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("등록 성공");
			}else {
				System.out.println("등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
	}
	
	public TradeBoard getBoardContent(int boardNo) {
		TradeBoard bd = null;
		
		try { 
			conn();
			String sql = "select * from tradeboard where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			String sql2 = "update tradeboard set board_views = board_views+1 where board_no = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, boardNo);
			int result = pstmt.executeUpdate();
			
			if(rs.next()) {
				bd = new TradeBoard();
				
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setBoardTitle(rs.getString("board_title"));
				bd.setMemberFname(rs.getString("member_fname"));
				bd.setBoardContent(rs.getString("board_content"));
				bd.setBoardDate(rs.getDate("board_date"));
				bd.setBoardViews(rs.getInt("board_views"));
				bd.setMemberId(rs.getString("member_id"));
				bd.setTradeFname(rs.getString("trade_fname"));
				bd.setTradeIng(rs.getString("trade_ing"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return bd;
		
	}
	
	public void boardTitleEdit(TradeBoard board) {
		int result = 0;
		
		try {
			conn();
			String sql = "update tradeboard set board_title = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setInt(2, board.getBoardNo());
			
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
	
	public void boardContentEdit(TradeBoard board) {
		int result = 0;
		
		try {
			conn();
			String sql = "update tradeboard set board_content = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardContent());
			pstmt.setInt(2, board.getBoardNo());
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
	
	public int boardDelete(int boardNo) {
		int result = 0;
			
		try {
			conn();
			
			
			String sql = "delete from tradeboard where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
			
			String sql2 = "UPDATE tradeboard SET board_no = board_no - 1 WHERE board_no > ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, boardNo);
			//pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	
	public List<TradeBoard> getTradeBoardList2(){
		List<TradeBoard> list = new ArrayList<>();
		TradeBoard bd = null;

		try {
			conn();
			String sql = "select * from tradeboard where member_id = ? or trade_fname = ? ORDER BY board_no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			pstmt.setString(2, MemberService.memberInfo.getMemberFname());
			rs = pstmt.executeQuery();
			
			
			
			
			while(rs.next()) {
				bd = new TradeBoard();
				bd.setMemberId(rs.getString("member_id"));
				bd.setMemberFname(rs.getString("member_fname"));
				bd.setMemberGrade(rs.getString("member_Grade"));
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setBoardTitle(rs.getString("board_title"));
				bd.setBoardContent(rs.getString("board_content"));
				bd.setBoardDate(rs.getDate("board_date"));
				bd.setBoardViews(rs.getInt("board_views"));
				bd.setTradeIng(rs.getString("trade_ing"));
				bd.setTradeFname(rs.getString("trade_fname"));
				list.add(bd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public int getTradeIng(TradeBoard board) {
		int result = 0;
		
		try {
			conn();
			String sql = "update tradeboard set trade_ing = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTradeIng());
			pstmt.setInt(2, board.getBoardNo());
			result = pstmt.executeUpdate();
			
			String sql2 = "update tradeboard set trade_fname = ? where board_no = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, board.getTradeFname());
			pstmt.setInt(2, board.getBoardNo());
			pstmt.executeUpdate();
			
			
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
		return result;
	}
	
	
	public TradeBoard getBoardContent2(String memberId) {
		
		TradeBoard bd = null;
		
		try { 
			conn();
			String sql = "select * from tradeboard where member_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bd = new TradeBoard();
				
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setBoardTitle(rs.getString("board_title"));
				bd.setMemberFname(rs.getString("member_fname"));
				bd.setBoardContent(rs.getString("board_content"));
				bd.setBoardDate(rs.getDate("board_date"));
				bd.setBoardViews(rs.getInt("board_views"));
				bd.setMemberId(rs.getString("member_id"));
				bd.setTradeFname(rs.getString("trade_fname"));
				bd.setTradeIng(rs.getString("trade_ing"));
				bd = TradeBoardService.tradeboardInfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return bd;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 //fname일치하면 불러오
	
	
	
	
	
	
//	
//	public void updateTrade() {
//		
//		try {
//			conn();
//			String sql = "update tradeboard set board_title = board_title + ? where board_no = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, tradeIng);
//			pstmt.setInt(2, boardNo);
//			result = pstmt.executeUpdate();
//			
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			disconn();
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
