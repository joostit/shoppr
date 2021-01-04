package org.joostit.shoppr.repos;

import org.joostit.shoppr.models.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
}
