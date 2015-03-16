package lin.house.inventory.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
   // ��Ʈw�W��
    public static final String DATABASE_NAME = "inventory_m.db";
    // ��Ʈw�����A��Ƶ��c���ܪ��ɭԭn���o�ӼƦr�A�q�`�O�[�@
    public static final int VERSION = 1;    
    // ��Ʈw����A�T�w������ܼ�
    private static SQLiteDatabase database;
 
    // �غc�l�A�b�@�몺���γ����ݭn�ק�
    public DBHandler(Context context, String name, CursorFactory factory,
            int version) {
        super(context, name, factory, version);
    }
 
    // �ݭn��Ʈw������I�s�o�Ӥ�k�A�o�Ӥ�k�b�@�몺���γ����ݭn�ק�
    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new DBHandler(context, DATABASE_NAME,  null, VERSION).getWritableDatabase();
        }
 
        return database;
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // �إ����ε{���ݭn������
        // �ݷ|�A�^�ӧ�����
    	db.execSQL(InventoryListDao.SQL_CREATE_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // �R���즳������
        // �ݷ|�A�^�ӧ�����
 
        // �I�sonCreate�إ߷s��������
        onCreate(db);
    }
 
}