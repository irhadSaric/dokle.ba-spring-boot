package com.dokle.ba.demo.db.entity;

import com.dokle.ba.demo.db.keys.UserPathKey;

import javax.persistence.*;

@Entity
@Table(name = "user_paths")
@IdClass(UserPathKey.class)
public class UserRoute {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "path_id")
    private Path path;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
