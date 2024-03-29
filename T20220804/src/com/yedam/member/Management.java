package com.yedam.member;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class Management extends DAO {
	
	public Management() {
		// 전체조회
//		showInfo();
		// 1건 조회
//		getMember();
//		// 1건 입력
//		insertInfo();
//		// 1건 수정
//		updateInfo();
		// 삭제
		deleteInfo();

	}
	// 삭제
	private void deleteInfo() {
		int result = 0;
		try {
			conn();
			String sql = "delete from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "A");
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		if (result == 1) {
			System.out.println(result + "건이 삭제되었습니다.");
		}else {
			System.out.println("삭제되지 않았습니다.");
		} 
	}
	// 1건 수정
	private void updateInfo() {
		int result = 0;
		try {
			// 1. db연결
			conn();
			// 2. query 작성
			String sql = "update member set pw=? where id = ?";

			// 3. 창구 및 query 생성
			pstmt = conn.prepareStatement(sql);

			// 4. 데이터 입력
			pstmt.setString(1, "4321");
			pstmt.setString(2, "A");
			// 5. 실행
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		if (result == 1) {
			System.out.println(result + "건이 수정되었습니다.");
		} else {
			System.out.println("수정되지 않았습니다.");
		}
	}

	// 1건 입력
	private void insertInfo() {
		int result = 0;

		try {
			// 1. db연결
			conn();
			// 2. query 작성
			String sql = "insert into member values(?,?,?)";
			// 3. 창구 생성
			pstmt = conn.prepareStatement(sql);
			// 4. query 데이터 입력
			pstmt.setString(1, "F");
			pstmt.setString(2, "1234");
			pstmt.setString(3, "김씨");

			// DML (insert,update, delete) - > executeUpdate()
			// Select -> executeQuery()
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		if (result == 1) {
			System.out.println("정상 입력되었습니다.");
		} else {
			System.out.println("입력에 실패하였습니다.");
		}
	}

	// 1건 조회
	private void getMember() {
		Member member = null;
		try {
			// 1. DB 연결
			conn();
			// 2. query문 작성
			String sql = "select * from member where id = ?";
			// 3. 창구를 만드는 동시에 query문 보냄.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "A"); // 첫번째 물음표에는 "A"를 넣어라.
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		System.out.println("********************************");
		System.out.println(member.toString());
	}

	// 전체조회
	// Member 여러 건.
	private void showInfo() {
		List<Member> list = new ArrayList<>();
		Member mem = null; // Member 인스턴스 생성.

		try {
			// 1. conn() 메소드로 DB 연결
			conn();

			// 2. query 작성
			String sql = "select * from member"; // "실제로 쓰는 query문" 작성

			// 3. 연결된 DB(java<->Database)에 query문 보낼 수 있는 창구 생성
			stmt = conn.createStatement();

			// 4. 3번에서 만든 창구로 query문을 보냄.
			// ResultSet(rs) select 조회할때만 사용.
			rs = stmt.executeQuery(sql);
			while (rs.next()) { // rs.next() : 시작점에서 아래쪽에 데이터가 있는지 조회하는 메소드. 데이터가 있으면 true / 없으면 false(반복문종료)
				mem = new Member();
				mem.setId(rs.getString("id")); // rs.getString("컬럼명");
				mem.setName(rs.getString("name"));
				mem.setPw(rs.getString("pw"));
				list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 성공하던 못하던 실행하는 것.
			disconnect();
		}

		for (Member member : list) {
			System.out.println(member.toString());
		}
	}
}
