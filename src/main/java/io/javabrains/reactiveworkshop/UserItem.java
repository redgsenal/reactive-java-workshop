package io.javabrains.reactiveworkshop;

import java.util.Comparator;

/**
 * This class is a sample custom Java type used in the exercises.
 * DO NOT MODIFY THIS CODE
 *
 * @author koushikkothagal
 */

public class UserItem implements Comparator<UserItem>, Comparable<UserItem> {

    private int id;
    private String firstName;
    private String lastName;

    public UserItem(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

    @Override
    public int compare(UserItem u1, UserItem u2) {
        return u1.getId() - u2.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserItem user) {
            return this.getId() == user.getId();
        }
        return false;
    }

    @Override
    public int compareTo(UserItem o) {
        return this.getId() - o.getId();
    }
}
