package com.EmployeManagementSystem.springMock.Repository;

import com.EmployeManagementSystem.springMock.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
