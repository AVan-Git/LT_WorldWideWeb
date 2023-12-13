package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.entity.Item;
import vn.edu.iuh.fit.repository.CartRepository;
import vn.edu.iuh.fit.repository.ItemRepository;

@Controller
public class itemController {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/items")
    public String getAllItem(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "item/page-item";
    }
    //
    @GetMapping("/add_item")
    public String insertItem_Form(Item item, Model model) {
        model.addAttribute("carts", cartRepository.findAll());
        return "item/add-item";
    }
    @PostMapping("/add_item")
    public String insertItem(@Validated Item item, Model model) {

        System.out.println(item);

        item.setSumPrice();
        System.out.println(item);
        itemRepository.save(item);

        return "redirect:/item/page-item";

    }

}
