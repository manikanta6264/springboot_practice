package com.practice.english;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.models.CommonResponse;
import com.practice.models.LanguageTenseModel;

@RestController
@RequestMapping("language/")
public class LanguageTensesController {

	@Autowired
	private TenseService tenseService;
	
	@PostMapping("/tense/create")
	public CommonResponse<Boolean> createTense(@RequestBody LanguageTenseModel tenseModel) {
		return tenseService.create(tenseModel);
	}
	
	@GetMapping("/tense/get/all")
	public CommonResponse<List<LanguageTenseModel>> getTense() {
		return tenseService.getAll();
	}
}
