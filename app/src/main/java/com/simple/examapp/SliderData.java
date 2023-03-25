package com.simple.examapp;

public class SliderData {
    // image url is used to
    // store the url of image
    private int imgUrl;
    private String bookName;

    // Constructor method.
    public SliderData(int imgUrl,String bookName) {
        this.imgUrl = imgUrl;
        this.bookName=bookName;
    }

    // Getter method
    public int getImgUrl() {
        return imgUrl;
    }
    public String getBookName(){
        return bookName;
    }

    // Setter method
    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setBookName(String bookName){
        this.bookName=bookName;
    }
}
