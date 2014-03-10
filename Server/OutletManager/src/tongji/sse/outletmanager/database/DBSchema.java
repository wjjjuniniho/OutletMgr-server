package tongji.sse.outletmanager.database;

public class DBSchema {
	public class Employee {
		//table name
		public static final String TABLE_NAME = "employee";
		
		//column name for table "employee"
		public static final String EMPLOYEE_ID = "employeeId";
		public static final String USERNAME = "username";
		public static final String PASSWORD = "password";
		public static final String AUTHORITY = "authority";
		public static final String STORE_ID = "storeId";	
	}
	
	public class MajorCategory {
		//table name
		public static final String TABLE_NAME = "majorcategory";
		
		//column name for table "majorcategory"
		public static final String MAJOR_CATEGORY_ID = "majorCategoryId";
		public static final String CATEGORY_NAME = "categoryName";
	}
	
	public class Product {
		//table name
		public static final String TABLE_NAME = "product";
		
		//column name for table "product"
		public static final String BARCODE = "barcode";
		public static final String NAME = "name";
		public static final String SUB_CATEGORY_ID = "subCategoryId";
		public static final String PRICE = "price";
		public static final String COST = "cost";
		public static final String PLACE = "place";
		public static final String OTHERS = "others";
		public static final String MODEL = "model";
	} 
	
	public class SalesOrder {
		//table name
		public static final String TABLE_NAME = "salesorder";
		
		//column name for table "salesorder"
		public static final String ORDER_ID = "orderId";
		public static final String BARCODE = "barcode";
		public static final String STORE_ID = "storeId";
		public static final String ORDER_DATE = "orderDate";
		public static final String AMOUNT = "amount";
		public static final String TOTAL = "total";
	}
	
	
	public class Storage {
		//table name
		public static final String TABLE_NAME = "storage";
		
		//column name for table "storage"
		public static final String BARCODE = "barcode";
		public static final String STORE_ID = "storeId";
		public static final String STORAGE = "storage";
		public static final String NAME = "name";
		public static final String PRICE = "price";
	}
	
	public class Store {
		//table name
		public static final String TABLE_NAME = "store";
		
		//column name for table "store"
		public static final String STORE_ID = "storeId";
		public static final String ADDRESS = "address";
		public static final String STORE_OWNER = "storeOwner";
		public static final String STORE_NAME = "storeName";
 	}
	
	public class SubCategory {
		//table name 
		public static final String TABLE_NAME = "subcategory";
		
		//column name for table "subcategory"
		public static final String SUB_CATEGORY_ID = "subCategoryId";
		public static final String SUB_CATEGORY_NAME = "subCategoryName";
		public static final String MAJOR_CATEGORY_ID = "majorCategoryId";
	}
}
