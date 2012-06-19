package com.github.goncharov.entities;

import com.github.goncharov.Entity;
import com.github.goncharov.enums.Category;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Goncharov
 * Date: 11.06.12
 * Time: 23:17
 */
public class Photo implements Entity {
    public int id;
    public UserProfile user;
    public String name;
    public String description;
    public Integer times_viewed;
    public Double rating;
    public Date created_at;
    public Category category;

    public Boolean privacy;
    public Integer width;
    public Integer height;
    public Boolean nsfw;

    public Integer votes_count;
    public Integer favorites_count;
    public Integer comments_count;
    public String image_url;

}
