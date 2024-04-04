package com.nsbm.ebookstore.admin.dashboard.Repository;

import com.nsbm.ebookstore.admin.dashboard.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.role = ?1")
    List<Users> findByRole(String role);
}
