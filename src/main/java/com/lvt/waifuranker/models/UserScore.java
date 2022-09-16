package com.lvt.waifuranker.models;

public class UserScore {

    private String name;
    private Long score;

    public UserScore(String name, Long score) {
        this.name = name;
        this.score = score;
    }


    public String getName() {
        return this.name;
    }

    public Long getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Long score) {
        this.score = score;
    }

}
