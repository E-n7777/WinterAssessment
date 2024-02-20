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

import com.example.myapplication.Bean.HomeArticleItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.WebViewUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：主页文章RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class HomeArticleAdapter extends RecyclerView.Adapter<HomeArticleAdapter.InnerHolder> {
    private final List<HomeArticleItem.DataBean.DatasBean> mDatas = new ArrayList<>();

    @NonNull
    @Override
    public HomeArticleAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemArticle = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_list, parent, false);

        return new InnerHolder(itemArticle);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeArticleAdapter.InnerHolder holder, int position) {
        //设置数据
        View itemView = holder.itemView;
        HomeArticleItem.DataBean.DatasBean datasBean = mDatas.get(position);

        TextView tvTitle = itemView.findViewById(R.id.tv_title);
        tvTitle.setText(datasBean.getTitle());

        TextView tvAuthor = itemView.findViewById(R.id.tv_author);
        if (!datasBean.getAuthor().isEmpty())
            tvAuthor.setText("作者:\n" + datasBean.getAuthor());
        else
            tvAuthor.setText("作者:\n" + datasBean.getShareUser());

        TextView tvNiceShareDate = itemView.findViewById(R.id.tv_niceShareDate);
        tvNiceShareDate.setText("时间：\n" + datasBean.getNiceDate());

        CardView cardView = itemView.findViewById(R.id.item_article_list);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewUtil.class);
                intent.putExtra("url", datasBean.getLink().replace("http://", "https://"));
                v.getContext().startActivity(intent);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(HomeArticleItem homeArticleItem) {
        mDatas.addAll(homeArticleItem.getData().getDatas());
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
