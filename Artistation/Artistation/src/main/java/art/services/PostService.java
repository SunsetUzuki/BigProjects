package art.services;

import art.forms.AddIllustrationForm;
import art.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(AddIllustrationForm addIllustrationForm);
    Post edit(Post post);
    void deleteById(Long id);

}
