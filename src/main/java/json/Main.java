package json;

import json.model.Label;
import json.model.enums.Status;
import json.repository.GsonLabelRepository;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Label label = Label.builder().name("lfdgpdfgl").status(Status.ACTIVE).build();
        GsonLabelRepository repository = new GsonLabelRepository();
        repository.save(label);
        System.out.println(repository.getAll());
        repository.deleteById(3);
        System.out.println(repository.getAll());
        System.out.println(repository.getById(3));
    }
}
