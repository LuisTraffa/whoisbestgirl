package com.lvt.waifuranker.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Waifu {

    private final Long id;
    private String name;
    private double score;
    private String anime;

    private String description;
    private String imageURL;
    private String quote;
    private long numberOfVotes;

    public Waifu(@JsonProperty Long id, @JsonProperty String name, @JsonProperty double score, @JsonProperty String anime, @JsonProperty String imageURL,@JsonProperty String description,  @JsonProperty String quote, @JsonProperty Long numberOfVotes) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.anime = anime;
        this.imageURL = imageURL;
        this.quote = quote;
        this.numberOfVotes = numberOfVotes;
        this.description = description;

    }

    public Long getId() {
        return id;
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

    public String getImageURL() {
        return imageURL;
    }

    public String getQuote() {
        return quote;
    }

    public long getNumberOfVotes() {
        return numberOfVotes;
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

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setNumberOfVotes(long numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
