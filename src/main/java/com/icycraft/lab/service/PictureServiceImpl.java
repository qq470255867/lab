package com.icycraft.lab.service;

import com.icycraft.lab.dao.PictureRepository;
import com.icycraft.lab.entity.PageList;
import com.icycraft.lab.entity.Picture;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PictureServiceImpl implements PictureService{


    @Autowired
    PictureRepository pictureRepository;

    @Override
    public PageList<Picture> getPageList(String content, Pageable pageable) {
        Page<Picture> byContent;
        if (StringUtils.isEmpty(content)){
            byContent = pictureRepository.findAll(pageable);
        }else {
            byContent = pictureRepository.findByContent(content, pageable);

        }
        PageList<Picture> result = new PageList<>();

        result.setList(byContent.getContent());
        result.setCount(byContent.getTotalElements());
        result.setTotalPage(byContent.getTotalPages());

        return result;
    }
}
