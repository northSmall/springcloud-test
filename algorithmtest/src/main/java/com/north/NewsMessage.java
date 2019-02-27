package com.north;

import java.util.List;

public class NewsMessage extends CommMessage {
    private int ArticleCount;//消息数量

    private List<News> Articles;//消息体

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }
}