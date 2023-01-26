package com.example.demo.assignment;

import com.example.demo.inventory.asset.Asset;
import com.example.demo.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private LocalDateTime startOfAssignment;
    private LocalDateTime endOfAssignment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartOfAssignment() {
        return startOfAssignment;
    }

    public void setStartOfAssignment(LocalDateTime startOfAssignment) {
        this.startOfAssignment = startOfAssignment;
    }

    public LocalDateTime getEndOfAssignment() {
        return endOfAssignment;
    }

    public void setEndOfAssignment(LocalDateTime endOfAssignment) {
        this.endOfAssignment = endOfAssignment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
