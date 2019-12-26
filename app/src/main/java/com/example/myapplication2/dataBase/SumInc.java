package com.example.myapplication2.dataBase;

import android.content.ContentValues;

import java.util.Date;

public class SumInc {
    private int sumId;
    private String title;
    private String description;
    private long summ;
    private String urlImage;
    private String urlLocation;
    private Date dateTime;

    private ContentValues contentValues;

    public SumInc(){
        contentValues = new ContentValues();
    }

    public SumInc(int sumId, String title, String description, long summ, String urlImage, String urlLocation, Date dateTime) {
        this.sumId = sumId;
        this.title = title;
        this.description = description;
        this.summ = summ;
        this.urlImage = urlImage;
        this.urlLocation = urlLocation;
        this.dateTime = dateTime;
        contentValues = new ContentValues();
    }

    public SumInc(int sumId, String title, long summ) {
        this.sumId = sumId;
        this.title = title;
        this.summ = summ;
        contentValues = new ContentValues();
    }

    public SumInc(int sumId, long summ) {
        this.sumId = sumId;
        this.summ = summ;
        contentValues = new ContentValues();
    }

    public ContentValues getContentValues(){
        return contentValues;
    }

    public int getSumId() {
        return sumId;
    }

    public void setSumId(int sumId) {
        this.sumId = sumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        contentValues.put("title",title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        contentValues.put("description",description);
    }

    public long getSumm() {
        return summ;
    }

    public void setSumm(long summ) {
        this.summ = summ;
        contentValues.put("summ",summ);
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
        contentValues.put("url_image",urlImage);
    }

    public String getUrlLocation() {
        return urlLocation;
    }

    public void setUrlLocation(String urlLocation) {
        this.urlLocation = urlLocation;
        contentValues.put("url_geolocate",urlLocation);
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        contentValues.put("date_sum",dateTime.getTime());
        contentValues.put("time_sum",dateTime.getTime());
    }

    public void setDateTimeLong(Long dateTimeLong){
        Date date = new Date(dateTimeLong);
        setDateTime(date);
    }
}
