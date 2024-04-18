package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;

public class Menu extends MenuComponent{
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[menuComponents.size()];
        for (int i = 0; i < menuComponents.size(); i++) {
            items[i] = (MenuItem)menuComponents.get(i);
        }
        return items;
    }
}