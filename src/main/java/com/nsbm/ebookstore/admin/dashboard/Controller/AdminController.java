package com.nsbm.ebookstore.admin.dashboard.Controller;

import com.nsbm.ebookstore.admin.dashboard.Entity.Users;
import com.nsbm.ebookstore.admin.dashboard.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/api/users")
public class AdminController {

    private static final String ADMIN_ENDPOINT = "/admins";
    private static final String ID_PARAM = "/{id}";
    private static final String USER_DELETED_MESSAGE = "User with ID %d deleted successfully";

    @Autowired
    private AdminService adminService;

    @GetMapping(ADMIN_ENDPOINT)
    public ResponseEntity<List<Users>> getAdminUsers() {
        List<Users> adminUsers = adminService.getAdminUsers();
        return ResponseEntity.ok(adminUsers);
    }

    @GetMapping(ID_PARAM)
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id) {
        Users user = adminService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PutMapping(ID_PARAM)
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long id, @Valid @RequestBody Users user) {
        Users existingUser = adminService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        // Update fields other than password
        existingUser.setEmail(user.getEmail());
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getFirstname() != null && !user.getFirstname().isEmpty()) {
            existingUser.setFirstname(user.getFirstname());
        }
        if (user.getLastname() != null && !user.getLastname().isEmpty()) {
            existingUser.setLastname(user.getLastname());
        }
        existingUser.setUserid(id); // Convert Long to Integer if necessary
        Users updatedUser = adminService.saveUser(existingUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(ID_PARAM)
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        boolean deleted = adminService.deleteUser(id);
        return deleted ? ResponseEntity.ok(String.format(USER_DELETED_MESSAGE, id))
                : ResponseEntity.notFound().build();
    }
}
