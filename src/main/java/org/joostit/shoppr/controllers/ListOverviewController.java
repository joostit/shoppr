package org.joostit.shoppr.controllers;

import org.joostit.shoppr.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListOverviewController {

    private ShoppingListService shoppingLists;

    @Autowired
    public ListOverviewController(ShoppingListService shoppingLists){
        this.shoppingLists = shoppingLists;
    }


    @GetMapping("/")
    protected String showAuthors(Model model) {
        model.addAttribute("allLists", shoppingLists.GetAll());
        return "listOverview";
    }
}
