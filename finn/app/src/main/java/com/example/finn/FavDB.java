package com.example.finn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class FavDB extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "PlaceDB";
    private static String TABLE_NAME = "favoriteTable";
    public static String KEY_ID = "id";
    public static String ITEM_TITLE = "itemTitle";
    public static String ITEM_IMAGE = "itemImage";
    public static String ITEM_PLACE = "itemPlace";
    public static String ITEM_LINK = "itemLink";
    public static String ITEM_DES = "itemDes";
    public static String FAVORITE_STATUS = "fStatus";
    // don't forget write this spaces
    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + ITEM_TITLE+ " TEXT,"
            +ITEM_IMAGE + " TEXT," +ITEM_PLACE + " TEXT," +ITEM_LINK + " TEXT,"
            +ITEM_DES + " TEXT,"+ FAVORITE_STATUS+" TEXT)";

    public FavDB(Context context) { super(context,DATABASE_NAME, null,DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // create empty table
    public void insertEmpty() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // enter your value
        for (int x = 1; x < 11; x++) {
            cv.put(KEY_ID, x);
            cv.put(FAVORITE_STATUS, "0");

            db.insert(TABLE_NAME, null, cv);
        }
    }

        // insert data into database
    public void insertIntoTheDatabase(String item_title, int item_image, String item_place, String item_link,
                                      String item_des,  String id, String fav_status) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_TITLE, item_title);
        cv.put(ITEM_IMAGE, item_image);
        cv.put(ITEM_PLACE, item_place);
        cv.put(ITEM_LINK, item_link);
        cv.put(ITEM_DES, item_des);
        cv.put(KEY_ID, id);
        cv.put(FAVORITE_STATUS, fav_status);
        db.insert(TABLE_NAME, null, cv);
        Log.d("FavDB Status", item_title + ", favStatus - "+fav_status+" - . " + cv);
    }

    // read all data
    public Cursor read_all_data(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + KEY_ID +"="+id+"";
        return db.rawQuery(sql, null, null);
    }

    // remove line from database
    public void remove_fav(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  " + FAVORITE_STATUS + " ='0' WHERE " + KEY_ID + "=" +id+ "";
        db.execSQL(sql);
        Log.d("remove", id.toString());
    }

    // select all favorite list
    public Cursor select_all_favorite_list() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+FAVORITE_STATUS+" ='1'";
        return db.rawQuery(sql, null, null);
    }
}
