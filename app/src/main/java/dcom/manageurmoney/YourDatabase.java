package dcom.manageurmoney;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 9/20/2017.
 */

public class YourDatabase extends SQLiteOpenHelper {

    Context context;
    public static final String name="abhhi";
    public static final int vision=1;
    public static final String TABLE_NAME="SECOND";
    public static final String COL3="SPENT";
    public static final String COL4="SAVE";

    public YourDatabase(Context context)
    {
        super(context,name,null,vision);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sD) {
        String ss="Create table "+TABLE_NAME+" ("+COL3+" INTEGER,"+COL4+" TEXT)";
        sD.execSQL(ss);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
