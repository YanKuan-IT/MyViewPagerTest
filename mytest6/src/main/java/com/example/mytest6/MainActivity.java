package com.example.mytest6;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private MyFragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MyFragment1());
        fragmentList.add(new MyFragment2());
        fragmentList.add(new MyFragment3());

        fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(onPageChangeListener);
        viewPager.setPageTransformer(true, new MyPagerTransformer());
        
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

        @Override
        public void onPageSelected(int position) {
            int itemID = R.id.fragment1;
            switch (position) {
                case 0:
                    itemID = R.id.fragment1;
                    break;
                case 1:
                    itemID = R.id.fragment2;
                    break;
                case 2:
                    itemID = R.id.fragment3;
                    break;
            }
            bottomNavigationView.setSelectedItemId(itemID);
        }

        @Override
        public void onPageScrollStateChanged(int state) { }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.fragment1:
                    viewPager.setCurrentItem(0, true);
                    return true;
                case R.id.fragment2:
                    viewPager.setCurrentItem(1, true);
                    return true;
                case R.id.fragment3:
                    viewPager.setCurrentItem(2, true);
                    return true;
            }
            return false;
        }
    };
}