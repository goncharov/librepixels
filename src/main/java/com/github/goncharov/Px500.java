package com.github.goncharov;

import com.github.goncharov.entities.PhotoStream;
import com.github.goncharov.entities.UserProfile;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 04.06.12
 * Time: 16:19
 */
public interface Px500 {
    void setHttpClient(HttpClient client);

    void setJsonMapper(JsonMapper mapper);

    UserProfile getUserProfile();

    UserProfile getUserProfileById(int id);

    UserProfile getUserProfileByName(String username);

    UserProfile getUserProfileByEmail(String email);

    PhotoStream getPhotoStream();
}
