package com.icycraft.lab.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "picture_index")
public class Picture {


    private long id;

    private String content;

    private String url;

}
