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

public class Update_Bin extends AppCompatActivity {

    Spinner spBinID;
    EditText etArea2, etLocality2, etLandmark2, etEADriver2, etLatitude, etLongitude, etAdd;
    Button btnBinUp;
    DrawerLayout drawerubin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__bin);

        spBinID = findViewById(R.id.spBinID);
        etArea2 = findViewById(R.id.etArea2);
        etLocality2 = findViewById(R.id.etLocality2);
        etLandmark2 = findViewById(R.id.etLandmark2);
        etEADriver2 = findViewById(R.id.etEADriver2);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        etAdd = findViewById(R.id.etAdd);
        btnBinUp = findViewById(R.id.btnBinUp);
        drawerubin = findViewById(R.id.drawerubin);

        List<AdminBin> adminBin = new ArrayList<>();
        AdminBin bin1 = new AdminBin("1");
        adminBin.add(bin1);
        AdminBin bin2 = new AdminBin("2");
        adminBin.add(bin2);
        AdminBin bin3 = new AdminBin("3");
        adminBin.add(bin3);

        ArrayAdapter<AdminBin> adapter = new ArrayAdapter<AdminBin>(this, android.R.layout.simple_spinner_item, adminBin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spBinID.setAdapter(adapter);

        btnBinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Update_Bin.this, "Bin Data Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getSelectedBin(View v){
        AdminBin adminBin = (AdminBin) spBinID.getSelectedItem();
        displayBinData(adminBin);
    }

    public void displayBinData(AdminBin ab){
        if (ab.getBid() == "1") {
            etArea2.setText("Manjalpur");
            etLocality2.setText("Vaibhavlaxmi crossroad");
            etLandmark2.setText("Eva Mall");
            etEADriver2.setText("driver@gmail.com");
            etLatitude.setText("37.421998333333335");
            etLongitude.setText("-122.08400000000002");
            etAdd.setText("");
        }
        else if (ab.getBid() == "2"){
            etArea2.setText("");
            etLocality2.setText("");
            etLandmark2.setText("");
            etEADriver2.setText("");
            etLatitude.setText("");
            etLongitude.setText("");
            etAdd.setText("");
            etArea2.setText("Vasna Bhaili");
            etLocality2.setText("Vasna Road");
            etLandmark2.setText("Bright Day School");
            etEADriver2.setText("driver@gmail.com");
            etLatitude.setText("37.421998333333335");
            etLongitude.setText("-122.08400000000002");
            etAdd.setText("");
        }
        else if (ab.getBid() == "3") {
            etArea2.setText("");
            etLocality2.setText("");
            etLandmark2.setText("");
            etEADriver2.setText("");
            etLatitude.setText("");
            etLongitude.setText("");
            etAdd.setText("");
            etArea2.setText("Raopura");
            etLocality2.setText("Tower Road");
            etLandmark2.setText("Near SBI Bank");
            etEADriver2.setText("driver@gmail.com");
            etLatitude.setText("37.421998333333335");
            etLongitude.setText("-122.08400000000002");
            etAdd.setText("");
        }
    }

    public void ClickMenu(View v){
        openDrawer(drawerubin);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawerubin);
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