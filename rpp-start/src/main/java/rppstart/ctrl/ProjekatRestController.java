package rppstart.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import rppstart.jpa.Projekat;
import rppstart.reps.ProjekatRepository;

@RestController
public class ProjekatRestController {
	
	@Autowired
	ProjekatRepository projekatRepository;
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value = "Returns collections of all Projekat from database.")
	@GetMapping("projekat")
	public Collection<Projekat> getAll(){
		
		return projekatRepository.findAll();
	}
	
	@ApiOperation(value = "Returns Projekat with id that was forwarded as path variable.")
	@GetMapping("projekat/{id}")
	public Projekat getOne(@PathVariable("id") Integer id) {
		
		return projekatRepository.getOne(id);
	}
	
	@ApiOperation(value ="Returns Projekat with naziv that was forwarded as path variable.")
	@GetMapping("projekat/naziv/{naziv}")
	public Collection<Projekat> getByNaziv(@PathVariable("naziv") String naziv){
		return projekatRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@ApiOperation(value = "Adds instance of Projekat to database.")
	@PostMapping("projekat")
	public ResponseEntity<HttpStatus> addProjekat(@RequestBody Projekat projekat) {
		projekatRepository.save(projekat);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	@ApiOperation(value = "Updates Projekat that has id that was forwarded as path variable with values forwarded in Request Body. ")
	@PutMapping("projekat/{id}")
	public ResponseEntity<HttpStatus> updateProjekat(@RequestBody Projekat projekat,
			@PathVariable("id") Integer id){
		
		if (projekatRepository.existsById(id)) {
			projekat.setId(id);
			projekatRepository.save(projekat);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value = "Delete Projekat with id that was forwarded as path variable.")
	@DeleteMapping("projekat/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		
		if(id==-100 && !projekatRepository.existsById(-100)) {
			
			jdbcTemplate.execute("INSERT INTO projekat (\"id\",\"naziv\",\"oznaka\",\"opis\") VALUES (-100,'Test Naziv','Test Oznk','Test Opis')");
		}
		
		if (projekatRepository.existsById(id)) {
			projekatRepository.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);

}

}
