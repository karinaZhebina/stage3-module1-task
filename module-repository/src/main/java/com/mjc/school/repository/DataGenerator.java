package com.mjc.school.repository;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.entity.News;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
  private static final int DATASOURCE_SIZE = 20;
  private final List<Author> authors;
  private final List<String> contents;
  private final List<String> titles;
  private List<News> datasource;

  public DataGenerator() {
    titles = new ArrayList<>();
    contents = new ArrayList<>();
    authors = new ArrayList<>();
    datasource = new ArrayList<>();
  }

  public List<News> getDatasource() {
    loadDataFromFiles();
    generateDataSource();
    return datasource;
  }
  private void loadDataFromFiles() {
    try (BufferedReader brTitles = new BufferedReader(new FileReader("module-repository/src/main/resources/news.txt"));
         BufferedReader brContents = new BufferedReader(new FileReader("module-repository/src/main/resources/content.txt"));
         BufferedReader brAuthors = new BufferedReader(new FileReader("module-repository/src/main/resources/author.txt"))) {

      brTitles.lines().forEach(titles::add);
      brContents.lines().forEach(contents::add);
      brAuthors.lines().forEach(name -> authors.add(new Author(generateId(), name)));

    } catch (IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
  }

  private void generateDataSource() {
    Random random = new Random();
    while (datasource.size() < DATASOURCE_SIZE) {
      int index = random.nextInt(titles.size());
      News news = new News();
      news.setId(generateId());
      news.setTitle(titles.get(index));
      news.setContent(contents.get(index));
      news.setCreateDate(LocalDateTime.now());
      news.setLastUpdateDate(LocalDateTime.now());
      news.setAuthorId(authors.get(index).getId());
      datasource.add(news);
    }
  }

  private Long generateId() {
    return ThreadLocalRandom.current().nextLong();
  }
}
