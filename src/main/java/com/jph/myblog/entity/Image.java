package com.jph.myblog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private Integer id;
    private String imageName;
    private String url;
    private Date imageDate;
    private ImageCategory category;
}
