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

public class Admin_Complaints extends AppCompatActivity {

    Spinner spComplaintID, spStatus;
    Button btnStatusUp;
    EditText etBinIDC, etUserEmailC, etDesC;
    DrawerLayout drawercomp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__complaints);

        spComplaintID = findViewById(R.id.spComplaintID);
        etBinIDC = findViewById(R.id.etBinIDC);
        etUserEmailC = findViewById(R.id.etUserEmailC);
        etDesC = findViewById(R.id.etDesC);
        spStatus = findViewById(R.id.spStatus);
        btnStatusUp = findViewById(R.id.btnStatusUp);
        drawercomp = findViewById(R.id.drawercomp);

        List<AdminComplaints> ac = new ArrayList<>();
        AdminComplaints c1 = new AdminComplaints("1");
        ac.add(c1);
        AdminComplaints c2 = new AdminComplaints("2");
        ac.add(c2);
        AdminComplaints c3 = new AdminComplaints("3");
        ac.add(c3);

        List<AdminStatus> as = new ArrayList<>();
        AdminStatus s1 = new AdminStatus("Pending");
        as.add(s1);
        AdminStatus s2 = new AdminStatus("In Progress");
        as.add(s2);
        AdminStatus s3 = new AdminStatus("Completed");
        as.add(s3);
        AdminStatus s4 = new AdminStatus("Rejected");
        as.add(s4);

        ArrayAdapter<AdminComplaints> adapter = new ArrayAdapter<AdminComplaints>(this, android.R.layout.simple_spinner_item, ac);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spComplaintID.setAdapter(adapter);

        ArrayAdapter<AdminStatus> adapter2 = new ArrayAdapter<AdminStatus>(this, android.R.layout.simple_spinner_item, as);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spStatus.setAdapter(adapter2);

        btnStatusUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin_Complaints.this, "Complaint Status Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getSelectedComplaint(View v){
        AdminComplaints adminComplaints = (AdminComplaints) spComplaintID.getSelectedItem();
        displayComplaintData(adminComplaints);
    }

    public void displayComplaintData(AdminComplaints ac) {
        if (ac.getCid() == "1") {
            etBinIDC.setText("1");
            etUserEmailC.setText("abc@gmail.com");
            etDesC.setText("Dirty");
        } else if (ac.getCid() == "2") {
            etBinIDC.setText("");
            etUserEmailC.setText("");
            etDesC.setText("");
            etBinIDC.setText("3");
            etUserEmailC.setText("xyz@gmail.com");
            etDesC.setText("Roads not clean.");
        } else if (ac.getCid() == "3") {
            etBinIDC.setText("");
            etUserEmailC.setText("");
            etDesC.setText("");
            etBinIDC.setText("2s");
            etUserEmailC.setText("pqr@gmail.com");
            etDesC.setText("Dirty");
        }
    }

    /*public void getSelectedStatus(){
        AdminStatus adminStatus = (AdminStatus) spStatus.getSelectedItem();
    }*/

    public void ClickMenu(View v){
        openDrawer(drawercomp);
    }

    public void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View v){
        closeDrawer(drawercomp);
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