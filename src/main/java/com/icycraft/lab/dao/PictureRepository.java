package com.icycraft.lab.dao;

import com.icycraft.lab.entity.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends ElasticsearchRepository<Picture,Long> {

    @Query("{\"bool\" : {\"must\" : [ {\"match\" : {\"content\" : \"?0\"}} ]}}")
    Page<Picture> findByContent(String content, Pageable pageable);

}
