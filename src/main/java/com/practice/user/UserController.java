package com.practice.user;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.entities.QuestionAndAnswers;
import com.practice.models.CommonResponse;
import com.practice.models.QuestonsModel;
import com.practice.models.UserModel;
import com.practice.services.CRUDOperations;

@RestController
@RequestMapping("user/")
public class UserController {

	@Autowired
	@Qualifier("user")
	CRUDOperations userCRUDOperations;
	
	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/user-create")
	public CommonResponse<String> createUser(@RequestBody UserModel userModel) {
		return userCRUDOperations.create(userModel);
	}
	
	@GetMapping("/get-logged-in-user")
	public CommonResponse<Object> getUser() {
		System.out.println("Test User");
		return userCRUDOperations.get();
	}
	
	@PostMapping("/save-audio")
	public boolean saveEmployee(@RequestPart String question, @RequestPart MultipartFile file) {
	    return userCRUDOperations.create(question, file);
	}
	
	@GetMapping("/getAllQuestions")
	public List<QuestonsModel> getALlQuestions() {
	    return userService.getAllQuestions();
	}
	
	
	 @GetMapping("/downloadFile/{fileId}")
	    public ResponseEntity<AudioInputStream> downloadFile(@PathVariable int fileId) {
	        // Load file from database
		 QuestionAndAnswers dbFile = userService.getFile(fileId);

		 ByteArrayInputStream baiut = new ByteArrayInputStream(dbFile.getAnswer());
		    AudioInputStream stream = null;
		    try {
		        stream = AudioSystem.getAudioInputStream(baiut);
		    } catch (UnsupportedAudioFileException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
//		 Base64 codec = new Base64();
//		 String encoded = "data:audio/wav;base64,"+codec.encodeBase64String(dbFile.getAnswer());
//		return encoded;
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
	                .body(stream);
	    }
	
	
}
