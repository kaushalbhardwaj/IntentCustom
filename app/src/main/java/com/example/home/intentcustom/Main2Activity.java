package com.example.home.intentcustom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView msg;
    String user,password,msg2;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back=(Button)findViewById(R.id.button3);
        msg=(TextView)findViewById(R.id.textView3);

        Bundle b=getIntent().getExtras();
        user=b.getString("key1").toString();
        password=b.getString("key2").toString();
        msg2=msg.getText().toString()+"\nuser:"+user+"\n"+"password:"+password;
        msg.setText(msg2);
        //msg.append(message);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
