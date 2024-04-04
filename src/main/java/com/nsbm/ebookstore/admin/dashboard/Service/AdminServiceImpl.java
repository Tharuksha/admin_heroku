package com.nsbm.ebookstore.admin.dashboard.Service;

import com.nsbm.ebookstore.admin.dashboard.Repository.AdminRepository;
import com.nsbm.ebookstore.admin.dashboard.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Users> getAllUsers() {
        return adminRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    @Override
    public Users saveUser(Users user) {
        return adminRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Users> getAdminUsers() {
        return adminRepository.findByRole("admin");
    }
}
