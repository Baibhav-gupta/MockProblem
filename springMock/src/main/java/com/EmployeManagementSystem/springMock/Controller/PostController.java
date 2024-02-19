package com.EmployeManagementSystem.springMock.Controller;

import com.EmployeManagementSystem.springMock.Model.Post;
import com.EmployeManagementSystem.springMock.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/add")
    public String addPost(@RequestBody Post post)
    {
       return postService.addPost(post);
    }
    @PutMapping("/updatelike")
    public String updatePost(@RequestBody Post post)
    {
        return postService.updatePost(post);
        // whenever you update like  save notification
    }
    @PutMapping("/likeinc/{postId}/{time}")
    public String likeInc(@PathVariable("postId") Integer postId,
                          @PathVariable("time")LocalTime time)throws Exception
    {
       return postService.likeInc(postId,time);
    }
}
