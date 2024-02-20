package com.example.myapplication.Children;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.SearchAdapter;
import com.example.myapplication.Adapters.SearchAlwaysAdapter;
import com.example.myapplication.Adapters.SearchHistoryAdapter;
import com.example.myapplication.Adapters.SearchHotAdapter;
import com.example.myapplication.Bean.AlwaysItem;
import com.example.myapplication.Bean.HotItem;
import com.example.myapplication.Bean.SearchItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.Get;
import com.example.myapplication.Util.Post;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * description ：搜索ChildrenActivity
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SearchActivity extends AppCompatActivity {
    private SearchAlwaysAdapter alwaysAdapter;
    private SearchHotAdapter hotAdapter;
    private SearchHistoryAdapter historyAdapter;
    private SearchAdapter searchAdapter;
    private RecyclerView mRvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();
        networkRequest();
        initSearchView();
    }

    private void initSearchView() {
        //使用SharedPreferences来保存搜索历史记录
        SharedPreferences sharedPreferences = getSharedPreferences("search_history", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        SearchView mSearchView = findViewById(R.id.searchView);
        //SearchView获得焦点时弹出键盘
        mSearchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT);
                }
            }
        });

        //展示上次点的历史记录
        Set<String> AlreadyUpdated = sharedPreferences.getStringSet("history", new HashSet<>());
        List<String> historyList = new ArrayList<>(AlreadyUpdated);
        historyAdapter.setHistoryData(historyList, mSearchView);

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //提交搜索时触发的操作
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!query.isEmpty()) {
                    //提交关键字进行POST请求
                    Search(query);
                    mRvSearch.setVisibility(View.VISIBLE);

                    //将搜索关键词保存到SharedPreferences中
                    Set<String> searchHistory = sharedPreferences.getStringSet("history", new HashSet<>());
                    searchHistory.add(query);
                    editor.putStringSet("history", searchHistory);
                    editor.apply();
                    //每次执行搜索操作后,更新RecyclerView的数据源并刷新
                    Set<String> updatedHistory = sharedPreferences.getStringSet("history", new HashSet<>());
                    List<String> historyList = new ArrayList<>(updatedHistory);
                    historyAdapter.setHistoryData(historyList, mSearchView);
                }
                return true;
            }

            //搜索文本发生变化时触发的操作
            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.isEmpty()) {
                    mRvSearch.setVisibility(View.GONE);
                    findViewById(R.id.layout_search_history).setVisibility(View.VISIBLE);
                    findViewById(R.id.layout_search_always).setVisibility(View.VISIBLE);
                    findViewById(R.id.layout_search_hot).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.layout_search_history).setVisibility(View.GONE);
                    findViewById(R.id.layout_search_always).setVisibility(View.GONE);
                    findViewById(R.id.layout_search_hot).setVisibility(View.GONE);
                }
                return true;
            }
        });

        TextView tvClear = findViewById(R.id.tv_search_clear);
        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 清除SharedPreferences中保存的搜索历史记录
                editor.remove("history");
                editor.apply();
                // 更新RecyclerView以反映清除历史记录的变化
                List<String> emptyList = new ArrayList<>();
                historyAdapter.setHistoryData(emptyList, mSearchView);
            }
        });

    }

    private void Search(String query) {
        HashMap<String, String> ks = new HashMap<>();
        ks.put("k", query);
        Gson gson = new Gson();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    String mUrlSearch = "https://www.wanandroid.com/article/query/" + i + "/json?";
                    String searchJson = Post.getPostData(mUrlSearch, ks);
                    SearchItem searchItem = gson.fromJson(searchJson, SearchItem.class);
                    searchGoToUI(searchItem);
                }
            }
        }).start();
    }

    private void searchGoToUI(SearchItem searchItem) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                searchAdapter.setSearchData(searchItem);
            }
        });
    }

    private void networkRequest() {
        String mUrlAlways = "https://www.wanandroid.com/friend/json";
        String mUrlHot = "https://www.wanandroid.com//hotkey/json";
        Gson gson = new Gson();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String alwaysJson = Get.getData(mUrlAlways);
                AlwaysItem alwaysItem = gson.fromJson(alwaysJson, AlwaysItem.class);
                alwaysGoToUI(alwaysItem);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String hotJson = Get.getData(mUrlHot);
                HotItem hotItem = gson.fromJson(hotJson, HotItem.class);
                hotGoToUI(hotItem);
            }
        }).start();
    }

    private void alwaysGoToUI(AlwaysItem alwaysItem) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                alwaysAdapter.setAlwaysData(alwaysItem);
            }
        });
    }

    private void hotGoToUI(HotItem hotItem) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hotAdapter.setHotData(hotItem);
            }
        });
    }

    private void initView() {
        mRvSearch = findViewById(R.id.rv_search);
        mRvSearch.setLayoutManager(new LinearLayoutManager(this));
        searchAdapter = new SearchAdapter();
        mRvSearch.setAdapter(searchAdapter);

        RecyclerView mRvHistory = findViewById(R.id.rv_search_history);
        mRvHistory.setLayoutManager(new GridLayoutManager(this, 3));
        historyAdapter = new SearchHistoryAdapter();
        mRvHistory.setAdapter(historyAdapter);

        RecyclerView mRvHot = findViewById(R.id.rv_search_hot);
        mRvHot.setLayoutManager(new GridLayoutManager(this, 3));
        hotAdapter = new SearchHotAdapter();
        mRvHot.setAdapter(hotAdapter);

        RecyclerView mRvAlways = findViewById(R.id.rv_search_always);
        mRvAlways.setLayoutManager(new GridLayoutManager(this, 2));
        alwaysAdapter = new SearchAlwaysAdapter();
        mRvAlways.setAdapter(alwaysAdapter);
    }
}