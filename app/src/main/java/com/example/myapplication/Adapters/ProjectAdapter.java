package com.example.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Bean.ProjectItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.WebViewUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：项目页面RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.InnerHolder> {
    private List<ProjectItem.DataBean.DatasBean> mDatas = new ArrayList<>();

    @NonNull
    @Override
    public ProjectAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemProject = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);

        return new InnerHolder(itemProject);
    }

    public void setProjectData(ProjectItem projectItem) {
        mDatas.addAll(projectItem.getData().getDatas());
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.InnerHolder holder, int position) {
        //设置数据
        View itemView = holder.itemView;
        ProjectItem.DataBean.DatasBean datasBean = mDatas.get(position);

        ImageView imageView = itemView.findViewById(R.id.imv_project);
        Glide.with(itemView.getContext()).load(datasBean.getEnvelopePic()).into(imageView);

        TextView tvTitle = itemView.findViewById(R.id.tv_project_title);
        tvTitle.setText(datasBean.getTitle());

        TextView tvDesc = itemView.findViewById(R.id.tv_project_desc);
        tvDesc.setText("简介：" + datasBean.getDesc());

        TextView tvTimeAuthor = itemView.findViewById(R.id.tv_project_time_author);
        tvTimeAuthor.setText(String.format("时间：%s\n作者：%s", datasBean.getNiceDate(), datasBean.getAuthor()));

        ConstraintLayout item = itemView.findViewById(R.id.item_project);
        item.setOnClickListener(new View.OnClickListener() {
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
        return mDatas.size();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
