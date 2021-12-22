package com.mycompany.myapp.cframework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Paul on 11/23/2017.
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter{
    private static int positio;
//   private List<Fragment> fragments;
    public MyFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public  Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new InfoFragment();
            case 2:
                return new AccountFragment();
            case 3:
                return new StudentFragment();
            case 4:
                return new DocumentFragment();
        }
        return null;
    }

    @Override
    public int getCount(){
     return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
switch (position){
    case 0: return "Home";
    case 1: return "News and Information";
    case 2: return "Account";
    case 3: return "Students";
    case 4: return "Documents";
}
        return null;
    }
}
