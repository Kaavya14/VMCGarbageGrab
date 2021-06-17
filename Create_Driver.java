package com.example.projectlogin1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Create_Driver extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etMobile, etAddress, etAadhar, etId;
    Button btnDriverReg;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DrawerLayout drawerrdriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__driver);

        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etMobile = findViewById(R.id.etMobile);
        etAddress = findViewById(R.id.etAddress);
        etAadhar = findViewById(R.id.etAadhar);
        btnDriverReg = findViewById(R.id.btnDriverReg);
        drawerrdriver = findViewById(R.id.drawerrdriver);

        openHelper = new ADriverDBHelper(this);

        btnDriverReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String pass = etPassword.getText().toString().trim();
                String mobile = etMobile.getText().toString().trim();
                String add = etAddress.getText().toString().trim();
                String aadhar = etAadhar.getText().toString().trim();

                db = openHelper.getWritableDatabase();

                insertData(name, email, pass, mobile, add, aadhar);
                Toast.makeText(getApplicationContext(), "Driver Registered", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void insertData(String name, String pass, String email, String mobile, String add, String aadhar){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ADriverDBHelper.COL_2, name);
        contentValues.put(ADriverDBHelper.COL_3, email);
        contentValues.put(ADriverDBHelper.COL_4, pass);
        contentValues.put(ADriverDBHelper.COL_5, mobile);
        contentValues.put(ADriverDBHelper.COL_6, add);
        contentValues.put(ADriverDBHelper.COL_7, aadhar);

        long id = db.insert(ADriverDBHelper.TABLE_NAME, null,contentValues);
    }

    public void ClickMenu(View v){
        openDrawer(drawerrdriver);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawerrdriver);
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