package com.EmployeManagementSystem.springMock.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private Integer userId;// to know whose post it is
    private LocalTime time;
    private Integer likes;
    // post is parent and notification is his child
    // one post can have multiple notification
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Notification> notificationList=new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private User user;
}
//    Create a social media platform,
//        User = UserId, Name, Age, List<Post>, List<Notification>
//Post = PostId, Time, User, Like;
//        Notification = Post, Time
//
//        Description: A user will create a post and will receive notification wrt the post (for likes).
//
//        POST API - Add a User
//        POST API - Add a Post under given user
//
//        PUT API - Like a given post
//        POST API - Send a notification each time a post is liked
//        GET API - Find the user who got most overall likes over all posts