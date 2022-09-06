package com.lvt.waifuranker.services;

import com.lvt.waifuranker.models.Waifu;
import com.lvt.waifuranker.repositories.WaifuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WaifuService {

    private final WaifuRepository waifuRepository;

    public WaifuService () {
        this.waifuRepository = new WaifuRepository();
    }

    public List<Waifu> getWaifuList() {
        return waifuRepository.getWaifuList();
    }

    public void updateWaifu(UUID id, int score) {

    }


}
