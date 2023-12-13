package vn.edu.iuh.entity;

import jakarta.persistence.*;
import vn.edu.iuh.entity.enums.Roles;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "company", length = 120)
    private String companyName;
    @Column(name = "work_des", length = 400)
    private String workDescription;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "role")
    private Roles role;
    // JPA
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    //

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", role=" + role +
                ", candidate=" + candidate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Experience() {
    }

    public Experience(long id, String companyName, String workDescription, LocalDate fromDate, LocalDate toDate, Roles role, Candidate candidate) {
        this.id = id;
        this.companyName = companyName;
        this.workDescription = workDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.role = role;
        this.candidate = candidate;
    }
}
