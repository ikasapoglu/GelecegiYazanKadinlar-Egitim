package com.gyk.ders6.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.gyk.ders6.fragments.BilgiEkraniFragment;
import com.gyk.ders6.fragments.DiyetListesiFragment;
import com.gyk.ders6.fragments.EndeksHesaplaFragment;
import com.gyk.ders6.R;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnav_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment = null;

        switch (menuItem.getItemId()){
            case R.id.navitem_endekshesapla:
                selectedFragment = new EndeksHesaplaFragment();
                break;
            case  R.id.navitem_bilgiekrani:
                selectedFragment = new BilgiEkraniFragment();
                break;
            case R.id.navitem_dietlistesi:
                selectedFragment = new DiyetListesiFragment();
                break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, selectedFragment);
        transaction.commit();

        return true;
    }
}
