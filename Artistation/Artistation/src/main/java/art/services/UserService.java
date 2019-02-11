package art.services;
import art.forms.RegisterForm;
import art.models.User;

import java.util.List;
public interface UserService {
    boolean authenticate(String userName, String password);
    List<User> findAll();
    User findById(Long id);
    User create(RegisterForm registerForm);
    User edit(User user);
    void deleteById(Long id);

}

