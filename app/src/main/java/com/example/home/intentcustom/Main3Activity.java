package com.example.home.intentcustom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView msg;
    String user,password,msg2;
    Button back;
    EditText msg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        back=(Button)findViewById(R.id.button4);
        msg=(TextView)findViewById(R.id.textView4);
        msg3=(EditText)findViewById(R.id.editText3);

        Bundle b=getIntent().getExtras();
        user=b.getString("key1").toString();
        password=b.getString("key2").toString();
        msg2=msg.getText().toString()+"\n"+user+"\n"+"password="+password;
        msg.setText(msg2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("rkey1",""+msg3.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}
