package com.example.mytest1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

/***
 * 适配器
 */
public class MyPagerAdapter extends PagerAdapter {
    private List<View> mViewList;
    private Context mContext;

    public MyPagerAdapter(Context context, List<View> mViewList) {
        this.mContext = context;
        this.mViewList = mViewList;
    }

    // 返回 View 的个数
    @Override
    public int getCount() {
        return mViewList.size();
    }

    // 移除 view
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(mViewList.get(position));
    }

    // 添加 view 并返回
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    // 判断是否同一个 view
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
