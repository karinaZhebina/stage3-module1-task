package com.mjc.school.service;


import com.mjc.school.service.entity.News;
import com.mjc.school.service.entity.NewsDTO;
import org.mapstruct.Mapper;

@Mapper
public interface NewsMapper {
  NewsDTO toNewsDTO(News news);
  News toNews(NewsDTO newsDTO);
}
