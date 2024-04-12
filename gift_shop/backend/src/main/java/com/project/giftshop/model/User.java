package com.project.giftshop.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String pw;
    private String pw1;
    private String journal;
    @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="id",referencedColumnName = "id")
    private UserProfile userProfile;
//    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
//    private List<Book> books;
    public User() {
    }
    public User(String username, String email, String pw, String pw1,String journal,Long id,UserProfile userProfile) {
        this.username = username;
        this.email = email;
        this.pw = pw;
        this.pw1 = pw1;
        this.journal = journal;
        this.id = id;
        this.userProfile=userProfile;
    }


    public UserProfile getUserProfile() {
        return userProfile;
    }
    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getPw1() {
        return pw1;
    }
    public void setPw1(String pw1) {
        this.pw1 = pw1;
    }
    public String getJournal() {
        return journal;
    }
    public void setJournal(String journal) {
        this.journal = journal;
    }
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }


}