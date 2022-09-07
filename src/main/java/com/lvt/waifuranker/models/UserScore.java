package com.lvt.waifuranker.models;

public class UserScore {

    private Long id;
    private Long score;

    public UserScore(Long id, Long score) {
        this.id = id;
        this.score = score;
    }


    public Long getId() {
        return id;
    }

    public Long getScore() {
        return score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(Long score) {
        this.score = score;
    }

}
