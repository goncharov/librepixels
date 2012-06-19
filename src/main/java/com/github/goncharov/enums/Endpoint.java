package com.github.goncharov.enums;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 14:05
 */
public enum Endpoint {
    PHOTOS(HttpMethod.GET, "/photos", "feature", "user_id", "username",
            "only", "exclude", "sort", "page", "rpp"),
    PHOTOS_SHOW(HttpMethod.GET, "/photos/%d", "image_size", "comments", "comments_page"),
    PHOTOS_SEARCH(HttpMethod.GET, "/photos/search", "term", "tag", "page", "rpp"),
    USERS(HttpMethod.GET, "/users"),
    USERS_SHOW(HttpMethod.GET, "/users/show", "id", "username", "email"),
    USERS_FRIENDS(HttpMethod.GET, "/users/%d/friends", "page"),
    BLOGS(HttpMethod.GET, "/blogs", "feature", "page", "rpp");

    private final HttpMethod method;
    private final String path;
    private final String[] allowedParams;

    private Endpoint(HttpMethod method, String path, String... allowedParams) {
        this.method = method;
        this.path = path;
        this.allowedParams = allowedParams;
    }

    public boolean isParamAllowed(String param) {
        if (allowedParams != null) {
            for (String allowedParam : allowedParams) {
                if (param.equalsIgnoreCase(allowedParam))
                    return true;
            }
        }
        return false;
    }

    public String getPath() {
        return path;
    }

    public HttpMethod getMethod() {
        return method;
    }
}
