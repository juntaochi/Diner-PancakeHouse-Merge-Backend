package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {

        List<MenuItemRecord> items = mergerRepository.getTheMenuItems().stream().collect(Collectors.toList());

        return items;
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> getVegetarianItems(){
        List<MenuItemRecord> vegetarianItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.description().toLowerCase().contains("vegetarian") || item.name().toLowerCase().contains("vegetarian") || item.name().toLowerCase().contains("veggies") || item.description().toLowerCase().contains("veggies") || item.name().toLowerCase().contains("veggie") || item.description().toLowerCase().contains("veggie"))
                .collect(Collectors.toList());
        return vegetarianItems;
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> getBreakfastItems(){
        List<MenuItemRecord> breakfastItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.description().toLowerCase().contains("breakfast") || item.name().toLowerCase().contains("breakfast"))
                .collect(Collectors.toList());
        return breakfastItems;
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> getLunchItems(){
        List<MenuItemRecord> lunchItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.name().toLowerCase().contains("lunch"))
                .collect(Collectors.toList());
        return lunchItems;
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> getSupperItems() {
        List<MenuItemRecord> supperItems = mergerRepository.getTheMenuItems().stream()
                .filter(item -> item.name().toLowerCase().contains("dinner"))
                .collect(Collectors.toList());

        return supperItems;
    }
}