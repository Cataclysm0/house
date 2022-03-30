package com.pzhu.house.model.house;

import lombok.Data;

import java.io.Serializable;

@Data
public class TagModel implements Serializable {

    private Long id;
    private String content;

}
