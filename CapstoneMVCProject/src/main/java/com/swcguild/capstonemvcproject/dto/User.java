package com.swcguild.capstonemvcproject.dto;

import java.util.Objects;

public class User {

    private int userId;
    private int roleId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled = false;
    private String password;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.userId;
        hash = 71 * hash + this.roleId;
        hash = 71 * hash + Objects.hashCode(this.firstName);
        hash = 71 * hash + Objects.hashCode(this.lastName);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + (this.enabled ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (this.roleId != other.roleId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.enabled != other.enabled) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
////    public String getRoleTitle() {
////        return roleTitle;
////    }
////
////    public void setRoleTitle(String roleTitle) {
////        this.roleTitle = roleTitle;
////    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 97 * hash + this.userId;
//        hash = 97 * hash + this.roleId;
//        hash = 97 * hash + Objects.hashCode(this.firstName);
//        hash = 97 * hash + Objects.hashCode(this.lastName);
//        hash = 97 * hash + Objects.hashCode(this.email);
////        hash = 97 * hash + Objects.hashCode(this.roleTitle);
//        hash = 97 * hash + Objects.hashCode(this.password);
//        hash = 97 * hash + Objects.hashCode(this.userName);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final User other = (User) obj;
//        if (this.userId != other.userId) {
//            return false;
//        }
//        if (this.roleId != other.roleId) {
//            return false;
//        }
//        if (!Objects.equals(this.firstName, other.firstName)) {
//            return false;
//        }
//        if (!Objects.equals(this.lastName, other.lastName)) {
//            return false;
//        }
//        if (!Objects.equals(this.email, other.email)) {
//            return false;
//        }
////        if (!Objects.equals(this.roleTitle, other.roleTitle)) {
////            return false;
////        }
//        if (!Objects.equals(this.password, other.password)) {
//            return false;
//        }
//        if (!Objects.equals(this.userName, other.userName)) {
//            return false;
//        }
//        return true;
//    }
}
