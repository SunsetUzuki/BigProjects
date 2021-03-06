package blog.controllers;

import blog.models.User;
import blog.repositories.UserRepository;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserRepository userRepository;//УБРАТЬ ПОТОМ


    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users")
    public String index(Model model) {
        List<User> findAllUsers=userService.findAll();
        model.addAttribute("findAllusers", findAllUsers);

        return "/users/index";
    }


}
