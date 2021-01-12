package org.joostit.shoppr.services.dtoConverters;

import org.joostit.shoppr.dtos.ListItemDto;
import org.joostit.shoppr.dtos.ShoppingListDto;
import org.joostit.shoppr.models.ListItem;
import org.joostit.shoppr.models.ShoppingList;

import java.util.ArrayList;
import java.util.List;

public class ShoppinglistConverter {


    public List<ShoppingListDto> toShoppingListDtos(List<ShoppingList> models){

        List<ShoppingListDto> result = new ArrayList<>();

        for(ShoppingList model: models){
            ShoppingListDto dto = toDto(model);
            result.add(dto);
        }

        return result;
    }


    public ShoppingListDto toDto(ShoppingList model) {
        ShoppingListDto result = new ShoppingListDto();
        result.setName(model.getName());

        List<ListItem> items = model.getItems();
        result.setItems(toListItemDtos(items));

        return result;
    }

    public List<ListItemDto> toListItemDtos(List<ListItem> items) {
        List<ListItemDto> result = new ArrayList<>();

        for(ListItem model: items){
            ListItemDto dto = toDto(model);
            result.add(dto);
        }

        return result;
    }

    public ListItemDto toDto(ListItem model) {

        ListItemDto result = new ListItemDto();
        result.setName(model.getName());
        return result;
    }


}
