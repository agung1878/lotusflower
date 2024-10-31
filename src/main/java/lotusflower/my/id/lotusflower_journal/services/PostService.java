package lotusflower.my.id.lotusflower_journal.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.TreeMap;

import lotusflower.my.id.lotusflower_journal.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import lotusflower.my.id.lotusflower_journal.dao.PostDao;
import lotusflower.my.id.lotusflower_journal.dto.BasicSearchDto;
import lotusflower.my.id.lotusflower_journal.entity.Post;
import lotusflower.my.id.lotusflower_journal.spesification.SpecificationBuilder;
import lotusflower.my.id.lotusflower_journal.spesification.SpecificationOperation;

@Service
@Slf4j
public class PostService {

    @Autowired
    private PostDao postDao;

    public Map<Integer, List<Post>> getPostsGroupedByYear() {
        List<Post> posts = postDao.findAll();

        // Group posts by year
        Map<Integer, List<Post>> groupedPosts = posts.stream()
                .collect(Collectors.groupingBy(post -> post.getCreated().getYear()));

        // Sort by year in descending order
        return new TreeMap<>(groupedPosts).descendingMap();
    }

    public Page<Post> getPost(BasicSearchDto params, Pageable pageable){

        SpecificationBuilder<Post> builder = new SpecificationBuilder<>();

        if(StringUtils.hasText((params.getValue()))) builder.with("title", SpecificationOperation.LIKE,params.getValue());
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), Sort.Direction.fromString(params.getDirection()),params.getSort());


        return postDao.findAll(builder.build(),pageRequest);
    }

    public void save(Post post) throws Exception {
        try {
            postDao.save(post);
        }catch (Exception e){
            log.error("ERROR SAVING POST",e);
            throw e;
        }
    }

    public PostDto getPostById(String id){
        PostDto postDto = new PostDto();

        Optional<Post> postOptional = postDao.findById(id); // Use your service method
        if (postOptional.isPresent()) {
            postDto.setTitle(postOptional.get().getTitle());
            postDto.setSlug(postOptional.get().getSlug());
            postDto.setContent(postOptional.get().getContent().replaceAll("<p>|</p>", ""));
            postDto.setCreated(postOptional.get().getCreated());
        } else {
            // Handle the case where the post is not found (optional)
            log.error("ERROR GETTING POST", id);
        }

        return postDto;
    }

    public void delete(Post post){
        try {
            postDao.delete(post);
        }catch (Exception e){
            log.error("ERROR DELETING POST",e);
            throw e;
        }
    }

}
