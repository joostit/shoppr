package org.joostit.shoppr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer shoppingListId;

    private String name;

    @OneToMany(mappedBy = "shoppingList")
    private List<ListItem> Items;

    public Integer getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Integer shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<ListItem> getItems() {
        return Items;
    }

    public void setItems(List<ListItem> items) {
        Items = items;
    }


}
