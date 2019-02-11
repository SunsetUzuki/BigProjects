package art.controllers;


import art.forms.RegisterForm;
import art.services.NotificationService;
import art.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm) {
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {


        userService.create(registerForm);


        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }


        notifyService.addInfoMessage("Registration successful");
        return "redirect:/";

    }
    ///@RequestMapping("/create")
    /// public String ModelAndView(){
    //   User user=new User();
    //   UserServiceJpaImpl userS=new UserServiceJpaImpl();
    //   userRepository.save(user);
    //   userS.create(user);
    //  return "redirect:/";

    // }
}

