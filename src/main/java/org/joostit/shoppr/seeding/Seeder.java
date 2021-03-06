package org.joostit.shoppr.seeding;

import org.joostit.shoppr.models.ShoppingList;
import org.joostit.shoppr.services.Impl.UserDetailsServiceImpl;
import org.joostit.shoppr.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Seeder {

    private ShoppingListService shoppingListService;

    private UserDetailsServiceImpl userService;

    @Autowired
    public Seeder(ShoppingListService shoppingListService, UserDetailsServiceImpl userService){
        this.shoppingListService = shoppingListService;
        this.userService = userService;
    }


    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedShoppingLists();
        seedUsers();
    }

    private void seedUsers() {

        userService.addUser("tester", "test", "ADMIN");

    }

    private void seedShoppingLists() {

        if(shoppingListService.getAll().size() == 0){
            shoppingListService.addNew(new ShoppingList("Groceries"));
            shoppingListService.addNew(new ShoppingList("Makro"));
            shoppingListService.addNew(new ShoppingList("Kruidvat"));
            shoppingListService.addNew(new ShoppingList("Cadeau's"));
            shoppingListService.addNew(new ShoppingList("Films"));
            shoppingListService.addNew(new ShoppingList("Musical Instruments"));
            shoppingListService.addNew(new ShoppingList("Gadgets"));
            shoppingListService.addNew(new ShoppingList("Sports stuff"));
            shoppingListService.addNew(new ShoppingList("Superfoods"));
            shoppingListService.addNew(new ShoppingList("Hipster items"));
            shoppingListService.addNew(new ShoppingList("Voedselbank donaties"));
            shoppingListService.addNew(new ShoppingList("CD's"));
            shoppingListService.addNew(new ShoppingList("Vuurwerk"));
            shoppingListService.addNew(new ShoppingList("DVD's"));
            shoppingListService.addNew(new ShoppingList("Coupons"));
            shoppingListService.addNew(new ShoppingList("Apotheek"));
            shoppingListService.addNew(new ShoppingList("Software"));
            shoppingListService.addNew(new ShoppingList("Booze"));
        }

    }
}
