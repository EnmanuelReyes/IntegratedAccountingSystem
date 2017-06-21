package me.enmanuel.accounting.entity;

/**
 * Created by IntelliJ IDEA.
 * User: Enmanuel Reyes
 * Date: 21-Jun-17
 * Time: 3:29 PM
 */
public enum Origin {
    DEBIT("DB"),
    CREDIT("CR");

    String origin;

    Origin(String origin) {
        this.origin = origin;
    }
}
