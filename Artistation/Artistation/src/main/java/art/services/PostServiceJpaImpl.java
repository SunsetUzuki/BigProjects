package art.services;

import art.forms.AddIllustrationForm;
import art.models.Post;
import art.repositories.PostRepository;
import art.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class PostServiceJpaImpl implements PostService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findAll() {
        return this.postRepo.findAll();
    }

    @Override
    public List<Post> findLatest5() {
        return this.postRepo.findLatest5Posts(new PageRequest(0, 5));
    }

    @Override
    public Post findById(Long id) {
        return this.postRepo.getOne(id);
    }

    @Override
    public Post create(AddIllustrationForm addIllustrationForm) {
        Date date=new Date();
        Post post = new Post();
        post.setTitle(addIllustrationForm.getTitle());
        post.setBody(addIllustrationForm.getBody());
        post.setDate(date);
        post.setAuthor(userRepository.getOne((long) 1));
        return this.postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return this.postRepo.save(post);
    }

    @Override
    public void deleteById(Long id) {
        this.postRepo.deleteById(id);
    }

}