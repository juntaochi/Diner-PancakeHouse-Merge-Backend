package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.CafeRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {
    MenuItem[] menuItems;
    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;
    CafeRepository cafeRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository, CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
        menuItems = new MenuItem[dinerRepository.getTheMenu().length + pancakeHouseRepository.getTheMenu().size() + cafeRepository.getTheMenu().values().toArray().length];

    }

    @GetMapping
    public MenuItem[] get() {
        MenuItem[] dinerMenuItems = dinerRepository.getTheMenu();
        List<MenuItem> pancakeHouseMenuItems = pancakeHouseRepository.getTheMenu();
        for (int i = 0; i < dinerMenuItems.length; i++) {
            menuItems[i] = dinerMenuItems[i];
        }
        for (int i = 0; i < pancakeHouseMenuItems.size(); i++) {
            menuItems[i + dinerMenuItems.length] = pancakeHouseMenuItems.get(i);
        }
        //add Cafe Menu using
        Object[] cafeItems = cafeRepository.getTheMenu().values().toArray();
        for (int i = 0; i < cafeItems.length; i++) {
            menuItems[i + dinerMenuItems.length + pancakeHouseMenuItems.size()-1] = (MenuItem) cafeItems[i];
        }

        return menuItems;
    }
}