package com.sbs.exam.demo.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.demo.vo.Article;

@Controller
public class UsrArticleController {
	private int articleLastId;
	private List<Article> articles;

	public UsrArticleController() {
		articles = new ArrayList<>();
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		int id = articleLastId + 1;
		Article article = new Article(id, title, body);

		articles.add(article);
		articleLastId = id;

		return article;
	}

	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articles;
	}
}
