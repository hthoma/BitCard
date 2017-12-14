package bitcard.cosc431.bitcard.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import bitcard.cosc431.bitcard.models.KeyClass;




public class KeyDataSource {

    private static KeyDataSource instance;
    private KeyDBHelper dbHelper;

    public KeyDataSource(Context ctx) {
        dbHelper = new KeyDBHelper(ctx);
    }




    public static KeyDataSource getInstance(Context ctx) {

        if(instance == null) {
            instance = new KeyDataSource(ctx);
        }
        return instance;

    }

    public ArrayList<KeyClass> getAllKeys() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DatabaseContract.TABLE_NAME, null);
        ArrayList<KeyClass> weathers = new ArrayList<>();
        while(cursor.moveToNext()) {
            KeyClass weather = new KeyClass();
            String id = cursor.getString(cursor.getColumnIndex(DatabaseContract.KEY_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseContract.PUBLIC_KEY));

            weather.setPublickey(name);
            weather.setID(id);


            weathers.add(weather);
        }
        return weathers;
    }

    public void addKeyClass(KeyClass weather) {
        ContentValues cv = weatherToContentValues(weather);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert("'"+DatabaseContract.TABLE_NAME+ "'", null,cv);
    }


    public void deleteKeyClass(KeyClass weather) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DatabaseContract.TABLE_NAME, DatabaseContract.KEY_ID + " = ?",
                new String[] { String.valueOf(weather.getID()) });
        db.close();
        }




    private ContentValues weatherToContentValues(KeyClass weather) {
        ContentValues cv = new ContentValues();
        cv.put("'"+DatabaseContract.KEY_ID+"'", weather.getID());
        cv.put("'"+DatabaseContract.PUBLIC_KEY+"'", weather.getPublickey());
        return cv;
    }

}
