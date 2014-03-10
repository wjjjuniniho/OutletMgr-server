package tongji.sse.outletmanager.database.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tongji.sse.outletmanager.database.DBSchema;
import tongji.sse.outletmanager.database.DatabaseConfig;
import tongji.sse.outletmanager.datamodel.MerchandiseCheckoutObject;
import tongji.sse.outletmanager.datamodel.MerchandiseCheckoutOrder;
import tongji.sse.outletmanager.datamodel.StatusObject;

public class MerchandiseCheckoutOrderDBHelper {
	public static StatusObject checkoutMerchandiseOrder(
			MerchandiseCheckoutOrder order) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preStmt = null;
		String sql = null;

		StatusObject statusObject = null;

		try {
			Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DATABASE_URL,
					DatabaseConfig.DATABASE_USERNAME,
					DatabaseConfig.DATABASE_PASSWORD);
			conn.setAutoCommit(false);

			sql = "UPDATE " + DBSchema.Storage.TABLE_NAME + " SET "
					+ DBSchema.Storage.STORAGE + "=("
					+ DBSchema.Storage.STORAGE + "-?) WHERE "
					+ DBSchema.Storage.STORE_ID + "=? AND "
					+ DBSchema.Storage.BARCODE + "=?";

			preStmt = conn.prepareStatement(sql);
			preStmt.setString(2, order.getStoreId());
			for (MerchandiseCheckoutObject itemCheckoutObject : order
					.getMerchandiseCheckoutObjectList()) {
				preStmt.setInt(1, itemCheckoutObject.getAmount());
				preStmt.setString(3, itemCheckoutObject.getBarcode());

				preStmt.addBatch();
			}
			preStmt.executeBatch();

			sql = "INSERT INTO" + " " + DBSchema.SalesOrder.TABLE_NAME + " ("
					+ DBSchema.SalesOrder.STORE_ID + ","
					+ DBSchema.SalesOrder.ORDER_DATE + ","
					+ DBSchema.SalesOrder.BARCODE + ","
					+ DBSchema.SalesOrder.AMOUNT + ") " + "VALUES (?," + "?,"
					+ "?," + "?)";

			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, order.getStoreId());
			preStmt.setDate(2, new Date(
					Integer.valueOf(order.getYear()) - 1900, Integer
							.valueOf(order.getMonth()), Integer.valueOf(order
							.getDay())));
			for (MerchandiseCheckoutObject itemCheckoutObject : order
					.getMerchandiseCheckoutObjectList()) {
				preStmt.setString(3, itemCheckoutObject.getBarcode());
				preStmt.setInt(4, itemCheckoutObject.getAmount());

				preStmt.addBatch();
			}
			preStmt.executeBatch();
			conn.commit();

			statusObject = new StatusObject();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			statusObject = new StatusObject(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			statusObject = new StatusObject(e.getMessage());
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
				statusObject = new StatusObject(e.getMessage());
			}
		}

		return statusObject;
	}
}
