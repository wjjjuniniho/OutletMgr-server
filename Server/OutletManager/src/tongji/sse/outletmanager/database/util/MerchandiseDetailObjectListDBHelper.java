package tongji.sse.outletmanager.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import tongji.sse.outletmanager.database.DBSchema;
import tongji.sse.outletmanager.database.DatabaseConfig;
import tongji.sse.outletmanager.database.ErrorMessage;
import tongji.sse.outletmanager.datamodel.MerchandiseDetailObject;
import tongji.sse.outletmanager.datamodel.MerchandiseObject;

public class MerchandiseDetailObjectListDBHelper {
	// for a year-length size: 12 months
	private final static int SALES_INFOS_SIZE = 12;

	public static ArrayList<MerchandiseDetailObject> getMerchandiseDetailObjectList(
			String storeId) {

		Connection conn = null;
		ResultSet rs = null;
		ResultSet rsBarcode = null;
		PreparedStatement preStmt = null;
		String sql = null;

		String barcode = null;
		String name = null;
		String model = null;
		long price = 0;
		long cost = 0;
		int storage = 0;

		ArrayList<MerchandiseDetailObject> itemDetailObjectList = new ArrayList<MerchandiseDetailObject>();
		MerchandiseDetailObject itemDetailObject = null;
		MerchandiseObject itemObject = null;
		ArrayList<MerchandiseDetailObject.SalesInfo> salesInfoList = null;

		

		try {
			Class.forName(DatabaseConfig.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConfig.DATABASE_URL,
					DatabaseConfig.DATABASE_USERNAME,
					DatabaseConfig.DATABASE_PASSWORD);

			//get items barcode list
			sql = "SELECT" + " " + "*" + " " + "FROM" + " "
					+ DBSchema.Storage.TABLE_NAME + " " + "WHERE" + " "
					+ DBSchema.Storage.STORE_ID + "=" + "?";

			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, storeId);
			rsBarcode = preStmt.executeQuery();

			while (rsBarcode.next()) {
				salesInfoList = new ArrayList<MerchandiseDetailObject.SalesInfo>();
				// initialize salesInfoList
				Date date = new Date();
				int year = date.getYear() + 1900;
				for (int i = 0; i < SALES_INFOS_SIZE; i++) {
					salesInfoList.add(new MerchandiseDetailObject.SalesInfo(0, String
							.valueOf(year), String.valueOf(i)));
				}
				//get item barcode
				barcode = rsBarcode.getString(DBSchema.Storage.BARCODE);

				//get item storage
				sql = "SELECT" + " " + "*" + " " + "FROM" + " "
						+ DBSchema.Storage.TABLE_NAME + " " + "WHERE" + " "
						+ DBSchema.Storage.STORE_ID + "=" + "?" + " " + "AND"
						+ " " + DBSchema.Storage.BARCODE + "=" + "?";

				preStmt = conn.prepareStatement(sql);
				preStmt.setString(1, storeId);
				preStmt.setString(2, barcode);
				rs = preStmt.executeQuery();

				if (rs.next()) {
					storage = rs.getInt(DBSchema.Storage.STORAGE);
				} else {
					// no storage found
					itemDetailObjectList.add(new MerchandiseDetailObject(
							ErrorMessage.ERR_ITEM_NOT_FOUND));
					return itemDetailObjectList;
				}

				//get item name model price cost
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
					itemDetailObjectList.add(new MerchandiseDetailObject(
							ErrorMessage.ERR_ITEM_NOT_FOUND));
					return itemDetailObjectList;
				}

				//get sales info list
				sql = "SELECT" + " " + "*" + " " + "FROM" + " "
						+ DBSchema.SalesOrder.TABLE_NAME + " " + "WHERE" + " "
						+ DBSchema.SalesOrder.STORE_ID + "=" + "?" + " "
						+ "AND" + " " + DBSchema.SalesOrder.BARCODE + "=" + "?";

				preStmt = conn.prepareStatement(sql);
				preStmt.setString(1, storeId);
				preStmt.setString(2, barcode);
				rs = preStmt.executeQuery();

				while (rs.next()) {
					date = rs.getDate(DBSchema.SalesOrder.ORDER_DATE);

					if (year == (date.getYear() + 1900)) {
						int month = date.getMonth();
						int amount = rs.getInt(DBSchema.SalesOrder.AMOUNT)
								+ salesInfoList.get(month).getSalesAmount();

						salesInfoList.get(month).setSalesAmount(amount);
					}
				}

				//set value
				itemObject = new MerchandiseObject();
				itemObject.setBarcode(barcode);
				itemObject.setName(name);
				itemObject.setModel(model);
				itemObject.setStorage(storage);
				itemObject.setPrice(price);
				itemObject.setCost(cost);

				itemDetailObject = new MerchandiseDetailObject(itemObject,
						salesInfoList);
				itemDetailObjectList.add(itemDetailObject);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			itemDetailObject = new MerchandiseDetailObject(e.getMessage());
			itemDetailObjectList.add(itemDetailObject);
		} catch (SQLException e) {
			e.printStackTrace();
			itemDetailObject = new MerchandiseDetailObject(e.getMessage());
			itemDetailObjectList.add(itemDetailObject);
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
				itemDetailObject = new MerchandiseDetailObject(e.getMessage());
				itemDetailObjectList.add(itemDetailObject);
			}
		}
		return itemDetailObjectList;
	}
}
