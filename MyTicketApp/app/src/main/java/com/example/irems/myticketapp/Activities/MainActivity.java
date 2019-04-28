package com.example.irems.myticketapp.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.irems.myticketapp.Fragments.BiletEkleFragment;
import com.example.irems.myticketapp.Fragments.BuyTicketFragment;
import com.example.irems.myticketapp.Fragments.ProfileFragment;
import com.example.irems.myticketapp.Fragments.TicketsFragment;
import com.example.irems.myticketapp.Models.MovieTicket;
import com.example.irems.myticketapp.R;
import com.example.irems.myticketapp.adapter.FilmAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    public ArrayList<MovieTicket> filmListesi = new ArrayList<>();
    public ArrayList<MovieTicket> satinalinanList = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_biletekle:
                        selectedFragment = new BiletEkleFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }
                if (selectedFragment != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fl_container, selectedFragment);
                    transaction.commit();
                    drawer.closeDrawer(Gravity.START);
                }
                return true;
            }
        });

        bottomNavigationView = findViewById(R.id.bottomnav_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        //filmListesi.add(new MovieTicket(R.drawable.film1, "Hızlı ve Öfkeli", "10:00", "30"));
        //filmListesi.add(new MovieTicket(R.drawable.film2, "Iron Man", "14:00", "30"));
        //filmListesi.add(new MovieTicket(R.drawable.film3, "Harry Potter", "18:00", "30"));
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment = null;
        switch (menuItem.getItemId()) {
            case R.id.navitem_ticket:
                selectedFragment = new TicketsFragment();
                break;
            case R.id.navitem_buy:
                selectedFragment = new BuyTicketFragment();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_container, selectedFragment);
        transaction.commit();


        return true;
    }
}
