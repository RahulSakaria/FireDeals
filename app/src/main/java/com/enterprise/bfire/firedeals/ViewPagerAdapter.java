package com.enterprise.bfire.firedeals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 04-10-2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

     ArrayList<Fragment> fragment = new ArrayList<>();
    ArrayList<String> tabTitles = new ArrayList<>();


    public void addFragments(Fragment fragment,String titles){
        this.fragment.add(fragment);
        this.tabTitles.add(titles);
    }




    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitles.get(position);
    }
}
