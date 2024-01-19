package com.example.kvnmapp.jnmpdpt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kvnmapp.ui.notice.NoticeData;
import com.example.kvnmapp.R;

import java.util.ArrayList;

public class JNMPNoticeAdapter extends RecyclerView.Adapter<JNMPNoticeAdapter.NoticeViewAdapter> {

    private final Context context;
    private final ArrayList<NoticeData> list;

    public JNMPNoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public JNMPNoticeAdapter.NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);
        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JNMPNoticeAdapter.NoticeViewAdapter holder, int position) {
        NoticeData currentItem = list.get(position);

        holder.deleteNoticeTitle.setText(currentItem.getTitle());
        holder.notice.setText(currentItem.getNotice());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());

        holder.itemView.setOnClickListener(v -> {
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class NoticeViewAdapter extends RecyclerView.ViewHolder {
        private final TextView deleteNoticeTitle;
        private final TextView date;
        private final TextView time;
        private final TextView notice;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            notice = itemView.findViewById(R.id.notice);
            deleteNoticeTitle = itemView.findViewById(R.id.deleteNoticeTitle);
        }
    }
}
