package com.dev;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.drill.jdbc.Driver;

public class TestJDBC {

	/*
	 * Use this; if we want zookeeper to start drill automatically
	 */
	public static final String DRILL_JDBC_LOCAL_URI = "jdbc:drill:zk=local";

	// public static final String DRILL_JDBC_LOCAL_URI =
	// "jdbc:drill:drillbit=192.168.145.151";

	public static final String JDBC_DRIVER = "org.apache.drill.jdbc.Driver";

	public static void main(String[] args) throws SQLException {

		Driver.load();

		try {
			Class.forName(JDBC_DRIVER);

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}

		try (Connection conn = new Driver().connect(DRILL_JDBC_LOCAL_URI, null);
				Statement stmt = conn.createStatement();) {

			String sql = "select employee_id,first_name,last_name from cp.`employee.json` limit 10";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt("employee_id") + "\t");
				System.out.print(rs.getString("first_name") + "\t");
				System.out.print(rs.getString("last_name") + "\t");
				System.out.println();
			}
			rs.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
