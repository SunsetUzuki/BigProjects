package blog.services;

import blog.forms.RegisterForm;
import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserService userService;

    @Override
    public boolean authenticate(String userName, String password) {
        return false;
    }

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepo.getOne(id);
    }

    @Override
    public User create(RegisterForm registerForm) {
        User user = new User();
        user.setUserName(registerForm.getUserName());
        user.setFullName(registerForm.getFullName());
        user.setPasswordHash(registerForm.getPassword());
        return this.userRepo.save(user);
    }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.deleteById(id);
    }

}