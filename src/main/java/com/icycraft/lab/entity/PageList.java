package com.icycraft.lab.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageList<T> {

    private List<T> list;

    private long count;

    private int page;

    private int totalPage;
}
