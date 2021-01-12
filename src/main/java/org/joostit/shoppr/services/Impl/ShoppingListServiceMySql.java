package org.joostit.shoppr.services.Impl;

import org.joostit.shoppr.dtos.ListItemDto;
import org.joostit.shoppr.dtos.ShoppingListDto;
import org.joostit.shoppr.models.ListItem;
import org.joostit.shoppr.models.ShoppingList;
import org.joostit.shoppr.repos.ShoppingListRepository;
import org.joostit.shoppr.services.ShoppingListService;
import org.joostit.shoppr.services.dtoConverters.ShoppinglistConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListServiceMySql implements ShoppingListService {

    ShoppinglistConverter dtoConverter = new ShoppinglistConverter();

    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListServiceMySql(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }


    @Override
    public List<ShoppingListDto> getAll() {

        List<ShoppingList> models = shoppingListRepository.findAll();

        return dtoConverter.toShoppingListDtos(models);
    }


    public ShoppingList addNew(ShoppingList list){
        return shoppingListRepository.save(list);
    }


    public List<ShoppingListDto> findByNameContains(String keyword){
        List<ShoppingList> found = shoppingListRepository.findByNameContains(keyword);

        return dtoConverter.toShoppingListDtos(found);
    }


}
