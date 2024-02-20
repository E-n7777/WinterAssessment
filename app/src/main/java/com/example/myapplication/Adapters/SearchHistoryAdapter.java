package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：搜索历史RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.InnerHolder> {
    private List<String> mHistory = new ArrayList<>();
    private SearchView searchView;
    @NonNull
    @Override
    public SearchHistoryAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemHistory = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide_left, parent, false);

        return new InnerHolder(itemHistory);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SearchHistoryAdapter.InnerHolder holder, int position) {
        View item = holder.itemView;

        TextView tvHistory = item.findViewById(R.id.tv_guide_left);
        tvHistory.setTextColor(R.color.black_light);
        tvHistory.setText(mHistory.get(position));

        // 设置历史记录item的点击事件
        tvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击历史记录item时，将历史记录的内容填充到SearchView中并触发搜索
                String history = tvHistory.getText().toString();
                searchView.setQuery(history,true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHistory.size();
    }

    public void setHistoryData(List<String> history, SearchView mSearchView) {
        mHistory.clear();
        mHistory.addAll(history);
        this.searchView = mSearchView;
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
