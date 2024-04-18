package edu.iu.habahram.DinerPancakeHouseMerge.model;

public class CafeMenu extends Menu{

    public CafeMenu(String name, String description) {
        super(name, description);
        addItem("Veggie Burger and Air Fries lunch",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99);
        addItem("Soup of the day lunch",
                "A cup of the soup of the day, with a side salad",
                false, 3.69);
        addItem("Burrito lunch",
                "A large burrito, with whole pinto beans, salsa, guacamole",
                true, 4.29);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price)
    {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        add(menuItem);
    }
}