package com.dizio1.watchvault.review.infraestructure.out.persistence;

import com.dizio1.watchvault.review.domain.ShowType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long showId;
    @Enumerated(EnumType.STRING)
    private ShowType showType;
    private String title;
    private String description;
    private Integer rating;
    private LocalDate reviewedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public LocalDate getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(LocalDate reviewedAt) {
        this.reviewedAt = reviewedAt;
    }

    public ShowType getShowType() {
        return showType;
    }

    public void setShowType(ShowType showType) {
        this.showType = showType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer stars) {
        this.rating = stars;
    }
}
