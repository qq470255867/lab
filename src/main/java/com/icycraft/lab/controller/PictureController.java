package com.icycraft.lab.controller;

import com.alibaba.fastjson.JSONObject;
import com.icycraft.lab.entity.PageList;
import com.icycraft.lab.entity.WebResult;
import com.icycraft.lab.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/pic/")
public class PictureController {

    @Autowired
    PictureService pictureService;


    @PostMapping("/search/")
    public WebResult getPageListByContent(@RequestBody JSONObject jsonObject){

        try {

            String content = jsonObject.getString("content");
            Integer page = jsonObject.getInteger("page");

            Pageable pageable = PageRequest.of(--page, 48);
            return WebResult.SUCCESS(pictureService.getPageList(content,pageable));

        }catch (Exception e){
            log.error(e.getMessage(),e);
            return WebResult.ERROR(e.getMessage());
        }
    }



}
