package com.practice.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.practice.entities.QuestionAndAnswers;
import com.practice.entities.Roles;
import com.practice.entities.UserDet;
import com.practice.models.CommonResponse;
import com.practice.models.QuestonsModel;
import com.practice.models.UserModel;
import com.practice.repositories.IUserRepository;
import com.practice.repositories.QuestionAndAnswersRepository;
import com.practice.services.CRUDOperations;
import com.practice.util.AppConstants;

@Service("user")
public class UserServiceImpl implements CRUDOperations{

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private SessionUserDetails sessionUser;
	
	@Autowired
	private PasswordEncoder psdEncoder;
	
	@Autowired
	private QuestionAndAnswersRepository questRepo;

	
	@Override
	public CommonResponse<String> create(UserModel userModel) {
		UserDet userDet = new UserDet();
		if(userModel != null) {
			BeanUtils.copyProperties(userModel, userDet);
		}
		Set<Roles> roles = new HashSet<Roles>();
		if(userModel != null && userModel.getRoles() != null) {
			for(String role: userModel.getRoles()) {
				Roles roleDet = new Roles();
				roleDet.setUserName(userModel.getUserEmail());
					for(String roleName: AppConstants.ROLES) {
						if(roleName.equalsIgnoreCase(role)) {
							roleDet.setRole(roleName);
							break;
						}
					}
					roleDet.setUserDet(userDet);
					roles.add(roleDet);
			}
		}
		userDet.setRoles(roles);
		userDet.setPassword(psdEncoder.encode(userModel.getPassword()));
		
		userRepo.save(userDet);
		
		CommonResponse<String> response = new CommonResponse<String>();
		response.setStatusCode(200);
		response.setMessage("UserCreated");
		response.setResponse(userModel.getUserEmail()+" Account created ");
		return response;
	}

	@Override
	public CommonResponse<Object> get() {
		Function<Roles, String> role  = role1 -> {
			return role1.getRole();
		};
		CommonResponse<Object> response = new CommonResponse<Object>();
		UserDet userDet= sessionUser.getSessionUser();
		Set<Roles> roles = userDet.getRoles();
		List<String> roelIst =  new ArrayList<String>();
		roelIst = roles.stream().map(role).collect(Collectors.toList());
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userDet, userModel);
		userModel.setPassword(null);
		userModel.setRoles(roelIst);
		response.setStatusCode(200);
		response.setMessage("User getting success");
		response.setResponse(userModel);
		return response;
	}

	@Override
	public boolean create(String question, MultipartFile file) {
		 // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            QuestionAndAnswers dbFile = new QuestionAndAnswers(question, fileName,file.getContentType(), file.getBytes());

            questRepo.save(dbFile);
            return true;
        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
		return false;
	}

	public QuestionAndAnswers getFile(int fileId) {
		return questRepo.findById(fileId).get();
	}

	public List<QuestonsModel> getAllQuestions() {
		Function<QuestionAndAnswers, QuestonsModel> fun = (question) ->{
			QuestonsModel model = new QuestonsModel();
			BeanUtils.copyProperties(question, model);
			return model;
		};
		return questRepo.findAll().stream().map(fun).collect(Collectors.toList());
	}

}
