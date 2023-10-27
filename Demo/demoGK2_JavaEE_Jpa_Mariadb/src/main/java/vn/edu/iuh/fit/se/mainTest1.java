package vn.edu.iuh.fit.se;

import vn.edu.iuh.fit.se.model.Candidate;
import vn.edu.iuh.fit.se.model.Experience;
import vn.edu.iuh.fit.se.model.enums.ExperienceRole;
import vn.edu.iuh.fit.se.reponsitories.CandidateReponsitory;
import vn.edu.iuh.fit.se.reponsitories.ExperienceReponsitory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mainTest1 {
    private static CandidateReponsitory candidateReponsitory = new CandidateReponsitory();
    private static ExperienceReponsitory experienceReponsitory = new ExperienceReponsitory();

    public static void main(String[] args) {

        Candidate candidate = new Candidate();
        candidate.setName("Nguyen van A3");
        candidate.setEmail("AVan3@gmail.com");
        candidate.setPhone("0951753003");

//        candidateReponsitory.insert(candidate);

//        Experience exp1 = new Experience();
//        exp1.setCompany("company 5" );
//        exp1.setRole(ExperienceRole.MANAGER);
//        exp1.setFromDate(LocalDate.of(2022, 01, 12));
//        exp1.setToDate(LocalDate.of(2023, 01, 12));
//        exp1.setWordDescription("Description 5");
//        exp1.setCandidate(candidate);

//        Experience exp1 = experienceReponsitory.getById(1);

        Experience exp2 = new Experience();
        exp2.setCompany("company 6" );
        exp2.setRole(ExperienceRole.MANAGER);
        exp2.setFromDate(LocalDate.of(2023, 01, 12));
        exp2.setToDate(LocalDate.of(2024, 01, 12));
        exp2.setWordDescription("Description 6");
        exp2.setCandidate(candidate);
        List<Experience> lst = new ArrayList<>();
//        lst.add(exp1);
        lst.add(exp2);
        candidate.setExperiences(lst);

//        candidateReponsitory.insert(candidate);
//        experienceReponsitory.insert(exp1);
//        experienceReponsitory.insert(exp2);

        candidateReponsitory.getAll().forEach(System.out::println);
        experienceReponsitory.getAll().forEach(System.out::println);

    }
}
