package com.db.DAAS.resource;

import com.db.DAAS.mapper.NewsMapper;
import com.db.DAAS.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.db.DAAS.service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsResource implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    @PostMapping("/create")
    public void createNews(String newsDescription) {
        newsMapper.updateNews(newsDescription);
    }

    @Override
    @PutMapping("/update")
    public void updateNews(String newsDescription) {
        System.out.println("Update called with Des " + newsDescription);
        newsMapper.updateNews(newsDescription);
    }

    @Override
    @GetMapping("/getnews")
    public List<News> getNews() {
        return newsMapper.getNews();
    }
}
