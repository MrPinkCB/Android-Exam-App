package com.example.orion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> myPeople=new ArrayList<>();
    public static ArrayList<Integer> peoplePics= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myPeople.add("Alison");
        myPeople.add("Betsy");
        myPeople.add("Charles");
        myPeople.add("Kurt");
        myPeople.add("Logan");
        myPeople.add("Ororo");
        myPeople.add("Piotr");

        peoplePics.add(R.drawable.alison);
        peoplePics.add(R.drawable.betsy);
        peoplePics.add(R.drawable.charles);
        peoplePics.add(R.drawable.kurt);
        peoplePics.add(R.drawable.logan);
        peoplePics.add(R.drawable.ororo);
        peoplePics.add(R.drawable.piotr);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }







    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment=null;
            switch (item.getItemId())
            {
                case R.id.home:
                    selectedFragment= new HomeFragment();
                    break;

                case R.id.user:
                    selectedFragment= new UserFragment();
                    break;

                case R.id.search:
                    selectedFragment= new SearchFragment();
                    break;

                case R.id.credits:
                    selectedFragment= new CreditsFragment();
                    break;


            }




            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };


}