package com.lvt.waifuranker.controllers;


import com.lvt.waifuranker.services.WaifuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.lvt.waifuranker.controllers.AuthenticationController.isLoggedIn;


@Controller
public class MyWaifuListController {

    private final WaifuService waifuService;

    public MyWaifuListController (WaifuService waifuService) {
        this.waifuService = waifuService;
    }

    @GetMapping("/my-waifu-list")
    public String myWaifuList(Model model) {
        if (!isLoggedIn()) {
            return "redirect:/login";
        }

        model.addAttribute("waifus", waifuService.getWaifuList());

        return "my-waifu-list";
    }

}
