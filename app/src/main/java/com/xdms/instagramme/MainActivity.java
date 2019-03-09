package com.xdms.instagramme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.xdms.instagramme.fragments.ComposeFragment;
import com.xdms.instagramme.fragments.PostsFragment;
import com.xdms.instagramme.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

    private Toolbar myToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        */

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        final FragmentManager fragmentManager = getSupportFragmentManager();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment;

                switch (item.getItemId()) {
                    case R.id.action_home:
                    default:
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        //Set default navigation
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}
