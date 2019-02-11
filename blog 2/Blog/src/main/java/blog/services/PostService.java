package blog.services;

import blog.forms.CreatePostForm;
import blog.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(CreatePostForm createPostForm);
    Post edit(Post post);
    void deleteById(Long id);

}
