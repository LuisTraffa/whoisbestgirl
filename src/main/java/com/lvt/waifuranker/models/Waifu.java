package com.lvt.waifuranker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Waifu {
    private String name;
    private double score;
    private String anime;
    private String description;

    private String url;
    private String quote;
    private long votes;

    public Waifu (@JsonProperty String name, @JsonProperty double score, @JsonProperty String anime,@JsonProperty String description, @JsonProperty String url,  @JsonProperty String quote, @JsonProperty Long votes) {
        this.name = name;
        this.score = score;
        this.anime = anime;
        this.url = url;
        this.quote = quote;
        this.votes = votes;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getAnime() {
        return anime;
    }

    public String getUrl() {
        return url;
    }

    public String getQuote() {
        return quote;
    }

    public long getVotes() {
        return votes;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
