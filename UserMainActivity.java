package com.example.projectlogin1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserMainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    String EmailHolder;
    TextView Email;
    BottomNavigationView BottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        //loading the default fragment
        loadFragment(new User_home_fragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_nav);
        navigation.setOnNavigationItemSelectedListener(this);
        Email = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        EmailHolder=getIntent().getStringExtra("email");

        // Setting up received email to TextView.
        Email.setText(Email.getText().toString() + EmailHolder);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.homeid:
                fragment = new User_home_fragment();
                break;

            case R.id.complainid:
                fragment = new User_complaint_fragment();
                break;

            case R.id.checkcomplainid:
                Toast.makeText(UserMainActivity.this, "Complaint Submitted successfully. Kindly be patient", Toast.LENGTH_LONG).show();
                fragment = new User_mycomplaints_fragment();
                break;

            case R.id.myprofileid:
                fragment = new User_myprofile_fragment();
                break;

            case R.id.logoutid:
                Intent intent=new Intent(UserMainActivity.this,MainActivity.class);
                Toast.makeText(UserMainActivity.this, "Log Out Successfull", Toast.LENGTH_LONG).show();
                startActivity(intent);
                break;


        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}