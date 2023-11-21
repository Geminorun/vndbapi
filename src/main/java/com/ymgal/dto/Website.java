package com.ymgal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Website {

    /**
     * 网站标题、描述
     */
    private String title;

    /**
     * 网站链接
     */
    private String link;
}