package dcom.manageurmoney;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DeleteAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);
    }

    public void deleteAll(View view)
    {
        MyDatabase md=new MyDatabase(this);
        SQLiteDatabase ss=md.getWritableDatabase();

        String qq="delete from "+MyDatabase.TABLE_NAME+"";
        ss.execSQL(qq);

        YourDatabase yy=new YourDatabase(this);
        SQLiteDatabase as=yy.getWritableDatabase();

        String qr="delete from "+YourDatabase.TABLE_NAME+"";
        as.execSQL(qr);

        Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();

        finish();
    }
}
