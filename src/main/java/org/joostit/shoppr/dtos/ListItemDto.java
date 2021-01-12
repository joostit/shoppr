package org.joostit.shoppr.dtos;

public class ListItemDto {

    private String name;

    public ListItemDto(){}

    public ListItemDto(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
