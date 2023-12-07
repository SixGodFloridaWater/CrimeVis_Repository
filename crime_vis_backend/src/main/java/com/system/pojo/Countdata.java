package com.system.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Countdata implements Serializable {
    private Double lat;
    private Double lon;
    private int xcount;
}
