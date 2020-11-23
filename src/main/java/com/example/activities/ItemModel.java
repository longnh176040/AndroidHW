package com.example.activities;

public class ItemModel {
    private String imageName, name, title, content, time;
    public boolean clicked;

    public ItemModel(String name, String title, String content, String time, boolean clicked) {
        this.imageName = String.valueOf(name.charAt(0));
        this.name = name;
        this.title = title;
        this.content = content;
        this.time = time;
        this.clicked = clicked;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String name) {
        this.imageName = String.valueOf(name.charAt(0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
