package com.db.DAAS.service;

import com.db.DAAS.model.News;

import java.util.List;

public interface NewsService {

    public void createNews(String newsDescription);

    public void updateNews(String newsDescription);

    public List<News> getNews();
}




