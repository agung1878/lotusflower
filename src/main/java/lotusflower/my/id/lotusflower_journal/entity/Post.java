package lotusflower.my.id.lotusflower_journal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post extends BaseEntity{

    @NotNull @NotEmpty
    private String title;

    @NotNull @NotEmpty
    private String slug;

    @NotNull @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String content;
}
