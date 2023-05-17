package com.fakhronidaeriza.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    private  MyFragmentPagerAdapter _myFragmentPagerAdapter;
    private TabLayout tablayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint("MissingInflatedId") TabLayout tabLayout1 = (TabLayout) findViewById(R.id.tabLayout1);
        tablayout1.addTab(tablayout1.newTab().setText("E-Commerce"));
        tablayout1.addTab(tablayout1.newTab().setText("Berita"));
        tablayout1.addTab(tablayout1.newTab().setText("Kampus"));
        tablayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager1 = (ViewPager) findViewById(R.id.viewPager1);

        _myFragmentPagerAdapter = new MyFragmentPagerAdapter( this,getSupportFragmentManager(),tablayout1.getTabCount());
        viewPager1.setAdapter(_myFragmentPagerAdapter);
        viewPager1.setOffscreenPageLimit(3);


        tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });


    }
}