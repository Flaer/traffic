package ru.website.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User that attended site
 * Created by libragimov on 15.03.2018.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="id", nullable=false, unique=true)
    private String id;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
