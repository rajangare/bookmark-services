package com.assignment.constants;

public enum BookmarkEnum {
    BOOKMARK("BOOKMARK"),
    CARD("CARK");

    private final String value;

    BookmarkEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
