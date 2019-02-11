package blog.controllers;

import blog.forms.LoginForm;
import blog.models.User;
import blog.repositories.UserRepository;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        List<User> users = userRepository.findAll();
        int flag = 0;
        for (User user : users) {
            if (Objects.equals(user.getUserName(), loginForm.getUserName()) && Objects.equals(user.getPasswordHash(), loginForm.getPassword())) {

                notifyService.addInfoMessage("Login successful");
                flag = 1;
                return "redirect:/";
            }
        }
        if (flag == 0) {
            notifyService.addErrorMessage("Invalid login!");
            return "users/login";
        }
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }
        return null;
    }
}





