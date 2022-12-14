package com.backend.onlinecvproject.controllers;

import com.backend.onlinecvproject.entities.Admin;
import com.backend.onlinecvproject.requests.AdminCreateRequest;
import com.backend.onlinecvproject.requests.AdminUpdateRequest;
import com.backend.onlinecvproject.responses.AdminViewResponse;
import com.backend.onlinecvproject.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<AdminViewResponse> getAdmins(){
        return this.adminService.getall();
    }

    @PostMapping
    public Admin add(@RequestBody AdminCreateRequest admin){
        return this.adminService.add(admin);
    }

    @PutMapping("/{adminId}")
    public Admin update(@PathVariable int adminId,@RequestBody AdminUpdateRequest updatedAdmin){
        return this.adminService.update(adminId,updatedAdmin);
    }

    @DeleteMapping("/{adminId}")
    public void delete(@PathVariable int adminId) {
        this.adminService.delete(adminId);
    }
}
