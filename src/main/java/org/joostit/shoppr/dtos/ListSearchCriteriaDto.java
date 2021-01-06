package org.joostit.shoppr.dtos;

import javax.validation.constraints.NotBlank;

public class ListSearchCriteriaDto {

    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
