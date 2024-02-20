package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean.HotItem;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：搜索页面热词RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SearchHotAdapter extends RecyclerView.Adapter<SearchHotAdapter.InnerHolder> {
    private List<HotItem.DataBean> mDataBeans = new ArrayList<>();

    public void setHotData(HotItem hotItem) {
        mDataBeans.clear();
        mDataBeans.addAll(hotItem.getData());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchHotAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemHot = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide_left, parent, false);

        return new InnerHolder(itemHot);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SearchHotAdapter.InnerHolder holder, int position) {
        View item = holder.itemView;
        HotItem.DataBean dataBean = mDataBeans.get(position);

        TextView tvHot = item.findViewById(R.id.tv_guide_left);
        tvHot.setTextColor(R.color.black_light);
        tvHot.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return mDataBeans.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
