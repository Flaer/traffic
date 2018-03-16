package ru.website.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by libragimov on 15.03.2018.
 */
@Entity
@Table(name="pages")
public class Page {

    @Id
    @Column(name="id", nullable=false, unique=true)
    private String id;

    public Page() {
    }

    public Page(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
