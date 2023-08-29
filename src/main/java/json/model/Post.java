package json.model;

import json.model.enums.PostStatus;
import lombok.*;

import java.util.Date;
import java.util.List;


@Builder
@ToString
@Setter
@Getter
public class Post {

    private int id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;

    private PostStatus status;

    public Post(int id, String content, List<Label> labels, PostStatus status) {
        this.id = id;
        this.content = content;
        this.labels = labels;
        this.status = status;
        this.created = new Date();
        this.updated = new Date();
    }
}
