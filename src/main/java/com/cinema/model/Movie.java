package com.cinema.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table( name = "movies" )
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 120)
    private String title;
    @Column
    private Integer length_min;
    @Column
    private String description;
    @Column(length = 255)
    private String image_url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    public Movie() { }

    public Movie(Long id, String title, Integer length_min, String description, String image_url) {
        this.id = id;
        this.title = title;
        this.length_min = length_min;
        this.description = description;
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength_min(Integer length) {
        this.length_min = length;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public Integer getLength_min() {
        return length_min;
    }

    public String getDescription() {
        return description;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
