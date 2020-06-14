package com.nejdetkadirr.expensesproject.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;
        switch (position) {
            case 0:
                selectedFragment =  HomeFragment.newInstance();
                break;
            case 1:
                selectedFragment =  InfoFragment.newInstance();
                break;
            case 2:
                selectedFragment =  DetailFragment.newInstance();
                break;
            default:
                return null;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence selectedTitle;
        switch (position) {
            case 0:
                selectedTitle =  "VERİLER";
                break;
            case 1:
                selectedTitle =  "BİLGİLER";
                break;
            case 2:
                selectedTitle = "DETAYLAR";
                break;
            default:
                return null;
        }
        return selectedTitle;
    }
}
