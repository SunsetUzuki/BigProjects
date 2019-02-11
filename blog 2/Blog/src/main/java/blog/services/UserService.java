package blog.services;
import blog.forms.RegisterForm;
import blog.models.User;

import java.util.List;
public interface UserService {
    boolean authenticate(String userName, String password);
    List<User> findAll();
    User findById(Long id);
    User create(RegisterForm registerForm);
    User edit(User user);
    void deleteById(Long id);

}

