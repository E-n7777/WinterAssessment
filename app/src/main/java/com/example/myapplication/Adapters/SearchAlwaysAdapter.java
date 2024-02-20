package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean.AlwaysItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.WebViewUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：搜索页面常用网站RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SearchAlwaysAdapter extends RecyclerView.Adapter<SearchAlwaysAdapter.InnerHolder> {
    private List<AlwaysItem.DataBean> mDataBeans = new ArrayList<>();

    public void setAlwaysData(AlwaysItem alwaysItem) {
        mDataBeans.clear();
        mDataBeans.addAll(alwaysItem.getData());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchAlwaysAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemAlways = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide_left, parent, false);

        return new InnerHolder(itemAlways);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull SearchAlwaysAdapter.InnerHolder holder, int position) {
        View item = holder.itemView;
        AlwaysItem.DataBean dataBean = mDataBeans.get(position);

        TextView tvAlways = item.findViewById(R.id.tv_guide_left);
        tvAlways.setTextColor(R.color.black_light);
        tvAlways.setText(dataBean.getName());

        CardView cardView = item.findViewById(R.id.item_guide_left);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewUtil.class);
                intent.putExtra("url", dataBean.getLink().replace("http://", "https://"));
                v.getContext().startActivity(intent);
            }
        });
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
