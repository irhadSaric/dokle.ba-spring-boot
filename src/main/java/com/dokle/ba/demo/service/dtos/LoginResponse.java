package com.dokle.ba.demo.service.dtos;

import com.dokle.ba.demo.db.entity.User;

public class LoginResponse {
    private User user;
    private boolean passed;

    public LoginResponse() {
    }

    public LoginResponse(User user, boolean passed) {
        this.user = user;
        this.passed = passed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
