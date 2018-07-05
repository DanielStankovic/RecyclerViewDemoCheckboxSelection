package com.example.daniel.recyclerviewdemofastcoding.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.daniel.recyclerviewdemofastcoding.R;

public class DetailsActivity extends AppCompatActivity {
    private TextView title, description, rating;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras = getIntent().getExtras();
        title = findViewById(R.id.titleDetails);
        description = findViewById(R.id.descDetails);
        rating = findViewById(R.id.ratingDetails);

        title.setText(extras.getString("title"));
        description.setText(extras.getString("description"));
        rating.setText(extras.getString("rating"));
    }
}
