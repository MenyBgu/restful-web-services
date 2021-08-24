package com.in28minutes.rest.webservices.restfulwebservices.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDaoService {
    private static List<Post> posts = new ArrayList<>();
    private static int postsCount = 0;

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        if (post.getPostId() == null) {
            post.setPostId(++postsCount);
        }
        posts.add(post);
        return post;
    }

    public Post findOne(int id) {
        for (Post post : posts) {
            if (post.getPostId() == id) {
                return post;
            }
        }
        return null;
    }
}
