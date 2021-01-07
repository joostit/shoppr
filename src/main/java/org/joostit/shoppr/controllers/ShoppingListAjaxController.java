package org.joostit.shoppr.controllers;

import org.joostit.shoppr.dtos.ListItemDto;
import org.joostit.shoppr.dtos.ListSearchCriteriaDto;
import org.joostit.shoppr.dtos.ShoppingListDto;
import org.joostit.shoppr.dtos.ShoppingListsAjaxResponse;
import org.joostit.shoppr.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ShoppingListAjaxController {

    private final ShoppingListService shoppingListsService;

    @Autowired
    public ShoppingListAjaxController(ShoppingListService shoppingLists) {
        this.shoppingListsService = shoppingLists;
    }

    @PostMapping("/api/getLists")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody ListSearchCriteriaDto search, Errors errors) {

        ShoppingListsAjaxResponse result = new ShoppingListsAjaxResponse();

        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);    // HTTP 400
        }

        List<ShoppingListDto> lists;

        if(search.getKeywords() != null && search.getKeywords().trim().isEmpty()) {
            lists = shoppingListsService.GetAll();
        }
        else{
            lists = shoppingListsService.findByNameContains(search.getKeywords());
        }

        result.setLists(lists);

        return ResponseEntity.ok(result);

    }



}
