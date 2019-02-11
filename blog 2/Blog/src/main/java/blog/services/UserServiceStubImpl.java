package blog.services;

import blog.forms.RegisterForm;
import blog.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public boolean authenticate(String userName, String password) {
        //Provide a sample password check: userName==password
        return Objects.equals(userName, password);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User create(RegisterForm registerForm) {
        return null;
    }



    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
