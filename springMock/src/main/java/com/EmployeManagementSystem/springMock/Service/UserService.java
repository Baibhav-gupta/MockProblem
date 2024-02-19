package com.EmployeManagementSystem.springMock.Service;

import com.EmployeManagementSystem.springMock.Model.Post;
import com.EmployeManagementSystem.springMock.Model.User;
import com.EmployeManagementSystem.springMock.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(User user)
    {
        userRepository.save(user);
        return " user is saved to db";
    }
    public User overAllWinner()throws Exception
    {
        List<User> userList=new ArrayList<>();
        userList=userRepository.findAll();
        int maxLike=0;
        int potentialWinnerUserId=-1;
        for(User objUser:userList)
        {
            List<Post> postList=objUser.getPostList();
            for(Post objPost:postList)
            {
                int ckLike=objPost.getLikes();
                if(ckLike>maxLike)
                {
                    maxLike=ckLike;
                    potentialWinnerUserId= objPost.getUserId();
                }
            }
        }
        if(potentialWinnerUserId==-1)
        {
            throw new Exception("no user found");
        }
        User user=userRepository.findById(potentialWinnerUserId).get();
        return user;
    }
}
