package com.selenitas.bookittothemoon.favourites;

public class Image {
    private String url;
    private String origin;
    private String description;

    public Image(String origin, String description, String url) {
        this.origin = origin;
        this.description = description;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDescription() {
        return description;
    }
}
