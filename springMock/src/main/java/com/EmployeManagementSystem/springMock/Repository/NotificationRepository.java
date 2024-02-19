package com.EmployeManagementSystem.springMock.Repository;

import com.EmployeManagementSystem.springMock.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
