package com.perkins.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perkins.workshopmongo.domain.User;
import com.perkins.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	//@GetMapping
	public ResponseEntity<List<User>> findALL(){
		List<User> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	/*
	 * @RequestMapping(method=RequestMethod.GET, path="/teste") //@GetMapping public
	 * ResponseEntity<List<User>> findALL2(){ User maria = new User("1",
	 * "Maria Brown", "maria@gmail.com"); User alex = new User("2", "Alex Green",
	 * "alex@gmail.com"); List<User> lista = new ArrayList<>();
	 * lista.addAll(Arrays.asList(maria, alex)); return
	 * ResponseEntity.ok().body(lista); }
	 */

}