package vn.edu.iuh.fit.se.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private  long id;
    @Column(name = "full_name", nullable = false)
    private String name;
    @Column(name = "phone", length = 15, unique = true)
    private String phone;
    @Column(name = "email", unique = true)
    private String email;
    // jpa

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.PERSIST)
    private List<Experience> experiences;

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public Candidate() {
    }

    public Candidate(long id, String name, String phone, String email, List<Experience> experiences) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.experiences = experiences;
    }
}
