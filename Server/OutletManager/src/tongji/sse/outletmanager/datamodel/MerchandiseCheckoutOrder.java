package tongji.sse.outletmanager.datamodel;

import java.util.ArrayList;

public class MerchandiseCheckoutOrder {
	private ArrayList<MerchandiseCheckoutObject> itemCheckoutObjectList = null;
	private String storeId = null;
	private String year = null;
	private String month = null;
	private String day = null;
	
	public MerchandiseCheckoutOrder(String storeId, String year, String month, String day, ArrayList<MerchandiseCheckoutObject> itemCheckoutObjectList) {
		this.storeId = storeId;
		this.year = year;
		this.month = month;
		this.day = day;
		this.itemCheckoutObjectList = itemCheckoutObjectList;
	}
	
	
	public ArrayList<MerchandiseCheckoutObject> getMerchandiseCheckoutObjectList() {
		return itemCheckoutObjectList;
	}
	public void setMerchandiseCheckoutObjectList(
			ArrayList<MerchandiseCheckoutObject> itemCheckoutObjectList) {
		this.itemCheckoutObjectList = itemCheckoutObjectList;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}
	
	
	
}
