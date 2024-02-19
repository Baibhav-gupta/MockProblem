package com.EmployeManagementSystem.springMock.Service;

import com.EmployeManagementSystem.springMock.Model.Notification;
import com.EmployeManagementSystem.springMock.Model.Post;
import com.EmployeManagementSystem.springMock.Model.User;
import com.EmployeManagementSystem.springMock.Repository.NotificationRepository;
import com.EmployeManagementSystem.springMock.Repository.PostRepository;
import com.EmployeManagementSystem.springMock.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    public String addPost(Post post)
    {
        postRepository.save(post);
        return " Post has been saved to db";
    }
    public String updatePost(Post post)
    {
        postRepository.save(post);
        return " Post has been updated to db";
//        Notification notification =Notification.builder()
//                .time(post.getTime())
//                .postId(post.getPostId())
//                .build();
//        post.getNotificationList().add(notification);
    }
    public String likeInc(Integer postId, LocalTime time) throws Exception
    {
       Optional<Post> optionalPost= postRepository.findById(postId);
       if(!optionalPost.isPresent())
       {
           throw new Exception("Post not found");
       }
       Post post=optionalPost.get();//3 rd api .
       int like=post.getLikes();
       post.setLikes(like+1);// 3rd api finished
        LocalTime currTime;// how to set time

       //now save notification each time post is liked
        Notification notification=Notification.builder()
                .time(time)
                .post(post)
                .postId(postId)
                .build();
        notificationRepository.save(notification);
        post.getNotificationList().add(notification);

        postRepository.save(post);// for 3
        User user=post.getUser();
        user.getPostList().add(post);
        userRepository.save(user);
       return "Post's Like updated successfull";

    }

}
