package org.joostit.shoppr.dtos;

import java.util.List;

public class ShoppingListDto {

    private String name;

    private List<ListItemDto> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ListItemDto> getItems() {
        return items;
    }

    public void setItems(List<ListItemDto> items) {
        this.items = items;
    }

}
