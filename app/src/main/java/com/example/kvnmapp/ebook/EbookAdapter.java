package com.example.kvnmapp.ebook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kvnmapp.R;

import java.util.List;
public class EbookAdapter extends RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {
    private final Context context;
    private List<EbookData> list;
    public EbookAdapter(Context context, List<EbookData> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public EbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout,parent,false);
        return new EbookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EbookViewHolder holder, int position) {
        EbookData item = list.get(position);
        if (item != null) {
            switch (item.getDepartment()) {
                case "BCP":
                    if (item.getBcpPdfTitle() != null) {
                        holder.ebookName.setText(item.getBcpPdfTitle());
                    }
                    break;
                case "DRB":
                    if (item.getDrbPdfTitle() != null) {
                        holder.ebookName.setText(item.getDrbPdfTitle());
                    }
                    break;
                case "JNMP":
                    if (item.getJnmpPdfTitle() != null) {
                        holder.ebookName.setText(item.getJnmpPdfTitle());
                    }
                    break;
                case "NCC":
                    if (item.getNccPdfTitle() != null) {
                        holder.ebookName.setText(item.getNccPdfTitle());
                    }
                    break;
                case "CBP":
                    if (item.getCbpPdfTitle() != null) {
                        holder.ebookName.setText(item.getCbpPdfTitle());
                    }
                    break;
                // Add more cases for other departments as needed
                default:
                    break;
            }

            holder.itemView.setOnClickListener(v -> {
                // Handle item click if needed
            });

            holder.ebookDownload.setOnClickListener(v -> {
                if (item.getPdfUrl() != null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(item.getPdfUrl()));
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    @SuppressLint("NotifyDataSetChanged")
    public void FilteredList(List<EbookData> filterList) {
        list = filterList;
        notifyDataSetChanged();
    }
    public static class EbookViewHolder extends RecyclerView.ViewHolder {
        private final TextView ebookName;
        private final ImageView ebookDownload;
        public EbookViewHolder(@NonNull View itemView) {
            super(itemView);
            ebookDownload = itemView.findViewById(R.id.ebookDownload);
            ebookName = itemView.findViewById(R.id.ebookName);
        }
    }
}
