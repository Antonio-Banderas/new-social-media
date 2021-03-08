package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.services.PostAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class SocialMediaController {

    // ---------- Zzztufff ---------- //

    PostAnalysisService postService = new PostAnalysisService();

    // ----------  Aux. endpoints  ---------- //

    @GetMapping(value = "/index")
    public String renderIndex() {
        return "index";
    }

    // ----------  Submit post  ---------- //

    // Get-mapping //
    @GetMapping(value = "/submit")
    public String renderForm() {
        return "form";
    }

    // Post-mapping //
    @PostMapping("/create-post")
    public String createPost
    (@RequestParam("title") String title,
     @RequestParam("price") int price,
    RedirectAttributes attributes) {

        attributes.addAttribute("title", title);
        attributes.addAttribute("price", price);

        Post tmp = new Post(title, price);
        postService.addPost(tmp);

        return "redirect:/post-success";
    }

    // Redirect to success //
    @GetMapping("/post-success")
    @ResponseBody
    public String createProductPageSuccess
    (@RequestParam String title,
     @RequestParam int price) {
        return "Success! You created: " + title + " " + price;
    }


    // ----------  Dashboard  ---------- //

    @GetMapping("/dashboard")
    public String renderDashboard(Model model) {

        ArrayList postsArray = postService.getAllPostsAsPost();

        model.addAttribute("post",postsArray);

        return "dashboard";
    }

}
