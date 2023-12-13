package vn.edu.iuh.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    // JPA
    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
//                ", experiences=" + experiences +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public List<Experience> getExperiences() {
//        return experiences;
//    }
//
//    public void setExperiences(List<Experience> experiences) {
//        this.experiences = experiences;
//    }

    public Candidate() {
    }

    public Candidate(long id, String fullName, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public Candidate(long id, String fullName, String phone, String email, List<Experience> experiences) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.experiences = experiences;
    }
}
