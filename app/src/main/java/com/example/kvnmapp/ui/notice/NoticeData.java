package com.example.kvnmapp.ui.notice;

public class NoticeData {

    String title,date,time,key,notice;
    public NoticeData(){
    }
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }



    public NoticeData(String title, String date, String time, String key,String notice) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.key = key;
        this.notice = notice;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
