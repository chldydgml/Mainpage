package com.example.mainpage;

public class Policy {
    private int image;
    private String p_title;
    private String timeline;
    private String age;
    private String gender;
    private String local;

    public Policy() {
    }

    public Policy(int image, String p_title, String timeline, String age, String gender, String local) {
        this.image = image;
        this.p_title = p_title;
        this.timeline = timeline;
        this.age = age;
        this.gender = gender;
        this.local = local;
    }

    public int getImage() {
        return image;
    }
    public  void setImage(int image){
        this.image = image;
    }

    public String getP_title() {
        return p_title;
    }
    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public String getTimeline() {
        return timeline;
    }
    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.gender = local;
    }
}