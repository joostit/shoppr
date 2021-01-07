package org.joostit.shoppr.repos;

import org.joostit.shoppr.models.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {

    ShoppingList save(ShoppingList list);
    List<ShoppingList> findByNameContains(String keyword);

}
