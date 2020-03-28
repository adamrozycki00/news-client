package pl.adaroz.springboot2.homework5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.adaroz.springboot2.homework5.model.Article;
import pl.adaroz.springboot2.homework5.model.News;

import java.util.List;

@Controller
public class NewsController {

    private List<Article> getNews() {
        RestTemplate restTemplate = new RestTemplate();
        String apikey = "&apikey=6c863c080bc7468d9de672762381fc4a";
        News news = restTemplate.getForObject("http://newsapi.org/v2/top-headlines?country=us" + apikey,
                News.class);
        return news.getArticles();
    }

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("news", getNews());
        return "news";
    }

}
