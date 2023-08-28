package json;

import json.model.Label;
import json.model.enums.Status;
import json.repository.GsonLabelRepository;

public class Main {

    public static void main(String[] args) {
        Label label = new Label(2, "сыфсыф", Status.ACTIVE);
        GsonLabelRepository repository = new GsonLabelRepository();
        //repository.save(label);
        System.out.println(repository.getAll());
    }
}
