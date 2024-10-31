package lotusflower.my.id.lotusflower_journal.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lotusflower.my.id.lotusflower_journal.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;
import lotusflower.my.id.lotusflower_journal.dao.PostDao;
import lotusflower.my.id.lotusflower_journal.dto.BasicSearchDto;
import lotusflower.my.id.lotusflower_journal.entity.Post;
import lotusflower.my.id.lotusflower_journal.services.PostService;

@Controller
@Slf4j
public class BlogController {

    @Autowired
    private PostService postService;

     @GetMapping("/")
    public String index(Model mm, @AuthenticationPrincipal User user, Authentication authentication) {

         if (authentication != null){
             mm.addAttribute("loggedInUser", authentication);
         }

        Map<Integer, List<Post>> groupedPosts = postService.getPostsGroupedByYear();
        mm.addAttribute("groupedPosts", groupedPosts);
        return "index";
    }

    @GetMapping("/post/{id}")
    public String post(@PathVariable String id, Model model) {
        // Fetch a single post by ID
        model.addAttribute("post", postService.getPostById(id));
        return "post";
    }
}
