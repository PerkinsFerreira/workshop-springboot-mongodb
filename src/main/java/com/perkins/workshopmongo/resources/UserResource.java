package com.perkins.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perkins.workshopmongo.domain.User;
import com.perkins.workshopmongo.dto.UserDTO;
import com.perkins.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	//@GetMapping
	public ResponseEntity<List<UserDTO>> findALL(){
		List<User> lista = service.findAll();
		List<UserDTO> listaDto = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	//@GetMapping
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
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
