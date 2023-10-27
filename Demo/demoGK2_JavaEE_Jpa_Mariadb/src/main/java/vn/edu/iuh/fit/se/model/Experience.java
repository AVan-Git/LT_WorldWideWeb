package vn.edu.iuh.fit.se.model;

import jakarta.persistence.*;
import vn.edu.iuh.fit.se.model.enums.ExperienceRole;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "company", length = 120)
    private String company;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "word_desc", length = 400)
    private String wordDescription;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private ExperienceRole role;
}
