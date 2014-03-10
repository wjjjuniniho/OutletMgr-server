package tongji.sse.outletmanager.servlet.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tongji.sse.outletmanager.datamodel.MerchandiseDetailObject;
import tongji.sse.outletmanager.servlet.ServletConstant;

public class MerchandiseDetailHelper {
	public static JSONObject toJSONObject(MerchandiseDetailObject itemDetailObject) {
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
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemDetailJSONObject;
	}
}
