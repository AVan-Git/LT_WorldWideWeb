package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.entity.Cart;
import vn.edu.iuh.fit.repository.CartRepository;

import java.time.LocalDate;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    //
    @GetMapping("/carts")
    public String getDsCart(Model model) {
        model.addAttribute("carts", cartRepository.findAll());
        return "cart/page-cart";
    }

    //
    @GetMapping("/add_cart")
    public String formAddCart(Cart cart) {
        return "cart/add-cart";
    }

    @PostMapping("/add_cart")
    public String addCart(@Validated Cart cart, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cart/add-cart";
        }
        cart.setDateAdd(LocalDate.now());
        cartRepository.save(cart);

        return "redirect:/carts";
    }

    //
    @GetMapping("/update_cart/{id}")
    public String formEditCart(@PathVariable("id") long id, Model model) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cart id: " + id));

        model.addAttribute("cart", cart);
        return "cart/edit-cart";
    }

    @PostMapping("/update_cart/{id}")
    public String editCart(@PathVariable("id") long id, @Validated Cart cart, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cart/edit-cart";
        }
        Cart cartnew = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid cart id: " + id));
        cartnew.setDateUpdate(LocalDate.now());
        cartnew.setIdUser(cart.getIdUser());
        cartRepository.save(cartnew);

        return "redirect:/carts";
    }

    //
    @GetMapping("/delete_cart/{id}")
    public String deleteCart(@PathVariable("id") long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Khonog tin thay Cart:" + id));
        cartRepository.delete(cart);
        return "redirect:/carts";
    }
}
