package bitcard.cosc431.bitcard.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class KeyDBHelper extends SQLiteOpenHelper {



    private static final String DATABASE_NAME = "keydatabase2.db";
    private static final int DB_VERSION = 4;

    private static final String CREATE_TABLE =
            "create table " + DatabaseContract.TABLE_NAME + " ( '" +
                    DatabaseContract.KEY_ID + "' text primary key, '" +
                    DatabaseContract.PUBLIC_KEY + "' text); ";




    public KeyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
