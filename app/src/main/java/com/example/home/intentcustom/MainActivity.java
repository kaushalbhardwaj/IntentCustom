package com.example.home.intentcustom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText user,password;
    Button forward,fbackward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        forward=(Button)findViewById(R.id.button);
        fbackward=(Button)findViewById(R.id.button2);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                i.putExtra("key1",""+user.getText().toString());
                i.putExtra("key2", "" + password.getText().toString());
                startActivity(i);
                finish();
            }
        });

        fbackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main3Activity.class);
                i.putExtra("key1",""+user.getText().toString());
                i.putExtra("key2",""+password.getText().toString());
                //Toast.makeText(getApplicationContext(),"okk",Toast.LENGTH_SHORT).show();
                startActivityForResult(i,1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000&&resultCode==RESULT_OK)
        {
            String msg;
            Bundle b;
            b=data.getExtras();
            user.setText("");
            password.setText("");
            msg=b.getString("rkey1").toString();
            Toast.makeText(MainActivity.this,"This is the return message by activity\n"+msg,Toast.LENGTH_LONG).show();
        }
    }

}
