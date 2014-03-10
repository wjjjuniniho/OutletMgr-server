package tongji.sse.outletmanager.database.util;

import java.util.ArrayList;
import java.util.Date;

import tongji.sse.outletmanager.database.DBSchema;
import tongji.sse.outletmanager.database.ErrorMessage;
import tongji.sse.outletmanager.datamodel.MerchandiseDetailObject;
import tongji.sse.outletmanager.datamodel.MerchandiseObject;
import tongji.sse.outletmanager.servlet.ServletConstant;

public class StatisticsDetailObjectDBHelper {
	private static final int SALES_INFOS_SIZE = 12;

	public static MerchandiseDetailObject getStatisticsDetailObject(
			String storeId) {
		MerchandiseDetailObject statisticsDetailObject = null;
		MerchandiseObject statisticsObject = null;
		ArrayList<MerchandiseDetailObject.SalesInfo> statisticsSalesInfoList = new ArrayList<MerchandiseDetailObject.SalesInfo>();
		int storage = 0;

		// initialize salesInfoList
		Date date = new Date();
		int year = date.getYear() + 1900;
		for (int i = 0; i < SALES_INFOS_SIZE; i++) {
			statisticsSalesInfoList.add(new MerchandiseDetailObject.SalesInfo(
					0, String.valueOf(year), String.valueOf(i)));
		}

		ArrayList<MerchandiseDetailObject> itemDetailObjectList = MerchandiseDetailObjectListDBHelper
				.getMerchandiseDetailObjectList(storeId);

		if (itemDetailObjectList.get(0).isSuccessful()) {
			ArrayList<MerchandiseDetailObject.SalesInfo> salesInfoList = null;

			for (MerchandiseDetailObject itemDetailObject : itemDetailObjectList) {
				storage += itemDetailObject.getStorage();

				salesInfoList = itemDetailObject.getSalesInfoList();
				if (year == Integer.valueOf((salesInfoList.get(0).getYear()))) {
					for (int j = 0; j < salesInfoList.size(); j++) {
						MerchandiseDetailObject.SalesInfo salesInfo = salesInfoList
								.get(j);

						statisticsSalesInfoList.get(j).setSalesAmount(
								statisticsSalesInfoList.get(j).getSalesAmount()
										+ salesInfo.getSalesAmount());

					}
				}

			}

			statisticsObject = new MerchandiseObject();
			statisticsObject.setBarcode(ServletConstant.VALUE_BARCODE_ALL);
			statisticsObject.setName(ServletConstant.VALUE_NAME_ALL);
			statisticsObject.setModel(ServletConstant.VALUE_MODEL_ALL);
			statisticsObject.setPrice(ServletConstant.VALUE_PRICE_ALL);
			statisticsObject.setCost(ServletConstant.VALUE_COST_ALL);
			statisticsObject.setStorage(storage);

			statisticsDetailObject = new MerchandiseDetailObject(
					statisticsObject, statisticsSalesInfoList);

		} else {
			statisticsDetailObject = new MerchandiseDetailObject(
					ErrorMessage.ERR_ITEM_NOT_FOUND);
		}

		return statisticsDetailObject;
	}
}
