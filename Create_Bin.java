package com.example.projectlogin1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class Create_Bin extends AppCompatActivity implements LocationListener {

    EditText etBinID, etArea, etLocality, etLandmark, etADEmail;
    Button btnLocation, btnCreate;
    LocationManager locationManager;
    public String la, ln;
    public String add;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    DrawerLayout drawercbin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__bin);

        btnLocation = findViewById(R.id.btnLocation);
        btnCreate = findViewById(R.id.btnCreate);
        etBinID = findViewById(R.id.etBinID);
        etArea = findViewById(R.id.etArea);
        etLocality = findViewById(R.id.etLocality);
        etLandmark = findViewById(R.id.etLandmark);
        etADEmail = findViewById(R.id.etADEmail);
        drawercbin = findViewById(R.id.drawercbin);

        openHelper = new ACBinDBHelper(this);

        if (ContextCompat.checkSelfPermission(Create_Bin.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Create_Bin.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
                Toast.makeText(getApplicationContext(), la+ln, Toast.LENGTH_LONG).show();
            }

        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String area = etArea.getText().toString().trim();
                String locality = etLocality.getText().toString().trim();
                String landmark = etLandmark.getText().toString().trim();
                String ademail = etADEmail.getText().toString().trim();

                db = openHelper.getWritableDatabase();

                insertData(area, locality, landmark, ademail, la, ln, add);
                Toast.makeText(getApplicationContext(), "New Bin Created", Toast.LENGTH_LONG).show();
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, Create_Bin.this);

        }catch (Exception e){

        }

    }

    @Override
    public void onLocationChanged(Location location) {
        la = String.valueOf(location.getLatitude());
        ln = String.valueOf(location.getLongitude());
        try {
            Geocoder geocoder = new Geocoder(Create_Bin.this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            add = addresses.get(0).getAddressLine(0);
        } catch (Exception e){

        }
        Toast.makeText(Create_Bin.this, la+ln, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void insertData(String area, String locality, String landmark, String ademail, String longitude, String latitude, String address){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ACBinDBHelper.COL_2, area);
        contentValues.put(ACBinDBHelper.COL_3, locality);
        contentValues.put(ACBinDBHelper.COL_4, landmark);
        contentValues.put(ACBinDBHelper.COL_5, ademail);
        contentValues.put(ACBinDBHelper.COL_6, longitude);
        contentValues.put(ACBinDBHelper.COL_7, latitude);
        contentValues.put(ACBinDBHelper.COL_8, address);

        long id = db.insert(ACBinDBHelper.TABLE_NAME, null,contentValues);
    }

    public void ClickMenu(View v){
        openDrawer(drawercbin);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawercbin);
    }

    public void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        home();
    }

    public void home() {
        Intent myIntent = new Intent(getApplication(), AdminMainActivity.class);
        startActivity(myIntent);
    }
}