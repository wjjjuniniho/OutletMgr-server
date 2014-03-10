package tongji.sse.outletmanager.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tongji.sse.outletmanager.database.DBSchema;
import tongji.sse.outletmanager.database.DatabaseConfig;
import tongji.sse.outletmanager.database.ErrorMessage;
import tongji.sse.outletmanager.datamodel.AuthenticationStatusObject;

import tongji.sse.outletmanager.servlet.util.AuthorityEnumHelper;

public class AuthenticationStatusObjectDBHelper {
	public static AuthenticationStatusObject getAuthenticationStatusObject(
			String storeId, String username, String password) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preStmt = null;
		String sql = null;

		AuthenticationStatusObject authenticationStatusObject = null;
		String authority = null;

		try {
			Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DATABASE_URL,
					DatabaseConfig.DATABASE_USERNAME,
					DatabaseConfig.DATABASE_PASSWORD);

			sql = "SELECT" + " " + "*" + " " + "FROM" + " "
					+ DBSchema.Employee.TABLE_NAME + " " + "WHERE" + " "
					+ DBSchema.Employee.STORE_ID + "=" + "?" + " " + "AND"
					+ " " + DBSchema.Employee.USERNAME + "=" + "?" + " "
					+ "AND" + " " + DBSchema.Employee.PASSWORD + "=" + "?";

			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, storeId);
			preStmt.setString(2, username);
			preStmt.setString(3, password);
			rs = preStmt.executeQuery();

			if (rs.next()) {
				authority = rs.getString(DBSchema.Employee.AUTHORITY);
			} else {
				// no storage found
				authenticationStatusObject = new AuthenticationStatusObject(
						ErrorMessage.ERR_AUTHENTICATION_NOT_VALID);
				return authenticationStatusObject;
			}

			authenticationStatusObject = new AuthenticationStatusObject(
					username, AuthorityEnumHelper.toAuthorityEnum(authority));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			authenticationStatusObject = new AuthenticationStatusObject(e
					.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			authenticationStatusObject = new AuthenticationStatusObject(e
					.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (preStmt != null) {
					preStmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				authenticationStatusObject = new AuthenticationStatusObject(e
						.getMessage());
			}
		}
		return authenticationStatusObject;
	}
}
