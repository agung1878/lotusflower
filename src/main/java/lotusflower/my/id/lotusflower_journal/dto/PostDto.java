package lotusflower.my.id.lotusflower_journal.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

    private String title;
    private String slug;
    private String content;
    private LocalDateTime created;

}
