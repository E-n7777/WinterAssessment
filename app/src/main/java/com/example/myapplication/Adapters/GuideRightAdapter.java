package com.example.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean.GuideItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.WebViewUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：Guide页面右侧RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class GuideRightAdapter extends RecyclerView.Adapter<GuideRightAdapter.InnerHolder> {
    List<GuideItem.DataBean.ArticlesBean> articlesBeans  =new ArrayList<>();

    @NonNull
    @Override
    public GuideRightAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemGuide = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide_right, parent, false);

        return new InnerHolder(itemGuide);
    }

    public void setRightData(List<GuideItem.DataBean.ArticlesBean> articles) {
        articlesBeans.clear();
        articlesBeans.addAll(articles);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull GuideRightAdapter.InnerHolder holder, int position) {
        View itemView = holder.itemView;
        GuideItem.DataBean.ArticlesBean articlesBean = articlesBeans.get(position);

        TextView tvRight = itemView.findViewById(R.id.tv_guide_right);
        tvRight.setText(articlesBean.getTitle());

        CardView cardView = itemView.findViewById(R.id.item_guide_right);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewUtil.class);
                intent.putExtra("url", articlesBean.getLink().replace("http://","https://"));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesBeans.size();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
