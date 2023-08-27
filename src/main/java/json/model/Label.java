package json.model;

public class Label {

    private int id;
    private String name;

    private PostStatus status;

    public Label(int id, String name, PostStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
