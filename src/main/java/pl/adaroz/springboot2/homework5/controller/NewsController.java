package pl.adaroz.springboot2.homework5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.adaroz.springboot2.homework5.model.Article;
import pl.adaroz.springboot2.homework5.model.News;

@Controller
public class NewsController {

    public NewsController() {
        RestTemplate restTemplate = new RestTemplate();
        String apikey = "&apikey=6c863c080bc7468d9de672762381fc4a";
        News news = restTemplate.getForObject("http://newsapi.org/v2/top-headlines?country=us" + apikey,
                News.class);
        for (Article article : news.getArticles())
            System.out.println(article);
    }

}
