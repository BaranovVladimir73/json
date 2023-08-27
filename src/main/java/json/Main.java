package json;

import json.model.Label;
import json.model.PostStatus;
import json.repository.GsonLabelRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Label label = new Label(2, "искусство", PostStatus.ACTIVE);
        GsonLabelRepository repository = new GsonLabelRepository();
        repository.save(label);    }
}
