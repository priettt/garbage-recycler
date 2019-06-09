package com.unicen.garbage.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unicen.garbage.R;
import com.unicen.garbage.domain.entities.Recycling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class RecyclingAdapter extends RecyclerView.Adapter<RecyclingAdapter.ViewHolder> {
    private List<Recycling> recyclingList;

    RecyclingAdapter(List<Recycling> recyclingList) {
        this.recyclingList = recyclingList;
    }

    public void updateItems(List<Recycling> recycling) {
        recyclingList.clear();
        recyclingList.addAll(recycling);
        notifyDataSetChanged();
    }

    @Override
    @NonNull
    public RecyclingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new RecyclingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclingAdapter.ViewHolder holder, int position) {
        holder.recyclingItem = recyclingList.get(position);
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(recyclingList.get(position).getDate());
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            holder.dateTextView.setText(formattedDate);
        } catch (ParseException e) {
            holder.dateTextView.setText("No date info.");
        }
        holder.recyclingTextView.setText(recyclingList.get(position).getRecyclingString());
    }

    @Override
    public int getItemCount() {
        return recyclingList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View itemView;
        final TextView dateTextView;
        final TextView recyclingTextView;
        Recycling recyclingItem;

        ViewHolder(View view) {
            super(view);
            itemView = view;
            dateTextView = itemView.findViewById(R.id.history_item_date);
            recyclingTextView = itemView.findViewById(R.id.history_item_text);
        }
    }
}
