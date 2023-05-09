package com.practice.admin;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.practice.models.CommonResponse;
import com.practice.models.UserModel;
import com.practice.services.CRUDOperations;

@Service("admin")
public class AdminServiceImpl implements CRUDOperations{

	@Override
	public CommonResponse<String> create(UserModel userModel) {
		CommonResponse<String> response = new CommonResponse<String>();
		response.setStatusCode(200);
		response.setMessage("AdminCreated");
		response.setResponse("Admin Response");
		return response;
	}

	@Override
	public CommonResponse<Object> get() {
		CommonResponse<Object> response = new CommonResponse<Object>();
		response.setStatusCode(200);
		response.setMessage("AdminGet");
		response.setResponse("Admin Response");
		return response;
	}

	@Override
	public boolean create(String employee, MultipartFile document) {
		// TODO Auto-generated method stub
		return false;
	}

}
