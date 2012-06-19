package com.github.goncharov.entities;

import com.github.goncharov.Entity;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 15:56
 */
public class PhotoStream implements Entity, Iterable<Photo> {
    public String feature;
    public int current_page;
    public int total_pages;
    public int total_items;
    public Photo[] photos;

    @Override
    public Iterator<Photo> iterator() {
        return new Iterator<Photo>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return current < photos.length;
            }

            @Override
            public Photo next() {
                return photos[current++];
            }

            @Override
            public void remove() {
            }
        };
    }

    @Override
    public String toString() {
        return super.toString() +
                "; PhotoStream{" +
                "feature=" + feature +
                ", photos=" + (photos == null ? null : Arrays.asList(photos)) +
                '}';
    }
}
