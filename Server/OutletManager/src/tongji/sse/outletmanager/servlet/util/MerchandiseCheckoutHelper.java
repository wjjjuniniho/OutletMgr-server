package tongji.sse.outletmanager.servlet.util;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tongji.sse.outletmanager.datamodel.MerchandiseCheckoutObject;
import tongji.sse.outletmanager.datamodel.MerchandiseCheckoutOrder;
import tongji.sse.outletmanager.datamodel.MerchandiseObject;
import tongji.sse.outletmanager.servlet.ServletConstant;

public class MerchandiseCheckoutHelper {
	public static MerchandiseCheckoutOrder parse(String input) {
		JSONObject itemCheckoutOrderJSONObject = null;
		MerchandiseCheckoutOrder itemCheckoutOrder = null;
		try {
			itemCheckoutOrderJSONObject = new JSONObject(input);
			
			String storeId = itemCheckoutOrderJSONObject.getString(ServletConstant.STOREID);
			String year = itemCheckoutOrderJSONObject.getString(ServletConstant.YEAR);
			String month = itemCheckoutOrderJSONObject.getString(ServletConstant.MONTH);
			String day = itemCheckoutOrderJSONObject.getString(ServletConstant.DAY);
			
			
			ArrayList<MerchandiseCheckoutObject> itemCheckoutObjectList = new ArrayList<MerchandiseCheckoutObject>();
			
			JSONArray itemCheckoutJSONArray = itemCheckoutOrderJSONObject.getJSONArray(ServletConstant.ITEM_CHECKOUT_LIST);
			if (itemCheckoutJSONArray != null) {
				for (int i = 0; i < itemCheckoutJSONArray.length(); i++) {	
					JSONObject itemCheckoutJSONObject = itemCheckoutJSONArray.getJSONObject(i);
					
					String barcode = itemCheckoutJSONObject.getString(ServletConstant.BARCODE);
					int amount = itemCheckoutJSONObject.getInt(ServletConstant.AMOUNT);
					
					MerchandiseObject itemObject = new MerchandiseObject();
					itemObject.setBarcode(barcode);
					
					itemCheckoutObjectList.add(new MerchandiseCheckoutObject(itemObject, amount));
				}
			}
			
			itemCheckoutOrder = new MerchandiseCheckoutOrder(storeId, year, month, day, itemCheckoutObjectList);
			
		} catch (JSONException e) {
			e.printStackTrace();
			return itemCheckoutOrder;
		}
	
		return itemCheckoutOrder;
		
		
	}
}
