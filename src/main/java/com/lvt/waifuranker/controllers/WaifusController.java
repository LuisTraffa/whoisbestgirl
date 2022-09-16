package com.lvt.waifuranker.controllers;

import com.lvt.waifuranker.models.Waifu;
import com.lvt.waifuranker.services.WaifuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WaifusController {
    private final WaifuService waifuService;

    public WaifusController(WaifuService waifuService) {
        this.waifuService = waifuService;
    }

    @GetMapping("/waifus")
    public List<Waifu> waifuList() {
        System.out.println("Eins");
        return waifuService.getWaifuList();
    }


}
