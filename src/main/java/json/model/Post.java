package json.model;

import json.model.enums.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
@ToString
public class Post {

    private int id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;

    private PostStatus status;


}
