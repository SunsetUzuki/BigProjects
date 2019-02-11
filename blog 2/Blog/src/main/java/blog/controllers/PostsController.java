package blog.controllers;

import blog.forms.CreatePostForm;
import blog.models.Post;

import blog.models.User;
import blog.repositories.PostRepository;
import blog.repositories.UserRepository;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostsController {
@Autowired
    private UserRepository userRepository;//УБРАТЬ ПОТОМ
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }

        model.addAttribute("post", post);
        return "posts/view";
    }

    @RequestMapping(value="/posts/create", method = RequestMethod.POST)
    public String create(CreatePostForm createPostForm) {
        postService.create(createPostForm);

        return "redirect:/";
    }
    @RequestMapping("/posts/create")
    public String createPage(CreatePostForm createPostForm) {
        return "/posts/create";
    }


    @RequestMapping("/posts")
    public String index(Model model) {
        List<Post> findAllPosts=postService.findAll();
        model.addAttribute("findAllposts", findAllPosts);


        return "/posts/index";
    }
}
