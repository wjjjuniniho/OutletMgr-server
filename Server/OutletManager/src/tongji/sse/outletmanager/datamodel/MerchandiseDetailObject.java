package tongji.sse.outletmanager.datamodel;

import java.util.ArrayList;


public class MerchandiseDetailObject {
	static public class SalesInfo {
		private String year = null;
		private String month = null;
		private int salesAmount = 0;
		
		public SalesInfo(int salesAmount, String year, String month) {
			this.year = year;
			this.month = month;
			this.salesAmount = salesAmount;
		}
		/**
		 * @return the year
		 */
		public String getYear() {
			return year;
		}
		/**
		 * @param year the year to set
		 */
		public void setYear(String year) {
			this.year = year;
		}
		/**
		 * @return the month
		 */
		public String getMonth() {
			return month;
		}
		/**
		 * @param month the month to set
		 */
		public void setMonth(String month) {
			this.month = month;
		}
		/**
		 * @return the salesAmount
		 */
		public int getSalesAmount() {
			return salesAmount;
		}
		/**
		 * @param salesAmount the salesAmount to set
		 */
		public void setSalesAmount(int salesAmount) {
			this.salesAmount = salesAmount;
		}
		
		
	}
	
	
	private MerchandiseObject itemObject = null;
	private ArrayList<SalesInfo> salesInfoList = new ArrayList<SalesInfo>();
	
	
	public MerchandiseDetailObject(String errorMessage) {
		itemObject = new MerchandiseObject(errorMessage);
	}
	
	public MerchandiseDetailObject(MerchandiseObject itemObject, ArrayList<SalesInfo> salesInfoList) {
		this.itemObject = itemObject;
		this.salesInfoList = salesInfoList;
	}
	
	public void addSales(int position, int salesAmount) {
		SalesInfo salesInfo = salesInfoList.get(position);
		salesInfoList.get(position).setSalesAmount(salesInfo.getSalesAmount() + salesAmount);
	}
	
	
	
	public boolean isSuccessful() {
		return itemObject.isSuccessful();
	}
	
	public void setSuccessful(boolean isSuccessful) {
		itemObject.setSuccessful(isSuccessful);
	}

	public String getErrorMessage() {
		return itemObject.getErrorMessage();
	}
	
	
	public void setErrorMessage(String errorMessage) {
		itemObject.setErrorMessage(errorMessage);
	}


	public ArrayList<SalesInfo> getSalesInfoList() {
		return salesInfoList;
	}





	public void setSalesInfoList(ArrayList<SalesInfo> salesInfoList) {
		this.salesInfoList = salesInfoList;
	}




	public String getBarcode() {
		return itemObject.getBarcode();
	}



	public void setBarcode(String barcode) {
		itemObject.setBarcode(barcode);
	}



	public String getName() {
		return itemObject.getName();
	}



	public void setName(String name) {
		itemObject.setName(name);
	}



	public String getModel() {
		return itemObject.getModel();
	}



	public void setModel(String model) {
		itemObject.setModel(model);
	}



	public String getUnit() {
		return itemObject.getUnit();
	}



	public void setUnit(String unit) {
		itemObject.setUnit(unit);
	}



	public long getPrice() {
		return itemObject.getPrice();
	}



	public void setPrice(long price) {
		itemObject.setPrice(price);
	}


	public long getCost() {
		return itemObject.getCost();
	}
	
	
	public void setCost(long cost) {
		itemObject.setCost(cost);
	}
	
	

	public int getStorage() {
		return itemObject.getStorage();
	}



	public void setStorage(int storage) {
		itemObject.setStorage(storage);
	}



}
