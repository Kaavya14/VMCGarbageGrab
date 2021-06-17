package com.example.projectlogin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class UserActivitySplash extends AppCompatActivity {
    String EmailHolder;
    TextView Email;
    ProgressBar progressBar;
    ImageView imageView;
    Handler handler;
    int progress=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_splash);

        progressBar=findViewById(R.id.progressBar);

        setProgressValue(progress);

        //add Handler to start new Activity after some time

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent =new Intent(UserActivitySplash.this,UserMainActivity.class);
                intent.putExtra("email",EmailHolder);
                startActivity(intent);
                fileList();


            }
        },5000);






        imageView=findViewById(R.id.imageView);
        Email = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder=getIntent().getStringExtra("email");


        // Setting up received email to TextView.
       //Email.setText(Email.getText().toString() + EmailHolder);
    }

    private void setProgressValue(final int progress){
        //set the progress bar
        progressBar.setProgress(progress);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);

                } catch (Exception e) {

                    e.printStackTrace();
                }

                setProgressValue(progress+30);

            }
        });
        thread.start();
    }
}