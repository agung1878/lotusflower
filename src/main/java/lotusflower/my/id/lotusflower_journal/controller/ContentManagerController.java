package lotusflower.my.id.lotusflower_journal.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lotusflower.my.id.lotusflower_journal.constants.ManagementMessage;
import lotusflower.my.id.lotusflower_journal.dao.PostDao;
import lotusflower.my.id.lotusflower_journal.dto.BasicSearchDto;
import lotusflower.my.id.lotusflower_journal.entity.Post;
import lotusflower.my.id.lotusflower_journal.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/content_manager")
@Slf4j
public class ContentManagerController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostDao postDao;

    @GetMapping("/list")
    public String getContentManager(ModelMap model, BasicSearchDto params, Pageable pageable) {

        model.addAttribute("posts", postService.getPost(params, pageable));

        return "cm";
    }

    @GetMapping("/cm_form")
    public String getPageFormCm(ModelMap mm,  @RequestParam(required = false, name = "id") Post post) {

        mm.addAttribute("post",post != null ? post : new Post());

        return "cm_form";
    }

    @PostMapping("/cm_form")
    public String postPageFormCm(@Valid Post post, BindingResult errors, ModelMap mm, RedirectAttributes redirectAttributes) {
        if(errors.hasErrors()){
            mm.addAttribute("post", post);
            return "cm_form";
        }

        try {
            postService.save(post);
            redirectAttributes.addFlashAttribute("successMessage",
                    ManagementMessage.saveSuccess("post"));
        }catch (Exception e){
            log.error("ERROR SAVING POST ----------",e);
            mm.addAttribute("post", post);
            mm.addAttribute("errorMessage",
                    ManagementMessage.saveError("post", e.getMessage()));
            return "cm";
        }
        return "redirect:/content_manager/list";
    }

    @GetMapping("/view_post/{id}")
    public String post(@PathVariable String id, Model model) {
        // Fetch a single post by ID
        model.addAttribute("post", postService.getPostById(id));
        return "post";
    }

    @GetMapping("/delete")
    public String deleteData(@RequestParam(value = "id", required = false) Post post, RedirectAttributes redir) {

        try {
            postService.delete(post);
            redir.addFlashAttribute("successMessage", ManagementMessage.deleteSuccess("bank"));
        } catch (Exception e) {
            redir.addFlashAttribute("errorMessage", ManagementMessage.deleteError("bank"));
        }

        return "redirect:/content_manager/list";
    }

}
