package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

public class BoardDAO extends DAO{
	
private static BoardDAO boardDao = new BoardDAO();
	
	private BoardDAO() {
		
	}
		
	public static BoardDAO getInstance() {
		return boardDao;
	}
	
	
	public void boardAdd(Board board) {
		int result = 0;
		
		try {
			conn();
			String sql = "insert into board values (?,?,?,(SELECT NVL(MAX(board_no)+1,1) FROM board),?,?,sysdate,0)";
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
	
	
	
	
	public List<Board> getBoardList(){
		List<Board> list = new ArrayList<>();
		Board bd = null;

		try {
			conn();
			String sql = "select * from board";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				bd = new Board();
				bd.setMemberId(rs.getString("member_id"));
				bd.setMemberFname(rs.getString("member_fname"));
				bd.setMemberGrade(rs.getString("member_Grade"));
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setBoardTitle(rs.getString("board_title"));
				bd.setBoardContent(rs.getString("board_content"));
				bd.setBoardDate(rs.getDate("board_date"));
				bd.setBoardViews(rs.getInt("board_views"));
				list.add(bd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return list;
		
		
	}
	
	public Board getBoardContent(int boardNo) {
		Board bd = null;
		
		try {
			conn();
			String sql = "select * from board where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bd = new Board();
				
				bd.setBoardNo(rs.getInt("board_no"));
				bd.setBoardTitle(rs.getString("board_title"));
				bd.setMemberFname(rs.getString("member_fname"));
				bd.setBoardContent(rs.getString("board_content"));
				bd.setBoardDate(rs.getDate("board_date"));
				bd.setBoardViews(rs.getInt("board_views"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return bd;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
