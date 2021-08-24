package com.in28minutes.rest.webservices.restfulwebservices.post;

public class Post{
    private String post;
    private Integer postId;

    protected Post() {
    }

    public Post(String post, int id) {
        this.post = post;
        this.postId = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post='" + post + '\'' +
                ", postId=" + postId +
                '}';
    }
}
