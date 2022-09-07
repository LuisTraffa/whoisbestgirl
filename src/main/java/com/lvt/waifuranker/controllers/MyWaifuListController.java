package com.lvt.waifuranker.controllers;


import com.lvt.waifuranker.services.MyWaifuListService;
import com.lvt.waifuranker.services.WaifuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.lvt.waifuranker.controllers.AuthenticationController.getCurrentUsersUsername;
import static com.lvt.waifuranker.controllers.AuthenticationController.isLoggedIn;


@Controller
public class MyWaifuListController {

    private final MyWaifuListService myWaifuListService;

    public MyWaifuListController (MyWaifuListService myWaifuListService) {
        this.myWaifuListService = myWaifuListService;
    }

    @GetMapping("/my-waifu-list")
    public String myWaifuList(Model model) {
        if (!isLoggedIn()) {
            return "redirect:/login";
        }

        model.addAttribute("waifus", myWaifuListService.getWaifuList(getCurrentUsersUsername()));
        model.addAttribute("userScores", myWaifuListService.getUserScores(getCurrentUsersUsername()));


        return "my-waifu-list";
    }

}
