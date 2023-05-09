package com.practice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practice.models.CommonResponse;
import com.practice.models.UserModel;

@Service
public interface CRUDOperations {
	public CommonResponse<String> create(UserModel userModel);
	public CommonResponse<Object> get();
	public boolean create(String employee, MultipartFile document);
}
