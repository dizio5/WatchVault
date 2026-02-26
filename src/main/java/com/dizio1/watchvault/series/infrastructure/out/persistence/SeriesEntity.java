package com.dizio1.watchvault.series.infrastructure.out.persistence;

import com.dizio1.watchvault.genre.infrastructure.out.persistence.GenreEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "series")
public class SeriesEntity {

    @Id
    private Long id;
    private String title;
    private String description;
    private String createdBy;
    private Integer episodes;
    private Integer seasons;
    private LocalDate firstAirDate;
    private LocalDate lastAirDate;
    private String status;
    private boolean adult;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<GenreEntity> genres = new HashSet<>();

    public void addGenre(GenreEntity genre) {
        genres.add(genre);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public LocalDate getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(LocalDate firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public LocalDate getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(LocalDate lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Set<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreEntity> genres) {
        this.genres = genres;
    }
}
