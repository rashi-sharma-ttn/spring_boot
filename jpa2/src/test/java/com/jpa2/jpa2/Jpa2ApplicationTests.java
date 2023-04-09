package com.jpa2.jpa2;

import com.jpa2.jpa2.componentMapping.Employe;
import com.jpa2.jpa2.componentMapping.EmployeRepo;
import com.jpa2.jpa2.componentMapping.Salary;
import com.jpa2.jpa2.inheritanceMapping.TwoWheeler;
import com.jpa2.jpa2.inheritanceMapping.VehicleRepo;
import com.jpa2.jpa2.jpql_Native.EmpRepo;
import com.jpa2.jpa2.jpql_Native.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Jpa2ApplicationTests {

	@Autowired
	EmpRepo repo;
	@Autowired
	EmployeRepo empRepo;
	@Autowired
	VehicleRepo vehicleRepo;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee emp = new Employee();
		emp.setAge(21);
		emp.setFirstName("Rashi");
		emp.setLastName("Sharma");
		emp.setSalary(50000d);
		repo.save(emp);
	}

	@Test
	public void testFindAllEmployee(){
		List<Object[]> allEmp = repo.findAllEmployee();
		for (Object[] obj : allEmp) {
			System.out.print(obj[0]);
			System.out.println(obj[1]);
		}
	}

	@Test
	public void testUpdateAllEmployeeSalary(){
		repo.updateEmployeeBySalary(4000d,repo.avgSalary());
    }

	@Test
	public void testDeleteEmployee(){
		repo.deleteEmployeeWithMinSalary(repo.minSalary());
	}

	@Test
	public void testFindAllEmployeeLike(){
		List<Object[]> lt = repo.findAllEmployeeLikeNQ();
		for (Object[] obj : lt) {
			System.out.print(obj[0]);
		    System.out.print(obj[1]);
			System.out.println(obj[2]);
		}
	}

	@Test
	public void testDeleteEmployeeByAge(){
		 repo.deleteEmployeeByAge(45);
	}

	//INHERITANCE MAPPING
	@Test
	public void testCreateVehicleEntity(){
		TwoWheeler veh = new TwoWheeler();
		veh.setSpeed(20);
		veh.setVehicleNo("DL-1234S");
		veh.setSeats(2);
		veh.setWheels(2);

		vehicleRepo.save(veh);
	}

	//COMPONENT TESTING
	@Test
	public void testComponentMapping(){
		Employe e = new Employe();
		e.setId(1);
		e.setAge(20);
		e.setFirstName("Rashi");
		e.setLastName("Sharma");
		Salary sal = new Salary();
		sal.setBasicSalary(200000);
		sal.setBonusSalary(3500f);
		sal.setSpecialAllowanceSalary(250.67f);
		sal.setTaxAmount(200.54f);
		e.setSalary(sal);

		empRepo.save(e);
	}

}
