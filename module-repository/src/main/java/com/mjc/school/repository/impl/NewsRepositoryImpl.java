package com.mjc.school.repository.impl;

import com.mjc.school.repository.DataSource;
import com.mjc.school.repository.NewsRepository;
import com.mjc.school.repository.entity.News;

import java.util.List;

public class NewsRepositoryImpl implements NewsRepository {
  private List<News> newsList;

  public NewsRepositoryImpl() {
    newsList = new DataSource().getDatasource();
  }

  @Override
  public List<News> readAll() {
    return newsList;
  }

  @Override
  public News readById(Long id) {
    return null;
  }

  @Override
  public News create(News news) {
    return null;
  }

  @Override
  public News update(News news) {
    return null;
  }

  @Override
  public boolean delete(News news) {
    return false;
  }
}
