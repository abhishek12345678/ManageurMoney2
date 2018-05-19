package dcom.manageurmoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void showAccount(View view)
    {
        Intent i=new Intent(this,ShowAccount.class);
        startActivity(i);
    }

    public void spendMoney(View view)
    {
        Intent i=new Intent(this,AddSpentMoney.class);
        startActivity(i);
    }

    public void createAccount(View view)
    {
        Intent i=new Intent(this,CreateAccount.class);
        startActivity(i);
    }

    public void deleteAccount(View view)
    {
        Intent i=new Intent(this,DeleteAccount.class);
        startActivity(i);

    }
}
