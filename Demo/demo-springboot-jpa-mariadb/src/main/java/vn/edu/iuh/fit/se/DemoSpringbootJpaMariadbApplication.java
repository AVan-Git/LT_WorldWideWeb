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

import java.util.List;

@SpringBootApplication
public class DemoSpringbootJpaMariadbApplication {

//	@Autowired
//	private DepartmentRepository departmentRepository;

	private static final Logger log = LoggerFactory.getLogger(DemoSpringbootJpaMariadbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootJpaMariadbApplication.class, args);
	}

	//Test
	public CommandLineRunner sampleRecord (){
		return args -> {
//			Department department1 = new Department("Khoa Cong nghe thong tin");
//			Department department2 = new Department("Khoa tri tue nhan tao");
//			Department department3 = new Department("Khoa he thong thon tin");
//			System.out.println(department3);
//			departmentRepository.save(department3);
//
//			List<Employee> lst = department1.getEmployeeList();
//
//			for (int i = 0; i < 10; i++) {
//				lst.add(new Employee("name #"+i));
//			}

//			departmentRepository.save(department1);
//			departmentRepository.save(department2);

		};
	}

}
