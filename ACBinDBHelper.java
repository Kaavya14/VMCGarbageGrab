package com.example.projectlogin1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ACBinDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Garbage.db";
    public static final String TABLE_NAME = "BinDetails";

    public static final String COL_1 = "BinId";
    public static final String COL_2 = "Area";
    public static final String COL_3 = "Locality";
    public static final String COL_4 = "Landmark";
    public static final String COL_5 = "ADEmail";
    public static final String COL_6 = "Lat";
    public static final String COL_7 = "Long";
    public static final String COL_8 = "Address";

    public ACBinDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (BinId INTEGER PRIMARY KEY AUTOINCREMENT, Area TEXT, Locality TEXT, Landmark TEXT, ADEmail TEXT, Lat TEXT, Long TEXT, Address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
