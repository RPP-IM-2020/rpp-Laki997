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
import rppstart.jpa.Grupa;
import rppstart.reps.GrupaRepository;

@RestController
public class GrupaRestController {
	
	@Autowired
	private GrupaRepository grupaRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@ApiOperation(value ="Returns collection of all Grupa from database.")
	@GetMapping("grupa")
	public Collection<Grupa> getGrupe() {
		return grupaRepository.findAll();
	}
	
	@ApiOperation(value = "Returns Grupa with id that was forwarded as path variable.")
	@GetMapping("grupa/{id}")
	public Grupa getGrupa(@PathVariable("id") Integer id) {
		return grupaRepository.getOne(id);
		
	}
	@ApiOperation(value = "Returns Grupa with oznaka that was forwarded as path variable.")
	@GetMapping("grupa/oznaka/{oznaka}")
	public Collection<Grupa> getByOznaka(@PathVariable("oznaka") String oznaka){
		return grupaRepository.findByOznakaContainingIgnoreCase(oznaka);
	}
	
	
	@ApiOperation(value = "Adds instance of Grupa to database.")
	@PostMapping("grupa")
	public ResponseEntity<HttpStatus> addOne(@RequestBody Grupa grupa) {
		grupaRepository.save(grupa);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		
	}
	
	@ApiOperation(value = "Updates Grupa that has id that was forwarded as path variable with values forwarded in Request Body. ")
	@PutMapping("grupa/{id}")
	public ResponseEntity<HttpStatus> update(@RequestBody Grupa grupa,@PathVariable("id") Integer id){
		if (grupaRepository.existsById(id)) {
			grupa.setId(id);
			grupaRepository.save(grupa);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	@ApiOperation(value = "Delete Grupa with id that was forwarded as path variable.")
	@DeleteMapping("grupa/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		
		if (id == -100 && !grupaRepository.existsById(-100)) {
			
			jdbcTemplate.execute("INSERT INTO grupa (\"id\", \"oznaka\", \"smer\") " 
					+ "VALUES (-100, 'T Oznaka', 3)");
		}
		
		if (grupaRepository.existsById(id)) {
		grupaRepository.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

}
	
}
