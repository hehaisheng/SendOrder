package com.example.pc_.sendorder.view.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.pc_.sendorder.R;
import com.example.pc_.sendorder.view.view.fragment.OrderFragment;
import com.example.pc_.sendorder.view.view.fragment.SelfFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/15.
 */
public class MainActivity extends BaseActivity {


    public static final int REQUEST_PHONE_CODE = 20;
    @BindView(R.id.art_tab)
    TabLayout artTab;
    @BindView(R.id.main_content)
    ViewPager mainContent;



    public String[] titles={"订单","我"};
    public List<Fragment> fragmentList=new ArrayList<>();


    public OrderFragment orderFragment;
    public SelfFragment selfFragment;
    public SharedPreferences sharedPreferences;

    public boolean isLogin;

    @Override
    public int getLayout() {
        return R.layout.main_activity;
    }

    @Override
    public void initView() {

        sharedPreferences=getSharedPreferences("Login",0);
        isLogin=sharedPreferences.getBoolean("HasLogin",false);
        if(!isLogin){
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        fragmentList.clear();
        orderFragment=new OrderFragment();
        selfFragment=new SelfFragment();

        fragmentList.add(orderFragment);
        fragmentList.add(selfFragment);
        artTab.setTabMode(TabLayout.MODE_FIXED);
        artTab.setupWithViewPager(mainContent);
        artTab.addTab(artTab.newTab());
        artTab.addTab(artTab.newTab());
        artTab.addTab(artTab.newTab());

        mainContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return  fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CODE);
            }
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PHONE_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this, "可拨打订单用户电话", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "请许可拨打订单用户电话", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
