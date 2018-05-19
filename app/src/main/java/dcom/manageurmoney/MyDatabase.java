package dcom.manageurmoney;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 9/19/2017.
 */

public class  MyDatabase extends SQLiteOpenHelper {

    Context context;
    public static final String name="abhi";
    public static final int version=1;
    public static final String TABLE_NAME="DETAILS";
    public static final String COL1="MONTH";
    public static final String COL2="TOTAL";

    public MyDatabase(Context context) {
        super(context, name, null, version);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table "+TABLE_NAME+"("+COL1+" TEXT,"+COL2+" INTEGER)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
