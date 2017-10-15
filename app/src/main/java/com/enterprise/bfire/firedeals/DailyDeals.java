package com.enterprise.bfire.firedeals;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class DailyDeals extends Fragment {

    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.bottomOne:
                    transaction.replace(R.id.frame, new GadgetsFragment()).commit();
                    return true;
                case R.id.bottomTwo:
                    transaction.replace(R.id.frame, new AccessoriesFragment()).commit();
                    return true;
                case R.id.bottomThree:
                    transaction.replace(R.id.frame, new SportsFragment()).commit();
                   return true;
                case R.id.bottomFour:
                    transaction.replace(R.id.frame, new FashionFragment()).commit();
                    return true;
            }


            return false;
        }
    };


    public DailyDeals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_daily_deals, container, false);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame, new GadgetsFragment()).commit();
        bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mNavigationItemSelectedListener);
        return view;


    }


}
