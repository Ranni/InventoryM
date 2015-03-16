package lin.house.inventory.entity;

public class InventoryItemEntity {
	private String barCodeId;
//  public static final String COL_BARCODE_TYPE 	= "barcode_type";
	private String barCodeTitle;
	private int inventoryCnt;
	private String inventoryDate;
	
	public InventoryItemEntity(){
		
	}
	public InventoryItemEntity(String barCodeId, String barCodeTitle, int inventoryCnt, String invnentoryDate){
		setBarCodeId(barCodeId);
		setBarCodeTitle(barCodeTitle);
		setInventoryCnt(inventoryCnt);
		setInventoryDate(invnentoryDate);
	}
	
	public void setBarCodeId(String s){
		barCodeId=s;
	}
	public String getBarCodeId(){
		return barCodeId;
	}
	
	public void setBarCodeTitle(String s){
		barCodeTitle=s;
	}
	public String getBarCodeTitle(){
		return barCodeTitle;
	}
	
	public void setInventoryCnt(int s){
		inventoryCnt=s;
	}
	public int getInventoryCnt(){
		return inventoryCnt;
	}
	
	public void setInventoryDate(String s){
		inventoryDate=s;
	}
	public String getInventoryDate(){
		return inventoryDate;
	}
}
