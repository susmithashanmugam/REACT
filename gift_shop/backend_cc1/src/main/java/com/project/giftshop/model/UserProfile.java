package com.project.giftshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String books;
    private int reviews;
    private int ratings;
    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")

    private User user;

    public UserProfile() {
    }
    public UserProfile(Long id, String books, int reviews, int ratings,User user) {
        this.id = id;
        this.books = books;
        this.reviews = reviews;
        this.ratings = ratings;
        this.user = user;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBooks() {
        return books;
    }
    public void setBooks(String books) {
        this.books= books;
    }
    public int getReviews() {
        return reviews;
    }
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    public int getRatings() {
        return ratings;
    }
    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



}