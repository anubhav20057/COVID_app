package com.example.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4,cb5;
    EditText editTextTextPersonName2;
    TextView txt2;
    Button b1,b2;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTextPersonName2=(EditText)findViewById(R.id.editTextTextPersonName);
        cb1=findViewById(R.id.checkBox);
        cb2=findViewById(R.id.checkBox2);
        cb3=findViewById(R.id.checkBox3);
        cb4=findViewById(R.id.checkBox4);
        cb5=findViewById(R.id.checkBox5);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        String username1 = editTextTextPersonName2.getText().toString();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked())
                {
                    cb1.setChecked(false);
                }
                if(cb2.isChecked())
                {
                    cb2.setChecked(false);
                }
                if(cb3.isChecked())
                {
                    cb3.setChecked(false);
                }
                if(cb4.isChecked())
                {
                    cb4.setChecked(false);
                }
                if(cb5.isChecked())
                {
                    cb5.setChecked(false);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result=new StringBuffer();
                int k=0;
                result.append("Hi!!!  "+editTextTextPersonName2.getText().toString());
                if(cb1.isChecked())
                {
                    result.append("\n\n  "+cb1.getText().toString()+"\t YES");
                    k+=1;
                }
                if(!cb1.isChecked())
                {
                    result.append("\n  "+cb1.getText().toString()+"\t NO");
                }
                if(cb2.isChecked())
                {
                    result.append("\n  "+cb2.getText().toString()+"\t YES");
                    k+=1;
                }
                if(!cb2.isChecked())
                {
                    result.append("\n  "+cb2.getText().toString()+"\t NO");
                }
                if(cb3.isChecked())
                {
                    result.append("\n  "+cb3.getText().toString()+"\t YES");
                    k+=1;
                }
                if(!cb3.isChecked())
                {
                    result.append("\n  "+cb3.getText().toString()+"\t NO");
                }
                if(cb4.isChecked())
                {
                    result.append("\n  "+cb4.getText().toString()+"\t YES");
                    k+=1;
                }
                if(!cb4.isChecked())
                {
                    result.append("\n  "+cb4.getText().toString()+"\t NO");

                }
                if(cb5.isChecked())
                {
                    result.append("\n  "+cb5.getText().toString()+"\t YES");
                    k+=1;
                }
                if(!cb5.isChecked())
                {
                    result.append("\n  "+cb5.getText().toString()+"\t NO");
                }
                String r=result.toString();
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("Status",r);
                i.putExtra("count",k);
                startActivity(i);
                startActivityForResult(i,1);
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() called");
        Toast.makeText(getApplicationContext(),"State of activity MainActivity1 changed from Created to Started",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() called");
        Toast.makeText(getApplicationContext(),"State of activity MainActivity1 changed from Started to Paused.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() called");
        Toast.makeText(getApplicationContext(),"State of activity MainActivity1 changed from Paused to Resumed.",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() called");
        Toast.makeText(getApplicationContext(),"State of activity MainActivity1 changed from Paused to Stopped.",Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() called");
        Toast.makeText(getApplicationContext(),"State of activity MainActivity1 changed from Stopped to Destroyed.",Toast.LENGTH_SHORT).show();
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        txt2=(TextView)findViewById(R.id.textView2);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strStatus = data.getStringExtra("op");
                txt2.setText(strStatus);
            }
        }
    }
}