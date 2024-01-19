package com.example.kvnmapp.ui.faculty;

public class TeacherData {
    private String name, email, post, image, key;

    // Default (no-argument) constructor required by Firebase
    public TeacherData() {
        // Default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public TeacherData(String name, String email, String post, String image, String key) {
        this.name = name;
        this.email = email;
        this.post = post;
        this.image = image;
        this.key = key;
    }
}
