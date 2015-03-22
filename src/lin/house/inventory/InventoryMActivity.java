package lin.house.inventory;


import java.util.List;

import lin.house.inventory.db.InventoryListDao;
import lin.house.inventory.entity.InventoryItemEntity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
//import android.widget.Button;

public class InventoryMActivity extends Activity{
	 	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //setContentView(R.layout.activity_inventory_list);
	        
	        
	        setContentView(R.layout.activity_main);
	        ImageView imv_scan	=	(ImageView) findViewById(R.id.imageV_scanner);
	        ImageView imv_list	=	(ImageView) findViewById(R.id.imageV_inventory_list);
//	        
	        //InventoryListDao itemDAO = new InventoryListDao(getApplicationContext());
	        
//	        // 如果資料庫是空的，就建立一些範例資料
//	        // 這是為了方便測試用的，完成應用程式以後可以拿掉
//	        if (itemDAO.getListCount() == 0) {
//	            itemDAO.sample();
//	        }else{
//	        	System.out.println(itemDAO.getListCount());
//	        	itemDAO.insert(new InventoryItemEntity("bar-code-456", "456", 456, "date-456"));
//	        	System.out.println("update="+itemDAO.update(new InventoryItemEntity("333", "barT_333", 55688, "date-3")));
//	        	System.out.println("delete_222="+itemDAO.delete("222"));
//	        	System.out.println("delete_55688="+itemDAO.delete("55688"));
//	        }
//	     
//	        // 取得所有記事資料
//	        List<InventoryItemEntity> lists = itemDAO.getAll();
//	        printList(lists);
//	        imv_scan.setEnabled(false);
//	        imv_scan.setFocusable(true);
//	        imv_scan.setClickable(true);
	        //imv_scan.setImageDrawable(getResources().getDrawable(R.drawable.selector_ic_scan_run));
	    }

	 	public void scanProduct(View v){
	 		Intent intent2Scan = new Intent();
	 		intent2Scan.setClass(InventoryMActivity.this, InventoryMScanActivity.class);
	 		startActivity(intent2Scan);    
//	 		IntentIntegrator integrator = new IntentIntegrator(InventoryMActivity.this);
//	 		integrator.addExtra("SCAN_WIDTH", 800);
//	 		integrator.addExtra("SCAN_HEIGHT", 200);
//	 		integrator.addExtra("RESULT_DISPLAY_DURATION_MS", 3000L);
//	 		integrator.addExtra("PROMPT_MESSAGE", "Custom prompt to scan a product");
//	 		integrator.initiateScan(IntentIntegrator.PRODUCT_CODE_TYPES);
	 	}
	 	
	 	
//	 	private void printList( List<InventoryItemEntity> list){
//	 		for(InventoryItemEntity item:list){
//	 			System.out.println(item.getBarCodeId()+" ; "+item.getBarCodeTitle()+" ; "+item.getInventoryCnt()+" ; "+item.getInventoryDate());
//	 		}
//	 	}
//	    @Override
//	    public boolean onCreateOptionsMenu(Menu menu) {
//	        getMenuInflater().inflate(R.menu.activity_inventory_list, menu);
//	        return true;
//	    }
}
