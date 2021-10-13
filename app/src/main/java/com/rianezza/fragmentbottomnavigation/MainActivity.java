package com.rianezza.fragmentbottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new ChatFragment()).commit();
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFrag = null;

                switch (item.getItemId()) {
                    case R.id.nav_chat:
                        selectedFrag = new ChatFragment();
                        break;
                    case R.id.nav_calls:
                        selectedFrag = new CallFragment();
                        break;
                    case R.id.nav_story:
                        selectedFrag = new StatusFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFrag).commit();
                return true;
            }
        });
    }
}