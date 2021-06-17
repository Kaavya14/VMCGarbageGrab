package com.example.projectlogin1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdminMainActivity extends AppCompatActivity {
    CardView cvCreateBin, cvUpdateBin, cvCreateDriver, cvViewDriver, cvComplaints, cvReports, cvUserProfile, cvLogout;
    DrawerLayout drawermain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        cvCreateBin = findViewById(R.id.cvCreateBin);
        cvUpdateBin = findViewById(R.id.cvUpdateBin);
        cvCreateDriver = findViewById(R.id.cvCreateDriver);
        cvViewDriver = findViewById(R.id.cvViewDriver);
        cvComplaints = findViewById(R.id.cvComplaints);
        cvReports = findViewById(R.id.cvReports);
        cvUserProfile = findViewById(R.id.cvUserProfile);
        cvLogout = findViewById(R.id.cvLogout);

        drawermain = findViewById(R.id.drawermain);

        cvCreateBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), Create_Bin.class);
                startActivity(myIntent);
            }
        });

        cvUpdateBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), Update_Bin.class);
                startActivity(myIntent);
            }
        });

        cvCreateDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), Create_Driver.class);
                startActivity(myIntent);
            }
        });

        cvViewDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), View_Driver.class);
                startActivity(myIntent);
            }
        });

        cvComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), Admin_Complaints.class);
                startActivity(myIntent);
            }
        });

        cvReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplication(), Admin_Reports.class);
                startActivity(myIntent);
            }
        });

        cvUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminMainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Users");
                builder.setMessage("User ID : 1\n" + "Username : abc\n" + "Email : abc@gmail.com\n\n" + "User ID : 2\n" + "Username : pqr\n" + "Email : pqr@gmail.com\n\n" +
                        "User ID : 3\n" + "Username : xyz\n" + "Email : xyz@gmail.com\n\n" + "User ID : 4\n" + "Username : Kaavya\n" + "Email : kaavya@gmail.com\n\n");
                builder.show();
            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dlg = new AlertDialog.Builder(AdminMainActivity.this)
                        .setTitle("Logout")
                        .setMessage("Are your sure you want to logout?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent myIntent = new Intent(getApplication(), MainActivity.class);
                                startActivity(myIntent);
                                Toast.makeText(AdminMainActivity.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create();
                dlg.show();
            }
        });
    }
    public void ClickMenu(View v){
        openDrawer(drawermain);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawermain);
    }

    public void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        home();
    }

    public void home(){
        Intent myIntent = new Intent(getApplication(), AdminMainActivity.class);
        startActivity(myIntent);
    }
}