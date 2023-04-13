package com.yedam.board;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.member.MemberService;

public class BoardrepDAO extends DAO{
	
	private static BoardrepDAO boardrepDao = new BoardrepDAO();
	
	private BoardrepDAO() {
		
	}
	
	public static BoardrepDAO getInstance() {
		return boardrepDao;
	}
	
	public List<Boardrep> getBoardList(int boardNo){
		List<Boardrep> list = new ArrayList<>();
		Boardrep br = null;
		
		try {
			conn();
			String sql = "select * from reply where board_no = ? order by rep_no";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				br = new Boardrep();
				br.setMemberId(rs.getString("member_id"));
				br.setMemberFname(rs.getString("member_fname"));
				br.setRepNo(rs.getInt("rep_no"));
				br.setRepContent(rs.getString("rep_content"));
				br.setRepDate(rs.getDate("rep_date"));
				list.add(br);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return list;
	}
	
	public void boardrepAdd(Boardrep boardrep) {
		int  result = 0;
		
		try {
			conn();
			String sql = "insert into reply values (?,?,(SELECT NVL(MAX(rep_no)+1,1) FROM reply where board_no = ?),?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			pstmt.setString(2, MemberService.memberInfo.getMemberFname());
			pstmt.setInt(3, BoardService.boardInfo.getBoardNo());
			pstmt.setInt(4, BoardService.boardInfo.getBoardNo());
			pstmt.setString(5, boardrep.getRepContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
	}
	
	public void boardRepContentEdit(Boardrep boardrep) {
		int result = 0;
		
		try {
			conn();
			String sql = "update reply set rep_content = ? where rep_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardrep.getRepContent());
			pstmt.setInt(2, boardrep.getRepNo());
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
	
	public int boardRepDelete(int repNo) {
		int result = 0;
		
		try {
			conn();
			String sql = "delete from reply where rep_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, repNo);
			result = pstmt.executeUpdate();
			
			String sql2 = "update reply set rep_no = rep_no - 1 where rep_no > ?";
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
	
	public Boardrep boardRepCheck(int repNo) {
		Boardrep br = null;
		try {
			conn();
			String sql = "select * from reply where rep_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, repNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				br = new Boardrep();
				br.setRepNo(rs.getInt("rep_no"));
				br.setMemberFname(rs.getString("member_fname"));
				br.setRepContent(rs.getString("rep_content"));
				br.setMemberId(rs.getString("member_id"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return br;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
