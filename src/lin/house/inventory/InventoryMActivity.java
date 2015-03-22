package lin.house.inventory;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.ImageView;

public class InventoryMActivity extends Activity{
	 	@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //setContentView(R.layout.activity_inventory_list);
	        setContentView(R.layout.activity_main);
	        ImageView imv_scan	=	(ImageView) findViewById(R.id.imageV_scanner);
	        ImageView imv_list	=	(ImageView) findViewById(R.id.imageV_inventory_list);
	        
//	        imv_scan.setEnabled(false);
//	        imv_scan.setFocusable(true);
//	        imv_scan.setClickable(true);
	        //imv_scan.setImageDrawable(getResources().getDrawable(R.drawable.selector_ic_scan_run));
	    }

	 	public void scanProduct(View v){
	 		System.out.println("ih");
	 		IntentIntegrator integrator = new IntentIntegrator(InventoryMActivity.this);
	 		integrator.addExtra("SCAN_WIDTH", 800);
	 		integrator.addExtra("SCAN_HEIGHT", 200);
	 		integrator.addExtra("RESULT_DISPLAY_DURATION_MS", 3000L);
	 		integrator.addExtra("PROMPT_MESSAGE", "Custom prompt to scan a product");
	 		integrator.initiateScan(IntentIntegrator.PRODUCT_CODE_TYPES);
	 	};
//	    @Override
//	    public boolean onCreateOptionsMenu(Menu menu) {
//	        getMenuInflater().inflate(R.menu.activity_inventory_list, menu);
//	        return true;
//	    }
}
