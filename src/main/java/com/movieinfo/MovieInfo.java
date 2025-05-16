/*
 * 資料封裝類別，用來存儲與電影相關的資訊。主要用於在系統內部傳遞電影數據。
 */
package com.movieinfo;

import java.util.ArrayList;
import java.util.List;

public class MovieInfo {
    private String title;
    private String originalTitle;
    private String rating;
    private String releaseDate;
    private List<String> genres;
    private List<String> cast;
    private String director; // 新增字段：導演名稱
    private String url;

    public MovieInfo() {
        this.genres = new ArrayList<>();
        this.cast = new ArrayList<>();
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getOriginalTitle() { return originalTitle; }
    public void setOriginalTitle(String originalTitle) { this.originalTitle = originalTitle; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public List<String> getGenres() { return genres; }
    public void setGenres(List<String> genres) { this.genres = genres; }

    public List<String> getCast() { return cast; }
    public void setCast(List<String> cast) { this.cast = cast; }

    public String getDirector() { return director; } // 新增 getter
    public void setDirector(String director) { this.director = director; } // 新增 setter

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}