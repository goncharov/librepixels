package com.github.goncharov.entities;

import com.github.goncharov.Entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 14.06.12
 * Time: 11:52
 */
@SuppressWarnings("ALL")
public class Comment implements Entity {
    public int id;
    public int user_id;
    public int to_whom_user_id;
    public Integer parent_id;
    public Date createdAt;
    public String body;
    public UserProfile user;
}
