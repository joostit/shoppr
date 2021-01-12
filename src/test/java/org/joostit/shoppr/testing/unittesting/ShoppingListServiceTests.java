package org.joostit.shoppr.testing.unittesting;

import org.joostit.shoppr.dtos.ShoppingListDto;
import org.joostit.shoppr.models.ShoppingList;
import org.joostit.shoppr.repos.ShoppingListRepository;
import org.joostit.shoppr.services.Impl.ShoppingListServiceMySql;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.AdditionalAnswers.returnsFirstArg;

public class ShoppingListServiceTests {

    private ShoppingListServiceMySql listService;
    private ShoppingListRepository listRepo;


    @BeforeEach
    void initTestCase() {
        listRepo = Mockito.mock(ShoppingListRepository.class);
        listService = new ShoppingListServiceMySql(listRepo);
    }

    @Test
    void addNewReturnsValidListObject() {
        ShoppingList listToSave = new ShoppingList("testList");
        when(listRepo.save(any(ShoppingList.class))).then(returnsFirstArg());
        ShoppingList savedList = listService.addNew(listToSave);
        assertThat(savedList).isNotNull();
        assertThat(savedList.getName()).isEqualTo("testList");
    }

    @Test
    void getAllReturnsAllShoppingLists() {
        List<ShoppingList> fakeShoppingLists = new ArrayList<>();
        fakeShoppingLists.add(new ShoppingList("list0"));
        fakeShoppingLists.add(new ShoppingList("list1"));

        when(listRepo.findAll()).thenReturn(fakeShoppingLists);

        List<ShoppingListDto> result = listService.getAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("list0");
        assertThat(result.get(1).getName()).isEqualTo("list1");
    }

}
