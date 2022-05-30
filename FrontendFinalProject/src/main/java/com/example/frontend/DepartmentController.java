package com.example.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/products")
public class DepartmentController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping()
    public String getCountries(Model model){

        //http://api:3000/externalrestapi/testresource
        //String url = ""
        //String url = "https://jsonplaceholder.typicode.com/posts"; //För att kommunicera med docker
        String url = "http://api:8088/items"; //Docker
        Post[] post = restTemplate.getForObject(url, Post[].class);

        System.out.println(post);
        List <String> titlar = Arrays.stream(post).map(Post::getName).toList();
        System.out.println(titlar);

        String giveMeText = titlar.get(0);
       /* String giveMeText1 = titlar.get(1);
        String giveMeText2 = titlar.get(2);

        */

        model.addAttribute("title", titlar);
        return "index";
    }
}
