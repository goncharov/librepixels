package com.github.goncharov;

import com.github.goncharov.impl.JsonOrgMapper;
import com.github.goncharov.impl.SignpostHttpClient;
import com.github.goncharov.impl.Px500Impl;
import oauth.signpost.OAuthConsumer;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 02.06.12
 * Time: 15:16
 */
public class Px500Factory {
    public static Px500 createApi(OAuthConsumer consumer) {
        return new Px500Impl(new SignpostHttpClient(consumer), new JsonOrgMapper());
    }

    public static Px500 createApi(HttpClient client, JsonMapper mapper) {
        return new Px500Impl(client, mapper);
    }


}
