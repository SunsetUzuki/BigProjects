package blog.services;

import blog.forms.CreatePostForm;
import blog.models.Post;
import blog.repositories.PostRepository;
import blog.repositories.UserRepository;
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
    public Post create(CreatePostForm createPostForm) {
        Date date=new Date();
        Post post = new Post();
        post.setTitle(createPostForm.getTitle());
        post.setBody(createPostForm.getBody());
        post.setDate(date);//ВЗЯТЬ ДАТУ ОТКУДАТО
        post.setAuthor(userRepository.getOne((long) 1));//ВЗЯТЬ АВТОРА ОТКУДАТО
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