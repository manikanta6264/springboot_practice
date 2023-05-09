package com.practice.english;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entities.LanguageTense;
import com.practice.models.CommonResponse;
import com.practice.models.LanguageTenseModel;
import com.practice.user.SessionUserDetails;

@Service
public class TenseService {
	@Autowired
	private ITenseRepository tenseRepository;
	
	@Autowired
	private SessionUserDetails sessionUser;

	public CommonResponse<Boolean> create(LanguageTenseModel tenseModel) {
		LanguageTense tense = new LanguageTense();
		CommonResponse<Boolean> response = new CommonResponse<Boolean>();
		try {
			BeanUtils.copyProperties(tenseModel, tense);
			tense.setCreatedDate(LocalDateTime.now());
			tense.setModifiedDate(LocalDateTime.now());
			tense.setUserDet(sessionUser.getSessionUser());
			tenseRepository.save(tense);
			response.setMessage("Creation Success");
			response.setResponse(true);
			response.setStatusCode(200);
		} catch(Exception ex) {
			response.setMessage("Creation failed");
			response.setResponse(false);
			response.setStatusCode(500);
		}
		return response;
	}

	public CommonResponse<List<LanguageTenseModel>> getAll() {
		CommonResponse<List<LanguageTenseModel>> response = new CommonResponse<List<LanguageTenseModel>>();
		List<LanguageTenseModel> tenseList = new ArrayList<LanguageTenseModel>();
		try {
			List<LanguageTense> tesnses = tenseRepository.findByUserDet(sessionUser.getSessionUser());
			tenseList = tesnses.stream().map((Function<? super LanguageTense, ? extends LanguageTenseModel>) data ->{
				LanguageTenseModel tense = new LanguageTenseModel();
				BeanUtils.copyProperties(data, tense);
				return tense;
			}).collect(Collectors.toList());
			response.setMessage("Fetching Success");
			response.setResponse(tenseList);
			response.setStatusCode(200);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return response;
	}

}
