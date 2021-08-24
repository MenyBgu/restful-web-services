package com.in28minutes.rest.webservices.restfulwebservices.post;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService postService;

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPosts() {
        List<Post>posts=postService.findAll();
        if(posts.isEmpty()){
            throw new PostsNotFoundException("no posts found");
        }
        return posts;
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post retrieveUser(@PathVariable int postId) {
        Post post=postService.findOne(postId);
        if(post==null){
            throw new PostsNotFoundException("postId-"+ postId);
        }
        return post;
    }

    //input   details of user
    //output  CREATED & Return the Created URI
    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@RequestBody Post post) {
        Post savedPost = postService.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getPostId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
