package com.voronin.controller;

import com.voronin.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Blog controller.
 *
 * @author Alexey Voronin.
 * @since 02.04.2018.
 */
@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/blog")
    public ModelAndView getBlogPage() {
        final ModelAndView view = new ModelAndView("blog");
        view.addObject("blogs", this.blogService.getBlogs());
        return view;
    }

    @RequestMapping("/blog-id/{blogId}")
    public ModelAndView getBlogById(@PathVariable final int blogId) {
        final ModelAndView view = new ModelAndView("current-blog");
        view.addObject("blog", this.blogService.getBlogById(blogId));
        return view;
    }

    @RequestMapping("/create-blog")
    public ModelAndView createBlog(@RequestParam final String title, @RequestParam final String desc,
                                   @RequestParam final String content) {
        this.blogService.save(this.blogService.prepareAndSave(title, desc, content));
        return new ModelAndView("redirect:/blog");
    }
}
