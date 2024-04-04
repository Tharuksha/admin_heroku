package com.nsbm.ebookstore.admin.dashboard.Service;

import com.nsbm.ebookstore.admin.dashboard.Entity.Users;

import java.util.List;

public interface AdminService {
    List<Users> getAllUsers();
    Users getUserById(Long id);
    Users saveUser(Users user);
    boolean deleteUser(Long id);
    List<Users> getAdminUsers();
}
