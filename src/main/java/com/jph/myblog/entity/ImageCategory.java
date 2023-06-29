package com.jph.myblog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageCategory {

    private Integer id;
    private String categoryName;

    public ImageCategory(Integer id) {
        this.id = id;
    }

}
