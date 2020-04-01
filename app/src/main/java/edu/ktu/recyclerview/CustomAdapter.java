package edu.ktu.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<String> data;

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CustomViewHolder(TextView textView)
        {
            super(textView);
            this.textView = textView;
        }
    }

    public CustomAdapter(List<String> data)
    {
        this.data = data;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_layout, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(textView);
        return viewHolder;
    }

    public void onBindViewHolder(CustomViewHolder viewHolder, int position)
    {
        viewHolder.textView.setText(data.get(position));
    }

    public int getItemCount()
    {
        return data.size();
    }
}
