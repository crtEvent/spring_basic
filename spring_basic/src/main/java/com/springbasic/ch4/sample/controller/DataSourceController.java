package com.springbasic.ch4.sample.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ds")
public class DataSourceController {

	@Autowired(required = true)
	DriverManagerDataSource dataSource;

	// MySQL DB 연결 확인
	@RequestMapping(value = "/testDataSource")
	public String testDataSource() {

		System.out.println("MySQL 연결 테스트");

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT NOW() AS NOW;");
			while (rs.next()) {
				System.out.println("servertime: " + rs.getString("now"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "";
	}

}
