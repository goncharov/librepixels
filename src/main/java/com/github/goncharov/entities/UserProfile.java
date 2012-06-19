/*
 * Copyright (c) 2012. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.github.goncharov.entities;

import com.github.goncharov.Entity;
import com.github.goncharov.enums.Locale;
import com.github.goncharov.enums.Sex;
import com.github.goncharov.enums.UpgradeStatus;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Goncharov
 * Date: 01.06.12
 * Time: 21:16
 */
public class UserProfile implements Entity {
    private Integer id;
    private String username;
    private String fullname;
    private String firstname;
    private String lastname;
    private UpgradeStatus upgrade_status;
    private String userpic_url;

    private String email;
    private Sex sex;
    private String city;
    private String state;
    private String country;
    private Date birthday;
    private Date registration_date;
    private String about;
    private String domain;
    private Boolean fotomoto_on;
    private Boolean store_on;
    private Locale locale;
    private Boolean show_nude;

    private Integer friends_count;
    private Integer followers_count;
    private Integer photos_count;

    private Integer in_favorites_count;
    private Integer affection;

    private Integer upload_limit;
    private Date upload_limit_expiry;
    private Date upgrade_status_expiry;

    private UserEquipment equipment;
    private UserContacts contacts;

    public UserProfile() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public UpgradeStatus getUpgradeStatus() {
        return upgrade_status;
    }

    public String getUserpicUrl() {
        return userpic_url;
    }

    public String getEmail() {
        return email;
    }

    public Sex getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getRegistrationDate() {
        return registration_date;
    }

    public String getAbout() {
        return about;
    }

    public String getDomain() {
        return domain;
    }

    public Boolean getFotomotoOn() {
        return fotomoto_on;
    }

    public Boolean getStoreOn() {
        return store_on;
    }

    public Locale getLocale() {
        return locale;
    }

    public Boolean getShowNude() {
        return show_nude;
    }

    public Integer getFriendsCount() {
        return friends_count;
    }

    public Integer getFollowersCount() {
        return followers_count;
    }

    public Integer getPhotosCount() {
        return photos_count;
    }

    public Integer getInFavoritesCount() {
        return in_favorites_count;
    }

    public Integer getAffection() {
        return affection;
    }

    public Integer getUploadLimit() {
        return upload_limit;
    }

    public Date getUploadLimitExpiry() {
        return upload_limit_expiry;
    }

    public Date getUpgradeStatusExpiry() {
        return upgrade_status_expiry;
    }

    public UserEquipment getEquipment() {
        return equipment;
    }

    public UserContacts getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", userpic_url='" + userpic_url + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", registration_date=" + registration_date +
                ", about='" + about + '\'' +
                ", upgrade_status=" + upgrade_status +
                ", domain='" + domain + '\'' +
                ", fotomoto_on=" + fotomoto_on +
                ", store_on=" + store_on +
                ", locale=" + locale +
                ", show_nude=" + show_nude +
                ", friends_count=" + friends_count +
                ", followers_count=" + followers_count +
                ", photos_count=" + photos_count +
                ", in_favorites_count=" + in_favorites_count +
                ", affection=" + affection +
                ", upload_limit=" + upload_limit +
                ", upload_limit_expiry=" + upload_limit_expiry +
                ", upgrade_status_expiry=" + upgrade_status_expiry +
                ", equipment=" + equipment +
                ", contacts=" + contacts +
                '}';
    }

    public static class UserContacts implements Entity {
        private String twitter;
        private String googleplus;
        private String facebook;
        private String website;
        private String flickr;
        private String livejournal;
        private String gtalk;
        private String skype;
        private String facebookpage;
        private String blog;
        private String tumblr;

        public String getTwitter() {
            return twitter;
        }

        public String getGooglePlus() {
            return googleplus;
        }

        public String getFacebook() {
            return facebook;
        }

        public String getWebsite() {
            return website;
        }

        public String getFlickr() {
            return flickr;
        }

        public String getLiveJournal() {
            return livejournal;
        }

        public String getGtalk() {
            return gtalk;
        }

        public String getSkype() {
            return skype;
        }

        public String getFacebookPage() {
            return facebookpage;
        }

        public String getBlog() {
            return blog;
        }

        public String getTumblr() {
            return tumblr;
        }

        public UserContacts() {
        }


        @Override
        public String toString() {
            return "UserContacts{" +
                    "twitter='" + twitter + '\'' +
                    ", googleplus='" + googleplus + '\'' +
                    ", facebook='" + facebook + '\'' +
                    ", website='" + website + '\'' +
                    ", flickr='" + flickr + '\'' +
                    ", livejournal='" + livejournal + '\'' +
                    ", gtalk='" + gtalk + '\'' +
                    ", skype='" + skype + '\'' +
                    ", facebookpage='" + facebookpage + '\'' +
                    ", blog='" + blog + '\'' +
                    ", tumblr='" + tumblr + '\'' +
                    '}';
        }
    }

    public static class UserEquipment implements Entity {
        private String[] camera;
        private String[] lens;
        private String[] misc;

        public UserEquipment() {
        }

        public String[] getCamera() {
            return camera;
        }

        public String[] getLens() {
            return lens;
        }

        public String[] getMisc() {
            return misc;
        }

        @Override
        public String toString() {
            return "UserEquipment{" +
                    "camera=" + (camera == null ? null : Arrays.asList(camera)) +
                    ", lens=" + (lens == null ? null : Arrays.asList(lens)) +
                    ", misc=" + (misc == null ? null : Arrays.asList(misc)) +
                    '}';
        }
    }

}
