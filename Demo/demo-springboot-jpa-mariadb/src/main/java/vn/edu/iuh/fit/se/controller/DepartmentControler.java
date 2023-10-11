package vn.edu.iuh.fit.se.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.se.entity.Department;
import vn.edu.iuh.fit.se.service.impl.DepartmentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentControler {

    @Autowired
    private DepartmentServiceImpl service;
    @GetMapping("")
    public String myHome() {
        return "home";
    }
    @GetMapping("/departments")
    public List<Department> getAll(){
        System.out.println("getAll () --------------------");
        return service.findAll();
    }
}
