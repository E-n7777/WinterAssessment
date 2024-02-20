package com.example.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean.SearchItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.WebViewUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：搜索结果RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<SearchItem.DataBean.DatasBean> mDatasBeans = new ArrayList<>();

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemSearch = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_system_children_list, parent, false);

        return new ViewHolder(itemSearch);
    }

    public void setSearchData(SearchItem searchItem) {
        mDatasBeans.addAll(searchItem.getData().getDatas());
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        View item = holder.itemView;
        SearchItem.DataBean.DatasBean datasBean = mDatasBeans.get(position);

        TextView tvSearch = item.findViewById(R.id.tv_system_title);
        tvSearch.setText(datasBean.getTitle());

        TextView tvTime = item.findViewById(R.id.tv_system_chapterName_superChapterName);
        tvTime.setText("时间：" + datasBean.getNiceDate());

        TextView tvAuthor = item.findViewById(R.id.tv_system_shareUser);
        if (!datasBean.getAuthor().isEmpty())
            tvAuthor.setText("作者or分享人：" + datasBean.getAuthor());
        else tvAuthor.setText("作者or分享人：" + datasBean.getShareUser());

        LinearLayout list = item.findViewById(R.id.item_system_children_list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewUtil.class);
                intent.putExtra("url", datasBean.getLink().replace("http://", "https://"));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatasBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
