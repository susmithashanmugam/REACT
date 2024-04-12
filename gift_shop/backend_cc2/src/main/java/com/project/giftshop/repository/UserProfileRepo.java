package com.project.giftshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.giftshop.model.UserProfile;

public interface UserProfileRepo extends JpaRepository<UserProfile,Integer>{


}
