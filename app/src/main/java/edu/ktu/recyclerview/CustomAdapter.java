package edu.ktu.recyclerview;

import android.app.Person;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<PersonData> data;

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameView;
        public TextView lastNameView;
        public TextView ageView;

        public CustomViewHolder(View view)
        {
            super(view);
            this.firstNameView = view.findViewById(R.id.first_name);
            this.lastNameView = view.findViewById(R.id.last_name);
            this.ageView = view.findViewById(R.id.age);
        }
    }

    public CustomAdapter(List<PersonData> data)
    {
        this.data = data;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(itemView);
        return viewHolder;
    }

    public void onBindViewHolder(CustomViewHolder viewHolder, int position)
    {
        PersonData person = data.get(position);
        viewHolder.firstNameView.setText(person.getFirstName());
        viewHolder.lastNameView.setText(person.getLastName());
        viewHolder.ageView.setText(Integer.toString(person.getAge()));
    }

    public int getItemCount()
    {
        return data.size();
    }
}
