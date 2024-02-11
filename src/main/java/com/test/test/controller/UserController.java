package com.test.test.controller;

import com.test.test.entity.UserEntity;
import com.test.test.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Apilat Denis
 * Date :11.02.2024
 * Time :14:03
 * Project Name :test
 */

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("users", userServiceImpl.getUsers());
        return "index";
    }

    @GetMapping("/add-form")
    public String addNewUser(Model model) {
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        return "add-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("user") UserEntity userEntity) {
        userServiceImpl.saveUser(userEntity);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") String id, Model model) {
        Optional<UserEntity> user = userServiceImpl.getUserById(id);
        user.ifPresent(userEntity -> model.addAttribute("user", userEntity));
        return "update-form";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable(value = "id") String id, @ModelAttribute("user") UserEntity updatedUser) {
        userServiceImpl.updateUserById(id, updatedUser);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable String id) {
        userServiceImpl.deleteUserById(id);
        return "redirect:/";

    }
}
