package com.lvt.waifuranker.controllers;


import com.lvt.waifuranker.models.Waifu;
import com.lvt.waifuranker.services.WaifuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import static com.lvt.waifuranker.controllers.AuthenticationController.isLoggedIn;

@Controller
public class IndexController {

    private final WaifuService waifuService;

    public IndexController(WaifuService waifuService) {
        this.waifuService = waifuService;
    }


    @GetMapping("/")
    public String index(Model model) {

        System.out.println(waifuService.getWaifuList().toString());
        model.addAttribute("waifus", waifuService.getWaifuList());
        if (isLoggedIn()) {
            return "indexPrivate";
        }
        return "indexPublic";
    }

    public boolean isWaifuValid(Waifu waifu) {
        return waifu.getName() != null && waifu.getAnime() != null && waifu.getImageURL() != null && waifu.getQuote() != null && waifu.getScore() > -1;
    }


}
