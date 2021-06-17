package com.example.projectlogin1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin_Reports extends AppCompatActivity {

    DrawerLayout drawerreport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__reports);

        drawerreport = findViewById(R.id.drawerreport);
    }

    public void ClickMenu(View v){
        openDrawer(drawerreport);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawerreport);
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