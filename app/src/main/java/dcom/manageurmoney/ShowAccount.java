package dcom.manageurmoney;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowAccount extends AppCompatActivity {

    TextView tvn,tvt,tvs,tvsa;
    ListView lis;
    int sum=0;
    int total,spend,save;

    Integer[] arr=new Integer[50];
    String [] array=new String[50];
    int i=0;
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_account);

        tvn=(TextView)findViewById(R.id.tv3);
        tvt=(TextView)findViewById(R.id.tv5);
        tvs=(TextView)findViewById(R.id.tv7);
        tvsa=(TextView)findViewById(R.id.tv9);
        lis=(ListView)findViewById(R.id.lv);

        MyDatabase md=new MyDatabase(this);
        SQLiteDatabase sd=md.getWritableDatabase();

        String qry="select "+MyDatabase.COL1+" from "+MyDatabase.TABLE_NAME+"";
        Cursor c=sd.rawQuery(qry,null);

        if(c.moveToFirst())
        {
            String name=c.getString(0);
            tvn.setText(name);
        }

        String qq="Select "+MyDatabase.COL2+" from "+MyDatabase.TABLE_NAME+"";
        Cursor cc=sd.rawQuery(qq,null);

        if(cc.moveToFirst())
        {
            total=cc.getInt(0);
            String t=String.valueOf(total);
            tvt.setText(t);
        }

        YourDatabase yr=new YourDatabase(this);
        SQLiteDatabase ss=yr.getWritableDatabase();

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

        String s=String.valueOf(spend);
        tvs.setText(s);

        String sa=String.valueOf(save);
        tvsa.setText(sa);

        String qrr="Select "+YourDatabase.COL4+" from "+YourDatabase.TABLE_NAME+"";
        Cursor ccc=ss.rawQuery(qrr,null);

        if(ccc.moveToFirst())
        {
            do {

                String name=ccc.getString(0);
                array[num]=name;
                num++;
            }while (ccc.moveToNext());
        }

        ArrayList al=new ArrayList();
        String keys[]={"arr","array"};

        int ids[]={R.id.tvv1,R.id.tvv2};

        for(int n=0;n<arr.length;n++)
        {
            HashMap hm=new HashMap();
            hm.put(keys[0],arr[n]);
            hm.put(keys[1],array[n]);
            al.add(hm);
        }


        SimpleAdapter saa=new SimpleAdapter(this,al,R.layout.list_style,keys,ids);
        lis.setAdapter(saa);

        TextView t=new TextView(this);

        t.setText("List");

        lis.addHeaderView(t);


    }

}
