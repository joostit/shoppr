package org.joostit.shoppr.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ListItem {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer listItemId;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shoppingListId", referencedColumnName = "shoppingListId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ShoppingList shoppingList;


    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

    public Integer getListItemId() {
        return listItemId;
    }

    public void setListItemId(Integer listItemId) {
        this.listItemId = listItemId;
    }

}
