package com.pzhu.house.model.params.mobile;

import lombok.Data;

import java.io.Serializable;

@Data
public class IndexHoseListParams implements Serializable {

    private String cityName;
    private String district;
    private Integer page;

}
