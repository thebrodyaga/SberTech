package com.sbertech.component;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sbertech.R;
import com.sbertech.model.Xml.Item;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Emelyanov.N4 on 30.01.2018.
 */

public class AllHubsAdapter extends RecyclerView.Adapter<AllHubsAdapter.ViewHolder> {
    private List<Item> items;

    public AllHubsAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public AllHubsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AllHubsAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.name.setText(items.get(position).getCreator());
        holder.date.setText(new SimpleDateFormat("d MMM yyyy в HH:mm", Locale.getDefault())
                .format(items.get(position).getPubDate()));
        holder.description.setText(stripHtml(items.get(position).getDescription()));
        holder.category.setText(massToStr(items.get(position).getCategory()));
    }

    private String stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            return Html.fromHtml(html).toString();
        }
    }

    private String massToStr(String[] category) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < category.length; i++) {
            builder.append(category[i]);
            if (i != category.length - 1)
                builder.append(", ");
        }
        return builder.toString();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView name;
        TextView date;
        TextView description;
        TextView category;
        Button button;

        ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            name = v.findViewById(R.id.name);
            date = v.findViewById(R.id.date);
            description = v.findViewById(R.id.description);
            category = v.findViewById(R.id.category);
            button = v.findViewById(R.id.button);
        }
    }
}
