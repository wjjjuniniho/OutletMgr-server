package tongji.sse.outletmanager.servlet.util;

import org.json.JSONException;
import org.json.JSONObject;

import tongji.sse.outletmanager.datamodel.MerchandiseObject;
import tongji.sse.outletmanager.servlet.ServletConstant;

public class MerchandiseHelper {
	public static JSONObject toJSONObject(MerchandiseObject itemObject) {
		JSONObject itemJSONObject = new JSONObject();
		try {
			itemJSONObject.put(ServletConstant.BARCODE, itemObject.getBarcode());
			itemJSONObject.put(ServletConstant.NAME, itemObject.getName());
			itemJSONObject.put(ServletConstant.MODEL, itemObject.getModel());
			itemJSONObject.put(ServletConstant.STORAGE, itemObject.getStorage());
			itemJSONObject.put(ServletConstant.PRICE, itemObject.getPrice());
			itemJSONObject.put(ServletConstant.COST, itemObject.getCost());
				
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemJSONObject;
	}
}
