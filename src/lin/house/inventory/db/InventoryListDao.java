package lin.house.inventory.db;

import lin.house.inventory.entity.InventoryItemEntity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class InventoryListDao {
	// 表格名稱    
    public static final String TABLE_NAME = "inventory_list";
 
    // 編號表格欄位名稱，固定不變
    public static final String KEY_ID = "_id";
 
    // 其它表格欄位名稱
    public static final String COL_BARCODE_ID 		= "barcode_id";
//    public static final String COL_BARCODE_TYPE 	= "barcode_type";
    public static final String COL_BARCODE_TITLE 	= "barcode_title";
    public static final String COL_INVENTORY_CNT	= "inventory_cnt";
    public static final String COL_INVENTORY_DATE	= "inventory_date";
    
    
    // 使用上面宣告的變數建立表格的SQL指令
   
    public static String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + 
    		//KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    		COL_BARCODE_ID + " INTEGER NOT NULL, " +
    		COL_BARCODE_TITLE + " INTEGER NOT NULL, " +
    		COL_INVENTORY_DATE + " TEXT NOT NULL)";
    
    // 資料庫物件    
    private SQLiteDatabase db;
 
    // 建構子，一般的應用都不需要修改
    public InventoryListDao(Context context) {
        db = DBHandler.getDatabase(context);
    }
 
    // 關閉資料庫，一般的應用都不需要修改
    public void close() {
        db.close();
    }
    
    
    
    // 新增參數指定的物件
    public InventoryItemEntity insert(InventoryItemEntity item) {
        // 建立準備新增資料的ContentValues物件
        ContentValues cv = new ContentValues();     
 
        // 加入ContentValues物件包裝的新增資料
        // 第一個參數是欄位名稱， 第二個參數是欄位的資料
        //cv.put(DATETIME_COLUMN, item.getDatetime());
        cv.put(COL_BARCODE_ID, 		item.getBarCodeId());
        cv.put(COL_BARCODE_TITLE, 	item.getBarCodeTitle());
        cv.put(COL_INVENTORY_CNT, 	item.getInventoryCnt());
        cv.put(COL_INVENTORY_DATE, 	item.getInventoryDate());
        
        
        // 新增一筆資料並取得編號
        // 第一個參數是表格名稱
        // 第二個參數是沒有指定欄位值的預設值
        // 第三個參數是包裝新增資料的ContentValues物件
//        long id = db.insert(TABLE_NAME, null, cv);
// 
//        // 設定編號
//        item.setId(id);
        // 回傳結果
        return item;
    }
    
    
    // 取得指定編號的資料物件
    public InventoryItemEntity get(String barCodeId) {
        // 準備回傳結果用的物件
    	InventoryItemEntity item = null;
        // 使用編號為查詢條件
        String where = COL_BARCODE_ID + "=" + barCodeId;
        // 執行查詢
        Cursor result = db.query(TABLE_NAME, null, where, null, null, null, null, null);
 
        // 如果有查詢結果
        if (result.moveToFirst()) {
            // 讀取包裝一筆資料的物件
            item = getRecord(result);
        }
 
        // 關閉Cursor物件
        result.close();
        // 回傳結果
        return item;
    }
    
    // 把Cursor目前的資料包裝為物件
    public InventoryItemEntity getRecord(Cursor cursor) {
        // 準備回傳結果用的物件
    	InventoryItemEntity result = new InventoryItemEntity();
        
    	result.setBarCodeId(cursor.getString(0));
        result.setBarCodeTitle(cursor.getString(1));
        result.setInventoryCnt(cursor.getInt(2));
        result.setInventoryDate(cursor.getString(3));
 
        // 回傳結果
        return result;
    }
    
    // 取得資料數量
    public int getListCount() {
        int result = 0;
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
 
        if (cursor.moveToNext()) {
            result = cursor.getInt(0);
        }
 
        return result;
    }
    
    // 建立範例資料
    public void sample() {
    	InventoryItemEntity item = new InventoryItemEntity("111", "barT_111", 4, "date-1");
    	InventoryItemEntity item2 = new InventoryItemEntity("222", "barT_222", 3, "date-2");
    	InventoryItemEntity item3 = new InventoryItemEntity("333", "barT_333", 2, "date-3");
 
        insert(item);
        insert(item2);
        insert(item3);
    }
    
}
