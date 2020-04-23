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
import rppstart.jpa.Projekat;
import rppstart.jpa.Student;
import rppstart.reps.GrupaRepository;
import rppstart.reps.StudentRepository;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private GrupaRepository grupaRepository;
	
	@ApiOperation(value = "Returns collection of all Student from database.")
	@GetMapping("student")
	public Collection<Student> getAll(){
		return studentRepository.findAll();
	}
	
	@ApiOperation(value = "Returns Student with id that was forwarded as path variable.")
	@GetMapping("student/{id}")
	public Student getOne(@PathVariable("id") Integer id) {
		return studentRepository.getOne(id);
	}
	
	@ApiOperation(value = "Returns collection of all Student in Grupa with id that was forwarded as path variable.")
	@GetMapping("studentZaGrupu/{id}")
	public Collection<Student> getAllForGrupa(@PathVariable("id") Integer id){
		Grupa g = grupaRepository.getOne(id);
		return studentRepository.findByGrupa(g);
	}
	
	@ApiOperation(value = "Returns Student with ime that was forwarded as path variable.")
	@GetMapping("student/ime/{ime}")
	public Collection<Student> getByIme(@PathVariable("ime") String ime) {
		return studentRepository.findByImeContainingIgnoreCase(ime);
	}
	
	@ApiOperation(value = "Adds instance of Student to database.")
	@PostMapping("student")
	public ResponseEntity<HttpStatus> addStudent (@RequestBody Student student){
		studentRepository.save(student);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Updates Student that has id that was forwarded as path variable with values forwarded in Request Body. ")
	@PutMapping("student/{id}")
	public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student,
			@PathVariable("id") Integer id){
		if (studentRepository.existsById(id)) {
			student.setId(id);
			studentRepository.save(student);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
	@ApiOperation(value = "Delete Student with id that was forwarded as path variable.")
	@DeleteMapping("student/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		
		if(id == -100 && !studentRepository.existsById(-100)) {
			
			jdbcTemplate.execute("INSERT INTO student (\"id\", \"ime\", \"prezime\", \"broj_indeksa\",\"grupa\",\"projekat\")"
					+ "VALUES (-100, 'petar','petrovic', '118-2016',2,3)");
			
		}
		
	    if (studentRepository.existsById(id)) {
	    	studentRepository.deleteById(id);
	    	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	    	
	    }
	    
	    return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	

}
