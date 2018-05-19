package dcom.manageurmoney;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {


    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);



    }
    public void submit(View view)
    {
       MyDatabase my=new MyDatabase(this);
        SQLiteDatabase sd=my.getWritableDatabase();

        String month=et1.getText().toString().trim();
        String money=et2.getText().toString().trim();
        int totalmoney=Integer.parseInt(money);

        String sql="insert into "+MyDatabase.TABLE_NAME+" values('"+month+"',"+money+")";
        sd.execSQL(sql);

        if(month.isEmpty())
        {
            et1.setError("Empty");
            et1.requestFocus();
            Toast.makeText(this,"Month_Empty",Toast.LENGTH_SHORT).show();
        }
        else if(money.isEmpty())
        {
            et2.setError("Empty");
            et2.requestFocus();
            Toast.makeText(this,"Money_Empty",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Sumbit",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

