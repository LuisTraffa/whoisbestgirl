package com.lvt.waifuranker.services;


import com.lvt.waifuranker.models.UserScore;
import com.lvt.waifuranker.models.Waifu;
import com.lvt.waifuranker.repositories.MyWaifuListRepository;
import com.lvt.waifuranker.repositories.WaifuRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class MyWaifuListService {

    private final MyWaifuListRepository myWaifuListRepository;

    public MyWaifuListService() {
        this.myWaifuListRepository = new MyWaifuListRepository();
    }

    public List<Waifu> getWaifuList(String username) {
        return myWaifuListRepository.getWaifuList(username);
    }

    public List<UserScore> getUserScores(String username) {
        return myWaifuListRepository.getUserScores(username);
    }

    public void updateWaifu(UUID id, int score) {

    }

}
