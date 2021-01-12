package org.joostit.shoppr.testing.unittesting;

import org.joostit.shoppr.dtos.ListItemDto;
import org.joostit.shoppr.dtos.ShoppingListDto;
import org.joostit.shoppr.models.ListItem;
import org.joostit.shoppr.models.ShoppingList;
import org.joostit.shoppr.services.dtoConverters.ShoppinglistConverter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingListDtoConverterTests {

    @Test
    void TestToListItemToDto(){
        ShoppinglistConverter converter = new ShoppinglistConverter();
        ListItem itemModel = new ListItem("item");

        ListItemDto dto = converter.toDto(itemModel);

        assertThat(dto.getName()).isEqualTo("item");
    }

    @Test
    void TestToListItemDtos(){
        ShoppinglistConverter converter = new ShoppinglistConverter();

        List<ListItem> items = new ArrayList<>();
        items.add(new ListItem("item0"));
        items.add(new ListItem("item1"));

        List<ListItemDto> dtos = converter.toListItemDtos(items);

        assertThat(dtos.get(0).getName()).isEqualTo("item0");
        assertThat(dtos.get(1).getName()).isEqualTo("item1");
    }


    @Test
    void TestToListToDto(){
        ShoppinglistConverter converter = new ShoppinglistConverter();
        ShoppingList listModel = new ShoppingList("list");
        listModel.getItems().add(new ListItem("item0"));
        listModel.getItems().add(new ListItem("item1"));

        ShoppingListDto dto = converter.toDto(listModel);

        assertThat(dto.getName()).isEqualTo("list");

        assertThat(dto.getItems().size()).isEqualTo(2);
        assertThat(dto.getItems().get(0).getName()).isEqualTo("item0");
        assertThat(dto.getItems().get(1).getName()).isEqualTo("item1X");
    }


    @Test
    void TesttoShoppingListDtos(){
        ShoppinglistConverter converter = new ShoppinglistConverter();

        List<ShoppingList> items = new ArrayList<>();
        items.add(new ShoppingList("list0"));
        items.add(new ShoppingList("list1"));

        List<ShoppingListDto> dtos = converter.toShoppingListDtos(items);

        assertThat(dtos.get(0).getName()).isEqualTo("list0");
        assertThat(dtos.get(1).getName()).isEqualTo("list1");
    }

}
