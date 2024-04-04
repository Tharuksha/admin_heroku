package com.nsbm.ebookstore.admin.dashboard.Controller;

import com.nsbm.ebookstore.admin.dashboard.Entity.Users;
import com.nsbm.ebookstore.admin.dashboard.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/users")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public ResponseEntity<List<Users>> getAdminUsers() {
        List<Users> adminUsers = adminService.getAdminUsers();
        return new ResponseEntity<>(adminUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id) {
        Users user = adminService.getUserById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long id, @RequestBody Users user) {
        Users existingUser = adminService.getUserById(id);
        if (existingUser != null) {
            // Update fields other than password
            existingUser.setEmail(user.getEmail());
            // Check if the password is provided in the request
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                existingUser.setPassword(user.getPassword());
            }
            existingUser.setUserid(id); // Convert Long to Integer if necessary
            Users updatedUser = adminService.saveUser(existingUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean deleted = adminService.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>("User with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
