package tongji.sse.outletmanager.servlet.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tongji.sse.outletmanager.datamodel.MerchandiseDetailObject;
import tongji.sse.outletmanager.servlet.ServletConstant;

public class MerchandiseDetailListHelper {
	public static JSONArray toJSONArray(ArrayList<MerchandiseDetailObject> itemDetailObjectList) {
		JSONArray itemDetailJSONArray = new JSONArray();
		for (MerchandiseDetailObject itemDetailObject : itemDetailObjectList) {

			JSONArray salesInfoJSONArray = new JSONArray();
			for (MerchandiseDetailObject.SalesInfo salesInfo : itemDetailObject.getSalesInfoList()) {
				JSONObject salesInfoJSONObject = new JSONObject();
				try {
					salesInfoJSONObject.put(ServletConstant.YEAR, salesInfo.getYear());
					salesInfoJSONObject.put(ServletConstant.MONTH, salesInfo.getMonth());
					salesInfoJSONObject.put(ServletConstant.SALES, salesInfo.getSalesAmount());
					
					salesInfoJSONArray.put(salesInfoJSONObject);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			

			JSONObject itemDetailJSONObject = new JSONObject();
			try {
				itemDetailJSONObject.put(ServletConstant.BARCODE, itemDetailObject.getBarcode());
				itemDetailJSONObject.put(ServletConstant.NAME, itemDetailObject.getName());
				itemDetailJSONObject.put(ServletConstant.MODEL, itemDetailObject.getModel());
				itemDetailJSONObject.put(ServletConstant.STORAGE, itemDetailObject.getStorage());
				itemDetailJSONObject.put(ServletConstant.PRICE, itemDetailObject.getPrice());
				itemDetailJSONObject.put(ServletConstant.COST, itemDetailObject.getCost());
				itemDetailJSONObject.put(ServletConstant.SALES_INFOS,salesInfoJSONArray);
				
				itemDetailJSONArray.put(itemDetailJSONObject);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return itemDetailJSONArray;
	}
}
