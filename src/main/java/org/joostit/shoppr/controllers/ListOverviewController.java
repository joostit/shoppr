package org.joostit.shoppr.controllers;

import org.joostit.shoppr.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListOverviewController {

    private final ShoppingListService shoppingListsService;

    @Autowired
    public ListOverviewController(ShoppingListService shoppingLists) {
        this.shoppingListsService = shoppingLists;
    }


    @GetMapping("/list")
    protected String showAuthors(Model model) {
        model.addAttribute("allLists", shoppingListsService.getAll());
        return "listOverview";
    }

    

    // Serves a webpage without thymeleaf code, that uses AJAX to search for shopping lists
    @GetMapping("/")
    protected String index(Model model) {
        return "listOverviewAjax";
    }
}
