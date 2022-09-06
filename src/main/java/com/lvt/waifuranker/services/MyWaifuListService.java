package com.lvt.waifuranker.services;


import com.lvt.waifuranker.repositories.MyWaifuListRepository;
import org.springframework.stereotype.Controller;

@Controller
public class MyWaifuListService {

    MyWaifuListRepository myWaifuListRepository;

    public MyWaifuListService() {
        this.myWaifuListRepository = new MyWaifuListRepository();
    }



}
