package vn.edu.iuh.fit.se.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
//@ToString
//@Data
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "emp_name", nullable = false)
    @NonNull
    private String name;
    private LocalDate dob;

    //JPA

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "dep_id")
    private  Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
//                ", department=" + department.getId() +
                '}';
    }
}
