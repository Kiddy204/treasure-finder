package ma.Kiddy204.treasurefinder.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.Kiddy204.treasurefinder.domain.UserVo;
import ma.Kiddy204.treasurefinder.service.IUserService;

@RestController
public class UserRestController {

	@Autowired
	private IUserService service;

	@GetMapping(value = "/rest/User", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserVo> getAll() {
		return service.getUsers();
	}

	@GetMapping(value = "/rest/User/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable(value = "id") Long UserVoId) {
		UserVo UserVoFound = service.getUserById(UserVoId); 
		if (UserVoFound == null)
			return new ResponseEntity<>("User doen't exist", HttpStatus.OK); 
		return new ResponseEntity<>(UserVoFound, HttpStatus.OK);
	}
	
	@PostMapping(value = "/rest/User")
	public ResponseEntity<Object> createUser(/*@Valid*/ @RequestBody UserVo UserVo) {
		service.save(UserVo);
		return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/rest/User/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(name = "id") Long UserVoId, @RequestBody UserVo UserVo) {
		UserVo UserVoFound = service.getUserById(UserVoId); if (UserVoFound == null)
			return new ResponseEntity<>("User doen't exist", HttpStatus.OK); UserVo.setId(UserVoId);
			service.save(UserVo);
			return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
	}
	
	public ResponseEntity<Object> deleteUser(@PathVariable(name = "id") Long UserVoId) {
		UserVo UserVoFound = service.getUserById(UserVoId); if (UserVoFound == null)
			return new ResponseEntity<>("User doen't exist", HttpStatus.OK); service.delete(UserVoId);
			return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
	}

	@GetMapping(
			value = "/rest/sort/{fieldName}", 
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<UserVo> sortBy(@PathVariable String fieldName) { 
		return service.sortBy(fieldName);
	}

	@GetMapping("/rest/pagination/{pageid}/{size}")
	public List<UserVo> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
		return service.findAll(pageid, size); 
	}
}

