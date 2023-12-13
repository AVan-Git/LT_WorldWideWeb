package vn.edu.iuh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.entity.Candidate;
import vn.edu.iuh.entity.Experience;
import vn.edu.iuh.entity.enums.Roles;
import vn.edu.iuh.repository.CandidateRepository;
import vn.edu.iuh.repository.ExperienceRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Controller
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ExperienceRepository experienceRepository;
    @GetMapping("/addData")
    public String insertData(){
        Random random = new Random();

        int val_int = random.nextInt();
        Candidate can = new Candidate();
        can.setId(random.nextLong(999999999-100000000));
        can.setFullName("name "+ val_int);
        can.setEmail("email" + val_int + "@gmail.com");
        can.setPhone("" + random.nextLong(999999999-100000000)+1);
        //
        candidateRepository.save(can);
        System.out.println(can);

        for (int i = 0; i< 3 ;i++) {
            int yy = random.nextInt(2023-2019)+2019;
            int mm = random.nextInt(10) + 1;
            int dd = random.nextInt(30) + 1;
            LocalDate localDate = LocalDate.of(2015,11, 12);

            Experience exp1 = new Experience();
            exp1.setCandidate(can);
//            exp1.setRole(Roles.MANAGER);
            exp1.setId(random.nextLong());
            exp1.setCompanyName("Company " + random.nextInt());
            exp1.setFromDate(LocalDate.of(yy,mm, dd));
            exp1.setToDate(LocalDate.of(yy,mm+1, dd));
            exp1.setWorkDescription("Description");

            int val_role = random.nextInt(4) + 1;
            switch (val_role) {
                case 1: {
                    exp1.setRole(Roles.ADMINISTRATION);
                    break;
                }
                case 2: {
                    exp1.setRole(Roles.STAFF);
                    break;
                }
                case 3: {
                    exp1.setRole(Roles.MANAGER);
                    break;
                }
                default:{
                    exp1.setRole(Roles.EXECUTIVE);
                    break;
                }
            }
            //
            experienceRepository.save(exp1);
            System.out.println(exp1);
        }

        return "redirect:/";
    }
    //
    @GetMapping("/list_candidate")
    public String getAllCandidates(Model model) {

        model.addAttribute("candidates", candidateRepository.findAll());

        return "candidates";
    }
    //
    @GetMapping("/detail_can/{id}")
    public String DetailCandiDate(@PathVariable("id") long id, Model model) {

        Candidate can = candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Khong tim thay Candidate co ma: "+ id));

        List<Experience> experiences = experienceRepository.findAllByCandidate(can);
        model.addAttribute("list_exp" , experiences);
        return "candidate-details";
    }
}
