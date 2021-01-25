package com.example.covid_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    Button bsafe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv=(TextView) findViewById(R.id.textView3);
        bsafe=findViewById(R.id.button5);
        Intent i=getIntent();
        String status=i.getStringExtra("Status");
        int count=i.getIntExtra("count",0);
        tv.setText(status);
        bsafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status2=new String();
                if(count==5)
                {
                    status2="Congrats!! You are Safe.Take Care";
                }
                else
                    status2="You are unsafe!! Take Precautions";
                Intent i1=new Intent();
                i1.putExtra("op",status2);
                setResult(RESULT_OK,i1);
                finish();
            }
        });
    }
    public void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"State of activity MainActivity2 changed from Created to Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"State of activity MainActivity2 changed from Started to Paused.",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"State of activity MainActivity2 changed from Paused to Resumed.",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"State of activity MainActivity2 changed from Paused to Stopped.",Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"State of activity MainActivity2 changed from Stopped to Destroyed.",Toast.LENGTH_SHORT).show();
    }
}