package com.EmployeManagementSystem.springMock.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private Integer age;
    @Getter
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> postList=new ArrayList<>();

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
    //user will be only mapped with post's and post will be mapped with notification
    // we can access attribute of notification from post

//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private List<Notification> notificationList=new ArrayList<>();
}
