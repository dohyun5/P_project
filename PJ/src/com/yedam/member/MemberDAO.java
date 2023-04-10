package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class MemberDAO extends DAO{

	private static MemberDAO memberDao = new MemberDAO();
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return memberDao;
	}
	public Member login(String id) {
		Member member = null;
		
		try {
			conn();
			String sql = "select * from member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getNString("member_pw"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemberFname(rs.getString("member_fname"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
		
	}
	
	public Member login2(String fname) {
		Member member = null;
		
		try {
			conn();
			String sql = "select * from member where member_fname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fname);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPw(rs.getNString("member_pw"));
				member.setMemberGrade(rs.getString("member_grade"));
				member.setMemberFname(rs.getString("member_fname"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return member;
		
	}
	
	public void memberAdd(Member member) {
		int result = 0;
		
		try {
			conn();
			String sql = "insert into member VALUES (?,?,?,?,'없음','C')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberFname());

			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println("등록 성공");
			}else {
				System.out.println("등록 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		
	}
	
	public List<Member> getMemberList(){
		List<Member> list = new ArrayList<>();
		Member mem = null;
		
		try {
			conn();
			String sql = "select * from member";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mem = new Member();
				
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberFname(rs.getString("member_fname"));
				mem.setMemberDv(rs.getString("member_dv"));
				mem.setMemberGrade(rs.getString("member_grade"));
				list.add(mem);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	public Member getMember(String memberId) {
		Member mem = null;
		
		try {
			conn();
			String sql = "select * from member where member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberFname(rs.getString("member_fname"));
				mem.setMemberDv(rs.getString("member_dv"));
				mem.setMemberGrade(rs.getString("member_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return mem;
	}
	
	public List<Member> getMemberG(String memberGrade){
		List<Member> list = new ArrayList<>();
		Member mem = null;
		try {
			conn();
			String sql = "select * from member where member_grade = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberGrade);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new Member();
				
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberFname(rs.getString("member_fname"));
				mem.setMemberDv(rs.getString("member_dv"));
				mem.setMemberGrade(rs.getString("member_grade"));
				list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	public List<Member> getMemberDv(String memberDv){
		List<Member> list = new ArrayList<>();
		Member mem = null;
		try {
			conn();
			String sql = "select * from member where member_dv = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDv);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mem = new Member();
				
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
				mem.setMemberName(rs.getString("member_name"));
				mem.setMemberFname(rs.getString("member_fname"));
				mem.setMemberDv(rs.getString("member_dv"));
				mem.setMemberGrade(rs.getString("member_grade"));
				list.add(mem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}
	
	public int memberPwUpdate(Member member) {
		int result = 0;
		try {
			conn();
				String sql = "update member set member_pw = ? where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberPw());
				pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			disconn();
		}
		
		return result;
	}
	
	
	public int memberFnameUpdate(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update member set member_fname = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberFname());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			disconn();
		}
		
		return result;
	}
	
	public int memberGradeUpdate(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update member set member_grade = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberGrade());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			disconn();
		}
		
		return result;
	}
	
	public int memberDvUpdate(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update member set member_dv = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberDv());
			pstmt.setString(2, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			disconn();
		}
		
		return result;
	}
	
	
	
	public int memberPwUpdate2(Member member) {
		int result = 0;
		try {
			conn();
				String sql = "update member set member_pw = ? where member_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getMemberPw());
				pstmt.setString(2, MemberService.memberInfo.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			disconn();
		}
		
		return result;
	}
	
	public int memberFnameUpdate2(Member member) {
		int result = 0;
		try {
			conn();
			String sql = "update member set member_fname = ? where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberFname());
			pstmt.setString(2, MemberService.memberInfo.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			disconn();
		}
		
		return result;
	}
	
	public int nowDv(Member member) {
		int result = 0;
		
		try {
			conn();
			String sql = "select member_dv from member where member_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MemberService.memberInfo.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
