package com.north;

import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {

    public static String newsMessageToXml(NewsMessage newsMessage){
        XStream xstream = new XStream();
        xstream.alias("xml", newsMessage.getClass());
        xstream.alias("item", new News().getClass());
        return xstream.toXML(newsMessage);

    }

    public static void main(String[] args) {

        List<News> newList = new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();
        News news = new News();
        news.setTitle("JAVA程序员介绍");
        news.setDescription("JAVA程序员广义上是指一群以JAVA为谋生手段的软件开发人员。狭义的说，是指拥有SUN公司JAVA认证的程序员。Sun Java认证分为两个级别：Sun 认证Java程序员和Sun 认证Java开发员。通常要求程序员精通java基础，java高级编程，及常用java设计模式，并深入理解mvc编程模式，了解uml相关知识!");
        news.setPicUrl("http://c3798041.ngrok.io/WeiXinTest/image/java.jpg");//这里测试采用地址，换成自己项目下面的图片路径
        news.setUrl("www.baidu.com");
        newList.add(news);
        newsMessage.setToUserName("oSjfT1AAzFc8FkwZA45qkyb3Hoxo");
        newsMessage.setFromUserName("gaokunkobe");
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType("news");
        newsMessage.setArticles(newList);
        newsMessage.setArticleCount(newList.size());
        String message = newsMessageToXml(newsMessage);
        System.out.println(message);
    }
}
