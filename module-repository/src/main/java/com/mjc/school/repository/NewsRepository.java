package com.mjc.school.repository;

import com.mjc.school.repository.entity.News;

import java.util.List;

public interface NewsRepository {

  List<News> readAll();

  News readById(Long id);

  News create(News news);

  News update(News news);

  boolean delete(News news);

}
