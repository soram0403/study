package com.yedam.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DAO {
	// DAO
	// Data Access Object // 데이터 연결하는 통로 연결에 필요한 객체

	// java <-> DB 연결할 때 쓰는 객체
	protected Connection conn = null;

	// Select(조회) 결과 값 반환 받는 객체
	protected ResultSet rs = null;

	// Query문을 담고, Query문 실행하는 객체
	protected PreparedStatement pstmt = null; // DML문 쓰기에 편함.
	Properties pro = new Properties();

	protected Statement stmt = null; // select문 쓰기에 편함

	// 데이터베이스에 접속할때 필요한 정보.
	String driver = "";
	String url = "";
	String id = "";
	String pw = "";

	// 메소드
	// DB 연결
	public void conn() {
		try {
			getProperties();
			// 1. 드라이버 로딩
			Class.forName(driver);
			// 2. DB 연결
			conn = DriverManager.getConnection(url, id, pw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB 연결 끊기
	public void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void getProperties() {
		try {
			FileReader resource = new FileReader("src/config/db.properties");
			pro.load(resource);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			id = pro.getProperty("id");
			pw = pro.getProperty("pw");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
