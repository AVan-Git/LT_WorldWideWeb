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

    // JPa
    @ManyToOne
    @JoinColumn(name = "can_id",nullable = false )
    private Candidate candidate;

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", wordDescription='" + wordDescription + '\'' +
                ", role=" + role +
//                ", candidate=" + candidate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getWordDescription() {
        return wordDescription;
    }

    public void setWordDescription(String wordDescription) {
        this.wordDescription = wordDescription;
    }

    public ExperienceRole getRole() {
        return role;
    }

    public void setRole(ExperienceRole role) {
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

    public Experience(long id, String company, LocalDate fromDate, LocalDate toDate, String wordDescription, ExperienceRole role, Candidate candidate) {
        this.id = id;
        this.company = company;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.wordDescription = wordDescription;
        this.role = role;
        this.candidate = candidate;
    }
}
