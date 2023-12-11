package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.entity.User;
import vn.edu.iuh.fit.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String showHome(User user) {
        System.out.println("z");
        return "home";
    }
    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        System.out.println("z");
    return "add-user";
    }
    //
    @PostMapping("/adduser")
    public String addUser(@Validated User user, BindingResult result, Model model) {
        System.out.println(user);
        if(result.hasErrors()) {
            return "add-user";
        }
        userRepository.save(user);

        return "redirect:/index";
    }

    //  ánh xạ cho URL /index
    @GetMapping("/index")
    public String showUserList(Model model) {
        System.out.println("showUserList");
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
    //
    //Trong UserController , chúng ta cũng sẽ có phương thức showUpdateForm() ,
    // phương thức này chịu trách nhiệm tìm  nạp thực thể Người dùng khớp với
    // id được cung cấp  từ cơ sở dữ liệu.
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }
    //
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/index";
    }
}
