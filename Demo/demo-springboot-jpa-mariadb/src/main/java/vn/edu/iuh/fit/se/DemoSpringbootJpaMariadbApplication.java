package vn.edu.iuh.fit.se;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.se.entity.Department;
import vn.edu.iuh.fit.se.entity.Employee;
import vn.edu.iuh.fit.se.repositories.DepartmentRepository;
import vn.edu.iuh.fit.se.repositories.EmployeeRepository;
import vn.edu.iuh.fit.se.service.EmployeeService;
import vn.edu.iuh.fit.se.service.impl.DepartmentServiceImpl;
import vn.edu.iuh.fit.se.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DemoSpringbootJpaMariadbApplication {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private DepartmentServiceImpl departmentService;

	private static final Logger log = LoggerFactory.getLogger(DemoSpringbootJpaMariadbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootJpaMariadbApplication.class, args);
	}

	//Test
//	@Bean
	public CommandLineRunner sampleRecord (){
		return args -> {
			Random rand = new Random();

			Department department1 = new Department("Khoa Cong nghe thong tin");
			Department department2 = new Department("Khoa tri tue nhan tao");
			Department department3 = new Department("Khoa he thong thon tin");
//			departmentRepository.save(department1);
//			department3.setId(3L);
			long id = rand.nextLong(3);
			for (int i = 200; i < 220; i++) {
				Employee e = new Employee("name #"+i);
				department3.setId(rand.nextLong(3)+1);
				e.setDepartment(department3);
				employeeService.insert(e);
			}

//			departmentRepository.save(department1);
//			departmentRepository.save(department2);
//			departmentRepository.save(department3);

			System.out.println("Start text_01()");
			departmentService.findAll().forEach(System.out::println);
			employeeService.findAll().forEach(System.out::println);
		};
	}

}
