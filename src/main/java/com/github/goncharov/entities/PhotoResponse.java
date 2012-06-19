package com.github.goncharov.entities;

import com.github.goncharov.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 19.06.12
 * Time: 10:38
 */
public class PhotoResponse implements Entity {
    public Photo photo;
    public Comment[] comments;
}
