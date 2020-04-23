package rppstart.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rppstart.jpa.Grupa;
import rppstart.jpa.Projekat;
import rppstart.jpa.Smer;
import rppstart.jpa.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Collection<Student> findByGrupa(Grupa g);
	Collection<Student> findByProjekatOrderById(Projekat projekat);
	Collection<Student> findByImeContainingIgnoreCase(String ime);
	
	
	
	

}
