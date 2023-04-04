package com.jpa.jpa;

import com.jpa.jpa.assignment1.Employee;
import com.jpa.jpa.assignment1.empRepo.EmpRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class JpaApplicationTests {

	@Autowired
	EmpRepository empRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee emp = new Employee();
		emp.setAge(23);
		emp.setName("Rashi");
		emp.setId(1);
		emp.setLocation("Delhi");
		empRepo.save(emp);
	}

	@Test
	public void testRead(){
		Employee emp = empRepo.findById(1).get();
		assertNotNull(emp);
		assertEquals("Rashi",emp.getName());
	}

	@Test
	public void testUpdate(){
		Employee emp = empRepo.findById(1).get();
		emp.setLocation("Noida");
		empRepo.save(emp);
	}


	@Test
	public void testDelete(){
		if(empRepo.existsById(1)) {  //  T/F
			empRepo.deleteById(1);
		}
	}

	@Test
	public void testCount(){
		System.out.printf("Total Records - " + empRepo.count());
	}

	@Test
	public void testFindByName(){
		List<Employee> emp = empRepo.findByName("Rashi");
		emp.forEach( p->System.out.printf(p.getName()));
	}

	@Test
	public void testFindByNameLike(){
		List<Employee> emp = empRepo.findByNameLike("A%");
		emp.forEach( p->System.out.printf(p.getName()));
	}

	@Test
	public void testFindByAgeBetween(){
		List<Employee> emp = empRepo.findByAgeBetween(28,32);
		emp.forEach( p->System.out.printf(p.getName()));
	}

	@Test
	public void testPaging(){
		Pageable page = PageRequest.of(0,1,Sort.Direction.DESC,"age");
		empRepo.findAll(page).forEach(p-> System.out.println(p.getName()));
	}

    /*
	@Test
	public void testSorting(){
		empRepo.findByAge(new Sort(Sort.Direction.DESC,"age")).forEach(p->System.out.print(p.getName()));
	}
*/

}
