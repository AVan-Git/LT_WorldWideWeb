package vn.edu.iuh.fit.se;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.se.entity.Department;
import vn.edu.iuh.fit.se.entity.Employee;
import vn.edu.iuh.fit.se.repositories.DepartmentRepository;
import vn.edu.iuh.fit.se.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoSpringbootJpaMariadbApplicationTests {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostConstruct
    void init() {
        Department department1 = new Department("Khoa Cong nghe thong tin");
        Department department2 = new Department("Khoa tri tue nhan tao");
        Department department3 = new Department("Khoa he thong thon tin");
        departmentRepository.save(department1);
//        List<Employee> lst = department1.getEmployeeList();
        List<Employee> lst = new ArrayList<>();

			for (int i = 0; i < 10; i++) {
                Employee e = new Employee("name #"+i );
                e.setDepartment(department1);
                employeeRepository.save(e);
                lst.add(e);
			}
//        department1.setEmployeeList(lst);

        departmentRepository.save(department2);
        departmentRepository.save(department3);
    }
    @Test
    void text_01() {
//        System.out.println("Start text_01()");
//        departmentRepository.findAll().forEach(System.out::println);
//        employeeRepository.findAll().forEach(System.out::println);
//        Optional<Department> demp = departmentRepository.findById(2L);
//        if (demp.isPresent()) System.out.println(demp.get());
    }

}
