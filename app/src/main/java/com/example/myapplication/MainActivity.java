package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Children.CollectActivity;
import com.example.myapplication.Children.SearchActivity;
import com.example.myapplication.Fragment.GuideFragment;
import com.example.myapplication.Fragment.HomePageFragment;
import com.example.myapplication.Fragment.ProjectFragment;
import com.example.myapplication.Fragment.SystemFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
/**
 * description ：MainActivity
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class MainActivity extends AppCompatActivity {
    private BottomNavigationView btmNavView;
    private HomePageFragment mHomePage;
    private SystemFragment mSystem;
    private GuideFragment mSearch;
    private ProjectFragment mProject;
    private DrawerLayout drawerLayout;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        initView();
        initDrawer();

        //默认首页选中
        selectedFragment(0);
        //底部菜单栏的点击切换事件
        btmNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first_view) {
                    selectedFragment(0);
                    tvTitle.setText("首页");
                } else if (item.getItemId() == R.id.knowledge_system) {
                    selectedFragment(1);
                    tvTitle.setText("知识体系");
                } else if (item.getItemId() == R.id.search) {
                    selectedFragment(2);
                    tvTitle.setText("导航");
                } else if (item.getItemId() == R.id.project) {
                    selectedFragment(3);
                    tvTitle.setText("项目");
                }
                return true;
            }
        });
    }

    private void initDrawer() {
        NavigationView navigation = findViewById(R.id.layout_slip);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            //boolean isNight = true;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.slip_search) {
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (item.getItemId() == R.id.collect) {
                    Intent intent = new Intent(MainActivity.this, CollectActivity.class);
                    startActivity(intent);
                }else if (item.getItemId() == R.id.back) {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    finish();
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    private void selectedFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if (position == 0) {
            if (mHomePage == null) {
                mHomePage = new HomePageFragment();
                fragmentTransaction.add(R.id.fragmentContainer, mHomePage);
            } else fragmentTransaction.show(mHomePage);
        } else if (position == 1) {
            if (mSystem == null) {
                mSystem = new SystemFragment();
                fragmentTransaction.add(R.id.fragmentContainer, mSystem);
            } else fragmentTransaction.show(mSystem);
        } else if (position == 2) {
            if (mSearch == null) {
                mSearch = new GuideFragment();
                fragmentTransaction.add(R.id.fragmentContainer, mSearch);
            } else fragmentTransaction.show(mSearch);
            Toast.makeText(this, "请选择您要查看的分类", Toast.LENGTH_SHORT).show();
        } else {
            if (mProject == null) {
                mProject = new ProjectFragment();
                fragmentTransaction.add(R.id.fragmentContainer, mProject);
            } else fragmentTransaction.show(mProject);
        }
        //选择后提交
        fragmentTransaction.commit();
    }

    //对未选中Fragment做隐藏
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (mHomePage != null && mHomePage.isVisible())
            fragmentTransaction.hide(mHomePage);
        else if (mSystem != null && mSystem.isVisible())
            fragmentTransaction.hide(mSystem);
        else if (mSearch != null && mSearch.isVisible())
            fragmentTransaction.hide(mSearch);
        else if (mProject != null && mProject.isVisible())
            fragmentTransaction.hide(mProject);
    }

    private void initView() {
        btmNavView = findViewById(R.id.under);
        tvTitle = findViewById(R.id.tv_up);

        drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.iv_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        ImageView search = findViewById(R.id.imv_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}