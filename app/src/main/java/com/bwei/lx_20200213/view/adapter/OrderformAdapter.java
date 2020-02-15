package com.bwei.lx_20200213.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.lx_20200213.model.entity.OrderfromEntity;

import java.util.List;

public class OrderformAdapter extends RecyclerView.Adapter<OrderformAdapter.OrderformHolder> {


    public OrderformAdapter(List<OrderfromEntity.OrderListBean> list) {

    }

    @NonNull
    @Override
    public OrderformHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderformHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class  OrderformHolder extends RecyclerView.ViewHolder{
        public OrderformHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
