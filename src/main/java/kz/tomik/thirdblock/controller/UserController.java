package kz.tomik.thirdblock.controller;

import kz.tomik.thirdblock.model.User;
import kz.tomik.thirdblock.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceInterface userServiceInterface;
    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userServiceInterface.findAll());
        return "user/index";
    }
    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id")int id){
        model.addAttribute("user", userServiceInterface.findOne(id));
        return "user/show";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "user/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user")@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/new";
        }
        userServiceInterface.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("user", userServiceInterface.findOne(id));
        return "user/edit";
    }
    @PatchMapping("{id}")
    public String update(@ModelAttribute("user")@Valid User user,
                         BindingResult bindingResult,
                         @PathVariable("id")int id){
        if(bindingResult.hasErrors()){
            return "user/edit";
        }
        userServiceInterface.update(id,user);
        return "redirect:/users";
    }
    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")int id){
        userServiceInterface.delete(id);
        return "redirect:/users";
    }
}
