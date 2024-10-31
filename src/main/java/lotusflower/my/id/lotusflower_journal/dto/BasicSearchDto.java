package lotusflower.my.id.lotusflower_journal.dto;

import lombok.Data;

@Data
public class BasicSearchDto {

    private String sort = "title";
    private String direction = "DESC";
    private int size = 10;

    private String value = "";
}
