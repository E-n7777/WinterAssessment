package com.example.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.Bean.GuideItem;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：Guide页面左侧RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class GuideLeftAdapter extends RecyclerView.Adapter<GuideLeftAdapter.InnerHolder> {
    private List<GuideItem.DataBean> mData = new ArrayList<>();
    private RecyclerView mRvRight;
    private GuideRightAdapter rightAdapter;

    public GuideLeftAdapter(RecyclerView rvRight, GuideRightAdapter rightAdapter) {
        this.mRvRight = rvRight;
        this.rightAdapter = rightAdapter;
    }

    @NonNull
    @Override
    public GuideLeftAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemGuide = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guide_left, parent, false);

        return new InnerHolder(itemGuide);
    }

    @Override
    public void onBindViewHolder(@NonNull GuideLeftAdapter.InnerHolder holder, int position) {
        View itemView = holder.itemView;
        GuideItem.DataBean dataBean = mData.get(position);

        TextView tvLeft = itemView.findViewById(R.id.tv_guide_left);
        tvLeft.setText(dataBean.getName());

        CardView cardView = itemView.findViewById(R.id.item_guide_left);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //布局管理器
                StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
                mRvRight.setLayoutManager(layoutManager);
                //适配器
                rightAdapter.setRightData(dataBean.getArticles());
                mRvRight.setAdapter(rightAdapter);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setLeftData(GuideItem guideItem) {
        mData.clear();
        mData.addAll(guideItem.getData());
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
