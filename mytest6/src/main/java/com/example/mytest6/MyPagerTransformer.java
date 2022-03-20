package com.example.mytest6;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class MyPagerTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        float max_rotation = 20.0f;
        if (position < -1) {
            rotate(page, -max_rotation);
        } else if (position <= 1) {
            rotate(page, max_rotation * position);
        } else {
            rotate(page, max_rotation);
        }
    }

    private void rotate(View view, float r) {
        view.setPivotX(view.getWidth() * 0.2f);
        view.setPivotY(view.getHeight());
        view.setRotation(r);
    }
}
