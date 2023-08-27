package json.model;

import java.util.List;

public class Writer {

    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts;

    private PostStatus status;

    public Writer(int id, String firstName, String lastName, List<Post> posts, PostStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
        this.status = status;
    }
}
