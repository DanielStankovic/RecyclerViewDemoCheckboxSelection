package com.example.daniel.recyclerviewdemofastcoding.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.recyclerviewdemofastcoding.Activities.DetailsActivity;
import com.example.daniel.recyclerviewdemofastcoding.Model.ListItem;
import com.example.daniel.recyclerviewdemofastcoding.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public Context context;
    public ArrayList<ListItem> listItems;
    public ArrayList<ListItem> tempListItems = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<ListItem> listItems) {
        this.context = context;
        this.listItems = listItems;

        for(ListItem item : listItems){
            if(item.isChecked()){
                tempListItems.add(item);
            }
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
       final ListItem item = listItems.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.rating.setText(item.getRating());
        holder.checkBox.setChecked(item.isChecked());
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){

                        Toast.makeText(context, "Item: "+ item.getTitle() + "je setovan na "+ String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();
                        item.setChecked(true);
                        tempListItems.add(item);
                    }else{
                        Toast.makeText(context, "Item: "+ item.getTitle() + "je setovan na "+ String.valueOf(((CheckBox) v).isChecked()), Toast.LENGTH_SHORT).show();

                        item.setChecked(false);
                        tempListItems.remove(item);
                    }

            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title, description, rating;
        public LinearLayout container;
        public CheckBox checkBox;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);


            container = itemView.findViewById(R.id.container);
            title = itemView.findViewById(R.id.titleTextView);
            description = itemView.findViewById(R.id.descTextView);
            rating = itemView.findViewById(R.id.ratingTextView);
            checkBox = itemView.findViewById(R.id.checkBox);


        }

        @Override
        public void onClick(View v) {

            ArrayList lol = getList();


            int position = getAdapterPosition();
            ListItem item = listItems.get(position);

            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("title", item.getTitle());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("rating", item.getRating());

            context.startActivity(intent);

        }
    }


    public void findList(ArrayList<ListItem> arrayList){

        listItems = arrayList;
        notifyDataSetChanged();
    }


    public ArrayList<ListItem> getList(){
        return  tempListItems;
    }
}
