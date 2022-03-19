package com.example.mytest4;

import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new MyFragment1());
        fragmentList.add(new MyFragment2());
        fragmentList.add(new MyFragment3());

        List<String> mViewTitle = new ArrayList<>();
        mViewTitle.add("page1");
        mViewTitle.add("page2");
        mViewTitle.add("page3");

        ViewPager viewPager = findViewById(R.id.view_pager);
        MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(), fragmentList, mViewTitle);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(0);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setupWithViewPager(viewPager);

        // 在addTab的时候，设置Text，是不会生效的，代码中有removeAllTabs()
        // 在adapter中的getPageTitle进行设置也是可以的
        // 在这里设置，优先生效
//        tabLayout.getTabAt(0).setText("tab1");
//        tabLayout.getTabAt(1).setText("tab2");
//        tabLayout.getTabAt(2).setText("tab3");
    }
}