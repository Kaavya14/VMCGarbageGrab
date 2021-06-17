package com.example.projectlogin1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class View_Driver extends AppCompatActivity {

    Spinner spDriverID;
    EditText etName2, etEmail2, etPassword2, etMobile2, etAddress2, etAadhar2;
    Button btnDriverUp;
    DrawerLayout drawerudriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__driver);

        spDriverID = findViewById(R.id.spDriverID);
        etName2 = findViewById(R.id.etDName);
        etEmail2 = findViewById(R.id.etEmail2);
        etPassword2 = findViewById(R.id.etPassword2);
        etMobile2 = findViewById(R.id.etMobile2);
        etAddress2 = findViewById(R.id.etAddress2);
        etAadhar2 = findViewById(R.id.etAadhar2);
        btnDriverUp = findViewById(R.id.btnDriverUp);
        drawerudriver = findViewById(R.id.drawerudriver);

        List<Admin_Driver> admin_Driver = new ArrayList<>();
        Admin_Driver driver1 = new Admin_Driver("1");
        admin_Driver.add(driver1);
        Admin_Driver driver2 = new Admin_Driver("2");
        admin_Driver.add(driver2);
        Admin_Driver driver3 = new Admin_Driver("3");
        admin_Driver.add(driver3);

        ArrayAdapter<Admin_Driver> adapter = new ArrayAdapter<Admin_Driver>(this, android.R.layout.simple_spinner_item, admin_Driver);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spDriverID.setAdapter(adapter);

        btnDriverUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(View_Driver.this, "Driver Data Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getSelectedDriver(View v){
        Admin_Driver admin_driver = (Admin_Driver) spDriverID.getSelectedItem();
        displayDriverData(admin_driver);
    }

    public void displayDriverData(Admin_Driver ad){
        if (ad.getId() == "1"){
            etName2.setText("Driver");
            etEmail2.setText("driver@gmail.com");
            etPassword2.setText("1234");
            etMobile2.setText("1234567890");
            etAddress2.setText("abc");
            etAadhar2.setText("12345");
        }
        else if(ad.getId() == "2"){
            etName2.setText("");
            etEmail2.setText("");
            etPassword2.setText("");
            etMobile2.setText("");
            etAddress2.setText("");
            etAadhar2.setText("");
            etName2.setText("Driver");
            etEmail2.setText("driver@gmail.com");
            etPassword2.setText("2345");
            etMobile2.setText("2345678901");
            etAddress2.setText("pqr");
            etAadhar2.setText("67890");
        }
        else if (ad.getId() == "3"){
            etName2.setText("");
            etEmail2.setText("");
            etPassword2.setText("");
            etMobile2.setText("");
            etAddress2.setText("");
            etAadhar2.setText("");
            etName2.setText("Driver");
            etEmail2.setText("driver@gmail.com");
            etPassword2.setText("3456");
            etMobile2.setText("3456789012");
            etAddress2.setText("xyz");
            etAadhar2.setText("45678");
        }
    }

    public void ClickMenu(View v){
        openDrawer(drawerudriver);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawerudriver);
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