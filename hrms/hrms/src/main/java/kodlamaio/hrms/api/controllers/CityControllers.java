package kodlamaio.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
public class CityControllers {

	private CityService cityService;

	public CityControllers(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody City city) {
		return ResponseEntity.ok(this.cityService.add(city));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int cityId) {
		return ResponseEntity.ok(this.cityService.delete(cityId));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody City city) {
		return ResponseEntity.ok(this.cityService.update(city));

	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.cityService.getAll());
	}

}
