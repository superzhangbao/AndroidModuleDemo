package com.hengsheng.module.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.hengsheng.module.R;
import com.hengsheng.module.core.base.BaseActivity;
import com.hengsheng.module.core.base.BaseFragment;
import com.hengsheng.module.core.base.ViewManager;
import com.hengsheng.module.core.widget.NoScrollViewPager;

import java.util.List;

/**
 * <p> </p>
 *
 * @author 张华洋 2017/9/27 10:23
 * @version V1.1
 * @name BottomNavigationActivity
 */
public class BottomNavigationActivity extends BaseActivity {

    private static final String TAG = "BottomNavActivity";
    private NoScrollViewPager mPager;
    private List<BaseFragment> mFragments;
    private FragmentAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                mPager.setCurrentItem(0);
                return true;
            } else if (i == R.id.navigation_dashboard) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i == R.id.navigation_notifications) {
                mPager.setCurrentItem(0);
                return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initViewPager();
    }

    private void initViewPager() {
        mFragments = ViewManager.getInstance().getAllFragment();
        Log.e(TAG,"mFragments.size():------>"+mFragments.size());
        mPager = findViewById(R.id.container_pager);
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mPager.setPagerEnabled(false);
        mPager.setAdapter(mAdapter);
    }


}
