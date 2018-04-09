package com.voronin.services;

import com.voronin.domain.Blog;
import com.voronin.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * TODO: comment.
 *
 * @author Alexey Voronin.
 * @since 03.04.2018.
 */
@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog save(final Blog blog) {
        return this.blogRepository.save(blog);
    }

    public Blog getBlogById(final int id) {
        return this.blogRepository.findById(id);
    }

    public List<Blog> getBlogs() {
        return this.blogRepository.findAllByOrderByDateAsc();
    }

    public Blog prepareAndSave(final String title, final String desc, final String content) {
        final Blog blog = new Blog();
        blog.setTitle(title);
        blog.setDescription(desc);
        blog.setContent(content);
        blog.setDate(new Timestamp(System.currentTimeMillis()));
        return blog;
    }
}
