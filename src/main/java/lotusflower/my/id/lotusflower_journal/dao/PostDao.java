package lotusflower.my.id.lotusflower_journal.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import lotusflower.my.id.lotusflower_journal.entity.Post;

public interface PostDao extends JpaRepository<Post, String>, PagingAndSortingRepository<Post, String>, JpaSpecificationExecutor<Post>{


}
