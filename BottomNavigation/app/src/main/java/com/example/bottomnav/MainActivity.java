package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottom_nav_id);
        bottomNavigationView.setOnItemSelectedListener(listener);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new HomeFragment()).commit();

    }

    public BottomNavigationView.OnNavigationItemSelectedListener listener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment Selected_fragment=null;
            switch (item.getItemId()){
                case R.id.home_id:
                    Selected_fragment=new HomeFragment();
                    break;
                case R.id.message_id:
                    Selected_fragment=new MessageFragment();
                    break;
                case R.id.share_id:
                    Selected_fragment=new ShareFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,Selected_fragment).commit();

            return true;
        }
    };
}