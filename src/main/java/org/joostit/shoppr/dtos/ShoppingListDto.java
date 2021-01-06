package org.joostit.shoppr.dtos;

import java.util.List;

public class ShoppingListDto {

    private String name;
    private List<ShoppingListDto> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ShoppingListDto> getItems() {
        return items;
    }

    public void setItems(List<ShoppingListDto> items) {
        this.items = items;
    }

}
