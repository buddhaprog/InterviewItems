package com.swcguild.capstonemvcproject.dto;

import java.util.Objects;

public class HashTag {

    private int hashTagId;
    private String hashTag;

    public int getHashTagId() {
        return hashTagId;
    }

    public void setHashTagId(int hashTagId) {
        this.hashTagId = hashTagId;
    }

    public String getHashTag() {
        return hashTag;
    }

    public void setHashTag(String hashTag) {
        this.hashTag = hashTag;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.hashTagId;
        hash = 43 * hash + Objects.hashCode(this.hashTag);
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
        final HashTag other = (HashTag) obj;
        if (this.hashTagId != other.hashTagId) {
            return false;
        }
        if (!Objects.equals(this.hashTag, other.hashTag)) {
            return false;
        }
        return true;
    }

}
