package com.example.viewpagetest.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpagetest.R;

import java.util.List;

public class ViewPager2RecyclerAdapter extends RecyclerView.Adapter<ViewPager2RecyclerAdapter.MyViewHolder> {
    List<String> mList;

    public ViewPager2RecyclerAdapter(List<String> list) {
        mList = list;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMyText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMyText = itemView.findViewById(R.id.tvMyText);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //这里一定要设置成 parent false ，如果直接设为 null 会报错。
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_new_fragment, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvMyText.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
