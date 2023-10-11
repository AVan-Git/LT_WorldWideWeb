package vn.edu.iuh.fit.se;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.se.entity.Department;
import vn.edu.iuh.fit.se.entity.Employee;
import vn.edu.iuh.fit.se.repositories.DepartmentRepository;
import vn.edu.iuh.fit.se.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoSpringbootJpaMariadbApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	private static final Logger log = LoggerFactory.getLogger(DemoSpringbootJpaMariadbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootJpaMariadbApplication.class, args);
	}

	//Test
	@Bean
	public CommandLineRunner sampleRecord (){
		return args -> {
			Department department1 = new Department("Khoa Cong nghe thong tin");
			Department department2 = new Department("Khoa tri tue nhan tao");
			Department department3 = new Department("Khoa he thong thon tin");
			departmentRepository.save(department1);

			for (int i = 0; i < 10; i++) {
				Employee e = new Employee("name #"+i);
				e.setDepartment(department1);
				employeeRepository.save(e);
			}

//			departmentRepository.save(department1);
			departmentRepository.save(department2);
			departmentRepository.save(department3);

			System.out.println("Start text_01()");
			departmentRepository.findAll().forEach(System.out::println);
			employeeRepository.findAll().forEach(System.out::println);
		};
	}

}
