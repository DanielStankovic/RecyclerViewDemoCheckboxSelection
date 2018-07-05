package com.example.daniel.recyclerviewdemofastcoding.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.daniel.recyclerviewdemofastcoding.Adapter.MyAdapter;
import com.example.daniel.recyclerviewdemofastcoding.Model.ListItem;
import com.example.daniel.recyclerviewdemofastcoding.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ListItem> listItems;
    private MyAdapter adapter;
    private EditText seatchEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        seatchEditText = findViewById(R.id.search_bar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();

        for (int i = 0; i <20 ; i++) {
            ListItem item = new ListItem();
            item.setTitle("Naslov "+ i);
            item.setDescription("This is desc");
            item.setRating("5star");
            if(i%3==0) {
                item.setChecked(true);

            }else{
                item.setChecked(false);
            }
            listItems.add(item);
        }

        adapter = new MyAdapter(getApplicationContext(), listItems);

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        seatchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });
    }

    public void filter(String text) {

        ArrayList<ListItem> newList = new ArrayList<>();

        for (ListItem model : listItems) {


            if (model.getTitle().toLowerCase().contains(text.toLowerCase())) {
                newList.add(model);
            }
        }
        adapter.findList(newList);
    }
}
