package com.example.mytest2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.layout1, null);
        View view2 = inflater.inflate(R.layout.layout2, null);
        View view3 = inflater.inflate(R.layout.layout3, null);

        List<View> mViewList = new ArrayList<>();
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);

        List<String> mViewTitle = new ArrayList<>();
        mViewTitle.add("page1");
        mViewTitle.add("page2");
        mViewTitle.add("page3");

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyPagerAdapter(getApplicationContext(), mViewList, mViewTitle));
    }
}