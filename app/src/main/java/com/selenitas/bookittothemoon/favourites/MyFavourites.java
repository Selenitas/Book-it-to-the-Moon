package com.selenitas.bookittothemoon.favourites;


import java.util.ArrayList;
import java.util.List;

public class MyFavourites {
    public static List<Image> list = new ArrayList<Image>();

    public MyFavourites() {
    }

    public void addFavourite(Image image) {
        list.add(image);
    }

}
