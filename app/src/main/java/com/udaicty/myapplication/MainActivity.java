package com.udaicty.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     * Create an activity that does the following things:

     Sets the content view to be the layout with the ViewPager.
     Creates a class that extends the FragmentStatePagerAdapter abstract class and
     implements the getItem() method to supply instances of ScreenSlidePageFragment as new pages.
     The pager adapter also requires that you implement the getCount() method,
     which returns the amount of pages the adapter will create (five in the example).
     Hooks up the PagerAdapter to the ViewPager.
     Handles the device's back button by moving backwards in the virtual stack of fragments.
     If the user is already on the first page, go back on the activity back stack.
     * */
    /**
     * The number of pages to show (playlist/artists/albums/songs)
     * */
    private static final int NUM_PAGES = 4;
    /**
     * The page widget
     * */
    private ViewPager mViewPager;
    /**
     * The page adapter which provides the pages to view pager widget
     * */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager)findViewById(R.id.pager);
        mPagerAdapter = new PlaceHolderPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0){
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            //Otherwise, select the previous step
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }

    /**
     * Simple pager adapter that represents 4 page object in sequence
     * */
    private class PlaceHolderPagerAdapter extends FragmentStatePagerAdapter {
        public PlaceHolderPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
                return PlaylistFragment.newInstance(null, position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
