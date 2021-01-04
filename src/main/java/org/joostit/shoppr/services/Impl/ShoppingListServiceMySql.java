package org.joostit.shoppr.services.Impl;
import org.joostit.shoppr.models.ShoppingList;
import org.joostit.shoppr.repos.ShoppingListRepository;
import org.joostit.shoppr.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListServiceMySql implements ShoppingListService {


    private ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListServiceMySql(ShoppingListRepository shoppingListRepository){
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public List<ShoppingList> GetAll() {
        return shoppingListRepository.findAll();
    }
}
