package com.EmployeManagementSystem.springMock.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "notification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;
    private LocalTime time;
    private Integer postId;// to know notification is from which post
    @ManyToOne
    @JoinColumn
    private Post post;
//    @ManyToOne
//    @JoinColumn
//    private User user;

}
