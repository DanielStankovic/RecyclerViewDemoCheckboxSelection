package com.example.daniel.recyclerviewdemofastcoding.Model;

/**
 * Created by Daniel on 3/6/2018.
 */

public class ListItem {

    private String title, description, rating;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }



    public ListItem(String title, String description, String rating, boolean checked) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.checked = checked;
    }

    public ListItem(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
