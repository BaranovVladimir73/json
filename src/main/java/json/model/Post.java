package json.model;

import json.model.enums.PostStatus;
import lombok.*;

import java.util.Date;
import java.util.List;


@Builder
@ToString
@Setter
@Getter
@AllArgsConstructor
public class Post {

    private int id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;

    private PostStatus status;

}
