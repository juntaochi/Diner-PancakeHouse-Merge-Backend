package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class DinerMenu extends Menu{


    public DinerMenu(String name, String description) {
        super(name, description);

        addItem("Vegetarian BLT Dinner",
                "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT Diner",
                "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day Dinner",
                "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog Diner",
                "A hot dog, with sauerkraut, relish, onions, topped with cheese",
                false, 3.05);
        addItem("Steamed Veggies and Brown Rice Dinner",
                "Steamed vegetables over brown rice", true, 3.99);
        addItem("Pasta Dinner",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true, 3.89);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        add(menuItem);
    }


    // other menu methods here
}