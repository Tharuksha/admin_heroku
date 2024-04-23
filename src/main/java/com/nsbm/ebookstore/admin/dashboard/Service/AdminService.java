package com.nsbm.ebookstore.admin.dashboard.Service;

import com.nsbm.ebookstore.admin.dashboard.Entity.DashboardUsers;

import java.util.List;

public interface AdminService {
    List<DashboardUsers> getAllUsers();
    DashboardUsers getUserById(Long id);
    DashboardUsers saveUser(DashboardUsers user);
    boolean deleteUser(Long id);
    List<DashboardUsers> getAdminUsers();
}
