package com.os.db.mapper;

import java.util.List;

import com.os.db.domain.Article;

public interface OrderMapper {

  void insertOrder(Article article);
  Article getArticleByDocid(String docid);
  List<Article> getArticles();
}
