package rppstart.ctrl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import rppstart.jpa.Smer;
import rppstart.reps.SmerRepository;

@RestController
public class SmerRestController {
	
	@Autowired
	private SmerRepository smerRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@ApiOperation(value ="Returns collection of all Smer from database.")
	@GetMapping("smer")
	public Collection<Smer> getAll(){
		return smerRepository.findAll();
	}
	
	@CrossOrigin
	@ApiOperation(value = "Returns Smer with id that was forwarded as path variable.")
	@GetMapping("smer/{id}")
	public Smer getOne(@PathVariable("id") Integer id) {
		return smerRepository.getOne(id);
	}
	
	@CrossOrigin
	@ApiOperation(value ="Returns Smer with naziv that was forwarded as path variable.")
	@GetMapping("smer/naziv/{naziv}")
	public Collection<Smer> getByNaziv(@PathVariable("naziv") String naziv){
		
		return smerRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Adds instance of Smer to database.")
	@PostMapping("smer")
	public ResponseEntity<HttpStatus> addSmer(@RequestBody Smer smer) {
		
		smerRepository.save(smer);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Updates Smer that has id that was forwarded as path variable with values forwarded in Request Body. ")
	@PutMapping("smer/{id}")
	public ResponseEntity<HttpStatus> updateSmer(@RequestBody Smer smer,
			@PathVariable("id")Integer id){
		if (smerRepository.existsById(id)) {
			smer.setId(id);
			smerRepository.save(smer);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Delete Smer with id that was forwarded as path variable.")
	@DeleteMapping("smer/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
		
		if (id==-100 && !smerRepository.existsById(-100)) {
			
			jdbcTemplate.execute("INSERT INTO smer (\"id\",\"naziv\",\"oznaka\") VALUES (-100,'Test Naziv','Test Oznaka')");
		}
		
		if (smerRepository.existsById(id)) {
			smerRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
