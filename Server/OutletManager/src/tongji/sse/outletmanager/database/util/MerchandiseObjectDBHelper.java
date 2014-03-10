package tongji.sse.outletmanager.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import tongji.sse.outletmanager.database.DBSchema;
import tongji.sse.outletmanager.database.DatabaseConfig;
import tongji.sse.outletmanager.database.ErrorMessage;
import tongji.sse.outletmanager.datamodel.MerchandiseObject;

public class MerchandiseObjectDBHelper {
	public static MerchandiseObject getMerchandiseObject(String storeId,
			String barcode) {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preStmt = null;
		String sql = null;

		MerchandiseObject itemObject = null;
		String name = null;
		String model = null;
		long price = 0;
		long cost = 0;
		int storage = 0;

		try {
			Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DATABASE_URL,
					DatabaseConfig.DATABASE_USERNAME,
					DatabaseConfig.DATABASE_PASSWORD);
			

			sql = "SELECT" + " " + "*" + " " + "FROM" + " "
					+ DBSchema.Storage.TABLE_NAME + " " + "WHERE" + " "
					+ DBSchema.Storage.STORE_ID + "=" + "?"
					+ " " + "AND" + " " + DBSchema.Storage.BARCODE + "=" + "?";

			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, storeId);
			preStmt.setString(2, barcode);
			rs = preStmt.executeQuery();

			if (rs.next()) {
				storage = rs.getInt(DBSchema.Storage.STORAGE);
			} else {
				// no storage found
				itemObject = new MerchandiseObject(
						ErrorMessage.ERR_ITEM_NOT_FOUND);
				return itemObject;
			}

			sql = "SELECT" + " " + "*" + " " + "FROM" + " "
					+ DBSchema.Product.TABLE_NAME + " " + "WHERE" + " "
					+ DBSchema.Product.BARCODE + "=" + "?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, barcode);
			rs = preStmt.executeQuery();
			
			if (rs.next()) {
				name = rs.getString(DBSchema.Product.NAME);
				model = rs.getString(DBSchema.Product.MODEL);
				price = rs.getLong(DBSchema.Product.PRICE);
				cost = rs.getLong(DBSchema.Product.COST);
			} else {
				// no storage found
				itemObject = new MerchandiseObject(
						ErrorMessage.ERR_ITEM_NOT_FOUND);
				return itemObject;
			}
			
			itemObject = new MerchandiseObject();
			itemObject.setBarcode(barcode);
			itemObject.setName(name);
			itemObject.setModel(model);
			itemObject.setStorage(storage);
			itemObject.setPrice(price);
			itemObject.setCost(cost);



		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			itemObject = new MerchandiseObject(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			itemObject = new MerchandiseObject(e.getMessage());
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
				itemObject = new MerchandiseObject(e.getMessage());
			}
		}
		return itemObject;

	}
}
