package com.example.projectlogin1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DriverMainActivity extends AppCompatActivity {
    CardView cvMaps;
    EditText etDest;
    DrawerLayout drawerdrivermain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);

        cvMaps = findViewById(R.id.cvMaps);
        etDest = findViewById(R.id.etDest);
        drawerdrivermain = findViewById(R.id.drawerdrivermain);

        cvMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dest = etDest.getText().toString().trim();
                String source = "Vadodara Minucipal Corporation";

                if (dest.equals("")){
                    Toast.makeText(DriverMainActivity.this, "Enter The Destination", Toast.LENGTH_LONG).show();
                }
                else {
                    DisplayTrack(dest, source);
                }
            }
        });

    }

    private void DisplayTrack(String dest, String source){
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + source + "/" + dest);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    public void ClickMenu(View v){
        openDrawer(drawerdrivermain);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawerdrivermain);
    }

    public void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickLogout(View view){
        logout();
    }

    public void logout(){
        AlertDialog dlg = new AlertDialog.Builder(DriverMainActivity.this)
                .setTitle("Logout")
                .setMessage("Are your sure you want to logout?")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myIntent = new Intent(getApplication(), MainActivity.class);
                        startActivity(myIntent);
                        Toast.makeText(DriverMainActivity.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
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
}