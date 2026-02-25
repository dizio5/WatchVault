package com.dizio1.watchvault.user.domain.model;

import com.dizio1.watchvault.review.domain.Review;

import java.util.List;

public class User {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private List<Review> reviews;
}
