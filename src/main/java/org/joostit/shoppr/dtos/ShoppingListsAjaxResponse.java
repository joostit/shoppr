package org.joostit.shoppr.dtos;

import java.util.List;

public class ShoppingListsAjaxResponse {

    private List<ShoppingListDto> Lists;

    private String msg;

    public List<ShoppingListDto> getLists() {
        return Lists;
    }

    public void setLists(List<ShoppingListDto> lists) {
        Lists = lists;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
