package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmailActivationService;

import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/emailActivationControllers")
public class EmailActivationControllers {

	private EmailActivationService activationService;

	@Autowired
	public EmailActivationControllers(EmailActivationService activationService) {
		super();
		this.activationService = activationService;
	}

	@PostMapping("/activateEmail")
	public ResponseEntity<?> activate(@RequestParam String activationCode, @RequestBody User user) {

		return ResponseEntity.ok(this.activationService.activate(activationCode, user));
	}

	@GetMapping("/getById")
	public ResponseEntity<?> get(@RequestParam int id) {
		return ResponseEntity.ok(this.activationService.get(id));

	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.activationService.getAll());
	}

}
