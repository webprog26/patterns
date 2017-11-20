package com.example.webprog26.patternstask.singleton_builder;

import java.util.UUID;

/**
 * Created by webprog26 on 20.11.17.
 */

public class User {

    private static User instance;

    private User() {}

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    private UUID mUserId;
    private String mUserName;
    private int mUserAge;
    private String mUserEmail;
    private boolean isPrivileged = false;

    public UUID getUserId() {
        return mUserId;
    }

    public String getUserName() {
        return mUserName;
    }

    public int getUserAge() {
        return mUserAge;
    }

    public String getUserEmail() {
        return mUserEmail;
    }

    public boolean isPrivileged() {
        return isPrivileged;
    }

    public Builder Builder(){
        return getInstance().new Builder();
    }

    public class Builder{

        public Builder setUserId(final UUID userId){
            User.this.mUserId = userId;
            return this;
        }

        public Builder setUserName(final String userName){
            User.this.mUserName = userName;
            return this;
        }

        public Builder setUserAge(final int userAge){
            User.this.mUserAge = userAge;
            return this;
        }

        public Builder setUserEmail(final String userEmail){
            User.this.mUserEmail = userEmail;
            return this;
        }

        public Builder setIsPrivileged(final boolean isPrivileged){
            User.this.isPrivileged = isPrivileged;
            return this;
        }

        public User build(){
            return User.this;
        }
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("User\n")
                .append("with id ")
                .append(getUserId().toString() + "\n")
                .append("with name ")
                .append(getUserName() + "\n")
                .append("with e-mail ")
                .append(getUserEmail() + "\n")
        .append("is privilegged ")
        .append(String.valueOf(isPrivileged()) + "\n");
        return stringBuilder.toString();
    }
}
