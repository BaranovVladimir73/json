package json.model;

import json.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Builder
@ToString
public class Writer {

    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts;

    private Status status;


}
