package org.joostit.shoppr.services.Impl;

import org.joostit.shoppr.dtos.ListItemDto;
import org.joostit.shoppr.dtos.ShoppingListDto;
import org.joostit.shoppr.models.ListItem;
import org.joostit.shoppr.models.ShoppingList;
import org.joostit.shoppr.repos.ShoppingListRepository;
import org.joostit.shoppr.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListServiceMySql implements ShoppingListService {


    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListServiceMySql(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    @Override
    public List<ShoppingListDto> GetAll() {

        List<ShoppingList> models = shoppingListRepository.findAll();

        return toShoppingListDtos(models);
    }

    public void addNew(ShoppingList list){
        shoppingListRepository.save(list);
    }


    public List<ShoppingListDto> findByNameContains(String keyword){
        List<ShoppingList> found = shoppingListRepository.findByNameContains(keyword);

        return toShoppingListDtos(found);
    }




    private List<ShoppingListDto> toShoppingListDtos(List<ShoppingList> models){

        List<ShoppingListDto> result = new ArrayList<>();

        for(ShoppingList model: models){
            ShoppingListDto dto = toDto(model);
            result.add(dto);
        }

        return result;
    }


    private ShoppingListDto toDto(ShoppingList model) {
        ShoppingListDto result = new ShoppingListDto();
        result.setName(model.getName());

        List<ListItem> items = model.getItems();
        result.setItems(toListItemDto(items));

        return result;
    }

    private List<ListItemDto> toListItemDto(List<ListItem> items) {
        List<ListItemDto> result = new ArrayList<>();

        for(ListItem model: items){
            ListItemDto dto = toDto(model);
            result.add(dto);
        }

        return result;
    }

    private ListItemDto toDto(ListItem model) {

        ListItemDto result = new ListItemDto();
        result.setName(model.getName());
        return result;
    }

}
