package com.fptu.ecommerce.model.ecommerce;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;


/*
* Class này là 1 class Entity nó sẽ ánh xạ hoặc biến đổi thành Table dưới Database
* */
@Entity
@Table(name = "User") //Nếu không có khai báo này thì mặc định nó sẽ lấy tên Class làm tên table!!!
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    /*
     * Khóa chính của bảng
     * GenerationType.IDENTITY → DB tự tăng ID (auto increment)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Email của người dùng
     * unique = true → không cho trùng
     * nullable = false → bắt buộc có giá trị
     */
    @Column(nullable = false, unique = true)
    private String email;

    /*
     * Mật khẩu đã được hash (không lưu plain text)
     */
    @Column(nullable = false)
    private String password;

    /*
     * Vai trò người dùng: USER / ADMIN...
     */
    @Column(nullable = false)
    private String role;

    /*
     * Thời điểm tạo tài khoản
     * Instant → thời gian chuẩn UTC (tốt cho hệ thống backend)
     * updatable = false → không cho update sau khi tạo
     * @CreationTimestamp → Hibernate tự set thời gian khi insert
     */
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

}
