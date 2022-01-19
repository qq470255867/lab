package com.icycraft.lab.service;

import com.icycraft.lab.entity.PageList;
import com.icycraft.lab.entity.Picture;
import org.springframework.data.domain.Pageable;

public interface PictureService {


        PageList<Picture> getPageList(String content, Pageable pageable);
}
