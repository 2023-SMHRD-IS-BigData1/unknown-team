package com.newSummary.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newSummary.domain.dto.NewsDTO;
import com.newSummary.service.NewsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private final NewsService newsService;
	
	// 뉴스 전체 데이터
    @GetMapping("/list")
    public List<NewsDTO> getNews() {
    	List<NewsDTO> newsList = newsService.getNewsList();
        return newsList;
    }
    @GetMapping("/detail/{id}")
    // 뉴스 상세 데이터
    public NewsDTO NewsDetail(@PathVariable("id") String id) {
    	NewsDTO dto = newsService.detailNews(id);
    	return dto;
    }
    // 뉴스 검색 데이터
    @GetMapping("/search")
    public List<NewsDTO> searchNews(@RequestParam String term) {
        return newsService.searchNews(term);
    }

}
