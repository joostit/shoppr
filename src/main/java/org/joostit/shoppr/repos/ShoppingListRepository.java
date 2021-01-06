package org.joostit.shoppr.repos;

import org.joostit.shoppr.models.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {

    ShoppingList save(ShoppingList list);

}
