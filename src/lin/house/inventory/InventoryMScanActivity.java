package lin.house.inventory;

import lin.house.inventory.util.BroadCastUtil;
import lin.house.inventory.wheelview.NumericWheelView;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryMScanActivity extends Activity{


	//data
	NumericWheelBroadcastReceiver mNumericWheelBroadcastReceiver = null;
	String prodBarcodeId	=null;
	int prodCount			=0;
	int prodInsertCount		=0;

	//view
	NumericWheelView numbericWheelView=null;
	TextView tvRecordCount	= null;
	TextView tvInsertCount	= null;
	TextView tvInsertAction = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);
        
		initData();
		initView();
	}

	@Override
	protected void onResume() {
		registerNumericWheelScrollingBroadcast();
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		unRegisterNumericWheelScrollingBroadcast();
		super.onPause();
	}
	
	private void initData(){
		prodBarcodeId		= "1234567";
		prodCount			= getDbCountByProduct(prodBarcodeId);
		prodInsertCount		= 0;
	}
	private void initView(){
		numbericWheelView = (NumericWheelView) findViewById(R.id.scan_wheelview_product_number);
		numbericWheelView.setCurrentItem(getDbCountByProduct(""), false);	//FIXME
        
		tvRecordCount		= (TextView) findViewById(R.id.scan_tv_record_count);
		tvInsertCount		= (TextView) findViewById(R.id.scan_tv_insert_count);
		tvInsertAction		= (TextView) findViewById(R.id.scan_tv_insert_action);
		
		tvRecordCount.setText(""+prodCount);
		tvInsertCount.setText(""+prodInsertCount);
	}
	private void registerNumericWheelScrollingBroadcast(){
		System.out.println("-----RegisterNumericWheelScrollingBroadcast-----");
		IntentFilter mFilter01 = new IntentFilter(BroadCastUtil.NUMERIC_WHEEL_SCROLL_INTENT_FILTER);
		mNumericWheelBroadcastReceiver = new NumericWheelBroadcastReceiver(); //←實作一個BroadcastReceiver來篩選
		registerReceiver(mNumericWheelBroadcastReceiver, mFilter01);
	}
	private void unRegisterNumericWheelScrollingBroadcast(){
		System.out.println("--unRegisterNumericWheelScrollingBroadcast--");
		unregisterReceiver(mNumericWheelBroadcastReceiver);
	}
	
	public void btnAddCount(View v){
		int currentItemIndex	=	numbericWheelView.getCurrentItem();
		System.out.println(currentItemIndex+"---"+numbericWheelView.getTextItem(currentItemIndex));
		int maxItemIndex		=	numbericWheelView.getAdapter().getItemsCount()-1;
		if(currentItemIndex==maxItemIndex){
			//can not more
		}else{
			numbericWheelView.setCurrentItem(currentItemIndex+1, true);
		}
	}
	public void btnSubCount(View v){
		int currentItemIndex	=	numbericWheelView.getCurrentItem();
		int minItemIndex		=	1;
		if(currentItemIndex==minItemIndex){
			//can not less
		}else{
			numbericWheelView.setCurrentItem(currentItemIndex-1, true);
		}
	}
	
	
	private void invadlidateInsertItemCount(){
		tvInsertCount.setText(""+prodInsertCount);
	}
	
	private int getDbCountByProduct(String barcodeId){
		//TODO
		return 12;
	}
	
	
	public class NumericWheelBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			int insertCount   = intent.getIntExtra(BroadCastUtil.NUMERIC_WHEEL_SCROLL_CNT, 0)- prodCount;
			if(insertCount<0){
//				Toast.makeText(context, "insertCount=" + insertCount, Toast.LENGTH_SHORT).show();
				prodInsertCount = insertCount;
				invadlidateInsertItemCount();
			}else{
				prodInsertCount = insertCount;
				invadlidateInsertItemCount();
			}
			
		}

	}
}
