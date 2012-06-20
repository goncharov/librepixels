package com.github.goncharov.enums;

import com.github.goncharov.EntityEnumeration;
import com.github.goncharov.QueryEnumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 06.06.12
 * Time: 14:02
 */
public enum Category implements QueryEnumeration, EntityEnumeration<Integer> {
    UNCATEGORIZED(0, "Uncategorized"),
    CELEBRITIES(1, "Celebrities"),
    FILM(2, "Film"),
    JOURNALISM(3, "Journalism"),
    NUDE(4, "Nude"),
    BLACK_AND_WHITE(5, "Black and White"),
    STILL_LIFE(6, "Still Life"),
    PEOPLE(7, "People"),
    LANDSCAPES(8, "Landscapes"),
    CITY_AND_ARCHITECTURE(9, "City and Architecture"),
    ABSTRACT(10, "Abstract"),
    ANIMALS(11, "Animals"),
    MACRO(12, "Macro"),
    TRAVEL(13, "Travel"),
    FASHION(14, "Fashion"),
    COMMERCIAL(15, "Commercial"),
    CONCERT(16, "Concert"),
    SPORT(17, "Sport"),
    NATURE(18, "Nature"),
    PERFORMING_ARTS(19, "Performing Arts"),
    FAMILY(20, "Family"),
    STREET(21, "Street"),
    UNDERWATER(22, "Underwater"),
    FOOD(23, "Food"),
    FINE_ART(24, "Fine Art"),
    WEDDING(25, "Wedding"),
    TRANSPORTATION(26, "Transporation"),
    URBAN_EXPLORATION(27, "Urban Exploration");

    private final int id;
    private final String category;

    Category(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public static Category fromValue(int id) {
        for (Category category : Category.values()) {
            if (category.toInteger() == id)
                return category;
        }
        return null;
    }

    public static Category fromValue(String title) {
        for (Category category : Category.values()) {
            if (category.toString().equals(title))
                return category;
        }
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return category;
    }

    public int toInteger() {
        return id;
    }

    @Override
    public <T> T getRaw() {
        return (T) Integer.class.cast(id);
    }
}
