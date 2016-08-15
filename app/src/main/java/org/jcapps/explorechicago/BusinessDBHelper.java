package org.jcapps.explorechicago;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by JC on 8/11/16.
 */
public class BusinessDBHelper extends SQLiteOpenHelper {
    private static BusinessDBHelper sInstance;
    private static final String TAG = "BusinessDBHelper";

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Chinatown.db";
    public static final String BUSINESS_TABLE_NAME = "BUSINESS";

    public static final String COL_ID = "_id";
    public static final String COL_CATEGORY = "CATEGORY";
    public static final String COL_NAME = "NAME";
    public static final String COL_ADDRESS = "ADDRESS";
    public static final String COL_CITY = "CITY";
    public static final String COL_STATE = "STATE";
    public static final String COL_ZIP = "ZIP";
    public static final String COL_PHONE = "PHONE";
    public static final String COL_HOURS = "HOURS";
    public static final String COL_WEB = "WEB";
    public static final String COL_FAVORITE = "FAVORITE";
    public static final String COL_POSITION = "POSITION";
//    public static SQLiteDatabase db;

    public static final String[] BUSINESS_COLUMNS = {COL_ID,COL_CATEGORY,COL_NAME,COL_ADDRESS,COL_CITY,COL_STATE,COL_ZIP,COL_PHONE,COL_HOURS,COL_FAVORITE,COL_POSITION};

    private static final String CREATE_BUSINESS_TABLE =
        "CREATE TABLE IF NOT EXISTS " + BUSINESS_TABLE_NAME +
                                 " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        COL_CATEGORY + " TEXT," +
                                        COL_NAME + " TEXT," +
                                        COL_ADDRESS + " TEXT," +
                                        COL_CITY + " TEXT," +
                                        COL_STATE + " TEXT," +
                                        COL_ZIP + " TEXT," +
                                        COL_PHONE + " TEXT," +
                                        COL_HOURS + " TEXT," +
                                        COL_WEB + " TEXT," +
                                        COL_FAVORITE + " TEXT," +
                                        COL_POSITION + " TEXT);" ;

    private static final String DELETE_BUSINESS =
            "DELETE FROM " + BUSINESS_TABLE_NAME + ";";

    private static final String DROP_BUSINESS_TABLE = "DROP TABLE IF EXISTS " + BUSINESS_TABLE_NAME + ";";

    // Make DB instance a singleton instance to prevent memory leaks and unnecessary reallocations.
    private static BusinessDBHelper mInstance;

    public static synchronized BusinessDBHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (mInstance == null) {
            mInstance = new BusinessDBHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    // Default Constructor
    public BusinessDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BUSINESS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading application's database from version " + oldVersion + " to " + newVersion +
                " to " + newVersion + ", which will destroy all existing data!");
        db.execSQL(DROP_BUSINESS_TABLE);
        onCreate(db);
    }


    public Cursor getBakeryList(){

//        BakerySQLiteOpenHelper dbHelper = new BakerySQLiteOpenHelper(getActivity());
//        SQLiteDatabase db = dbHelper.getReadableDatabase();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(BUSINESS_TABLE_NAME, // a. table
                null, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                COL_NAME,  // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor getmarkerInfo(String query){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(BUSINESS_TABLE_NAME, // a. table
                BUSINESS_COLUMNS, // b. column names
                COL_POSITION + " = ?", // c. selections
                new String[]{query}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        //      Cursor cursor = db.rawQuery("select * from business where position = ?",new String[]{query});
        return cursor;
    }

    public Cursor searchBusinessList(String query){
        SQLiteDatabase db = getReadableDatabase();

        // By using the condition, SELECT _id, NAME, CATEGORY, ADDRESS, CITY, STATE, ZIP, PHONE
        //                         WHERE NAME LIKE "%<query string>%
        // You are selecting all records where the NAME column contains the query string anywhere
        // within the field.
        //String someStringVars = "SELECT * FROM TABLE_NAME WHERE " + " _id = 1";
        //Cursor c = db.rawQuery(someStringVars, null);
        Cursor cursor = db.query(BUSINESS_TABLE_NAME, // a. table
                BUSINESS_COLUMNS, // b. column names
                COL_NAME + " LIKE ?", // c. selections
                new String[]{"%"+query+"%"}, // d. selections args
                null, // e. group by
                null, // f. having
                COL_NAME, // g. order by
//                P_COL_ITEM_CATEGORY + "," + P_COL_ITEM_NAME, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor searchBusinessCategory(String query){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(BUSINESS_TABLE_NAME, // a. table
                BUSINESS_COLUMNS, // b. column names
                COL_CATEGORY + " = ?", // c. selections
                new String[]{query}, // d. selections args
                null, // e. group by
                null, // f. having
                COL_NAME, // g. order by
                null); // h. limit

        //      Cursor cursor = db.rawQuery("select * from business where category = ?",new String[]{query});
        return cursor;
    }

    public Cursor searchBusinessFavorite(String query){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(BUSINESS_TABLE_NAME, // a. table
                BUSINESS_COLUMNS, // b. column names
                COL_FAVORITE + " = ?", // c. selections
                new String[]{query}, // d. selections args
                null, // e. group by
                null, // f. having
                COL_NAME, // g. order by
                null); // h. limit

        //      Cursor cursor = db.rawQuery("select * from business where favorite = ?",new String[]{query});
        return cursor;
    }

    public void setFavorite(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_FAVORITE, 1);

        String selection = COL_ID + " = ?";
        String[] selectionArgs = {id};

        db.update(BUSINESS_TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }

    public void removeFavorite(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_FAVORITE, 0);

        String selection = COL_ID + " = ?";
        String[] selectionArgs = {id};

        db.update(BUSINESS_TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
    }

    public long insertBusiness(String category, String name, String address, String city, String state, String zip, String phone, String hours, String web, String position) {

        int favorite = 0; // set all favorite flags to 0

        ContentValues values = new ContentValues();
        // values.put(COL_ID, id);                       // autoincrement
        values.put(COL_CATEGORY, category);
        values.put(COL_NAME, name);
        values.put(COL_ADDRESS, address);
        values.put(COL_CITY, city);
        values.put(COL_STATE, state);
        values.put(COL_ZIP, zip);
        values.put(COL_PHONE, phone);
        values.put(COL_HOURS, hours);
        values.put(COL_WEB, web);
        values.put(COL_FAVORITE, favorite);
        values.put(COL_POSITION, position);

        SQLiteDatabase db = this.getWritableDatabase();

        long returnId = db.insert(BUSINESS_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }

    public int deleteBusiness(int id){
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(BUSINESS_TABLE_NAME,
                COL_NAME + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }
    public int getTableCount(){
        SQLiteDatabase db = getReadableDatabase();
//        db = this.getReadableDatabase();
        String query = "select count(*) from business";
        Cursor  c = db.rawQuery(query, null);
            if (c.moveToFirst()) {
                return c.getInt(0);
            }
        c.close();
        return 0;

    }

}
