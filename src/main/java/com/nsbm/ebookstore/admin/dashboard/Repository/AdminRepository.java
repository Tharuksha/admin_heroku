package com.nsbm.ebookstore.admin.dashboard.Repository;

import com.nsbm.ebookstore.admin.dashboard.Entity.DashboardUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<DashboardUsers, Long> {

    @Query("SELECT u FROM DashboardUsers u WHERE u.role = 'admin'")
    List<DashboardUsers> findByRole();
}
