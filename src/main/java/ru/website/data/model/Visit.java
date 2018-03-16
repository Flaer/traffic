package ru.website.data.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by libragimov on 16.03.2018.
 */
@Entity
@Table(name="visits")
public class Visit {

    @Id
    @Column(name="id", nullable=false, unique=true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visits_seq")
    @SequenceGenerator(name = "visits_seq", sequenceName = "visits_seq", allocationSize = 1)
    private Long id;
    private String userId;
    private String pageId;
    @Column(name="created")
    private LocalDateTime created;

    public Visit() {
        this.created = LocalDateTime.now();
    }

    public Visit(String userId, String pageId) {
        this.userId = userId;
        this.pageId = pageId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "page_id")
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
