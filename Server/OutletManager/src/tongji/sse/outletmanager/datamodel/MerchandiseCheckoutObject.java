package tongji.sse.outletmanager.datamodel;

public class MerchandiseCheckoutObject {
	private MerchandiseObject itemCheckoutObject = null;
	private int amount = 0;
	
	public MerchandiseCheckoutObject(MerchandiseObject itemObject, int amount) {
		this.itemCheckoutObject = itemObject;
		this.amount = amount;
	}


	public MerchandiseObject getItemObject() {
		return itemCheckoutObject;
	}


	public void setItemObject(MerchandiseObject itemObject) {
		this.itemCheckoutObject = itemObject;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public boolean isSuccessful() {
		return itemCheckoutObject.isSuccessful();
	}


	public void setSuccessful(boolean isSuccessful) {
		itemCheckoutObject.setSuccessful(isSuccessful);
	}


	public String getErrorMessage() {
		return itemCheckoutObject.getErrorMessage();
	}


	public void setErrorMessage(String errorMessage) {
		itemCheckoutObject.setErrorMessage(errorMessage);
	}


	public String getBarcode() {
		return itemCheckoutObject.getBarcode();
	}


	public void setBarcode(String barcode) {
		itemCheckoutObject.setBarcode(barcode);
	}


	public String getName() {
		return itemCheckoutObject.getName();
	}


	public void setName(String name) {
		itemCheckoutObject.setName(name);
	}


	public String getModel() {
		return itemCheckoutObject.getModel();
	}


	public void setModel(String model) {
		itemCheckoutObject.setModel(model);
	}


	public String getUnit() {
		return itemCheckoutObject.getUnit();
	}


	public void setUnit(String unit) {
		itemCheckoutObject.setUnit(unit);
	}


	public long getPrice() {
		return itemCheckoutObject.getPrice();
	}


	public void setPrice(long price) {
		itemCheckoutObject.setPrice(price);
	}


	public long getCost() {
		return itemCheckoutObject.getCost();
	}


	public void setCost(long cost) {
		itemCheckoutObject.setCost(cost);
	}


	public int getStorage() {
		return itemCheckoutObject.getStorage();
	}

	public void setStorage(int storage) {
		itemCheckoutObject.setStorage(storage);
	}


}
