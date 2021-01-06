package org.joostit.shoppr.services;

import org.joostit.shoppr.dtos.ShoppingListDto;
import org.joostit.shoppr.models.ShoppingList;

import java.util.List;

public interface ShoppingListService {
    List<ShoppingListDto> GetAll();
}
