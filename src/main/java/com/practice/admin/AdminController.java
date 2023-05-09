package com.practice.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.models.UserModel;

@RestController
@RequestMapping("admin/")
public class AdminController {

	@PostMapping("/admin-create")
	public String createUser(@RequestBody UserModel userModel) {
		return "Admin Created";
	}
	
	@GetMapping("/admin-get")
	public String getUser() {
		return "Get Admin";
	}
}
