package dcom.manageurmoney;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddSpentMoney extends AppCompatActivity {

    EditText ett,ettt;
    int total,spend,save;
    int sum=0;
    Integer[] arr=new Integer[50];
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_spent_money);
        ett=(EditText)findViewById(R.id.et3);
        ettt=(EditText)findViewById(R.id.et4);

    }
    public void add(View view)
    {
        MyDatabase md=new MyDatabase(this);
        SQLiteDatabase sd=md.getWritableDatabase();

        String qq="Select "+MyDatabase.COL2+" from "+MyDatabase.TABLE_NAME+"";
        Cursor cc=sd.rawQuery(qq,null);

        if(cc.moveToFirst()) {
            total = cc.getInt(0);
        }

        YourDatabase my=new YourDatabase(this);
        SQLiteDatabase ss=my.getWritableDatabase();

        String qr="Select "+YourDatabase.COL3+" from "+YourDatabase.TABLE_NAME+"";
        Cursor cs=ss.rawQuery(qr,null);
        if(cs.moveToFirst()) {

            do {

                int s = cs.getInt(0);
                arr[i] = s;
                sum = sum + s;
                i++;

            } while (cs.moveToNext());

        }
        spend=sum;
        save=total - sum;

        String moneys=ett.getText().toString().trim();
        String name=ettt.getText().toString().trim();
        int spentmoney=Integer.parseInt(moneys);

        if(save >= spentmoney) {

            String sql = " insert into " + YourDatabase.TABLE_NAME + " values(" + spentmoney + ",'" + name + "')";
            ss.execSQL(sql);

            if (moneys.isEmpty()) {
                ett.setError("Empty");
                ett.requestFocus();
                Toast.makeText(this, "please enter moneys", Toast.LENGTH_SHORT).show();
            } else if (name.isEmpty()) {
                ettt.setError("Empty");
                ettt.requestFocus();
                Toast.makeText(this, "please enter month", Toast.LENGTH_SHORT).show();

            } else {
                finish();
            }
        }else {
            Toast.makeText(this,"You have no enough money",Toast.LENGTH_SHORT).show();
        }
    }
}
