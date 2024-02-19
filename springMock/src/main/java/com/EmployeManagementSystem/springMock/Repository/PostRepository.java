package com.EmployeManagementSystem.springMock.Repository;

import com.EmployeManagementSystem.springMock.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
