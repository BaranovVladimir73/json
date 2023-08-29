package json;

import json.model.Label;
import json.model.Post;
import json.model.enums.PostStatus;
import json.model.enums.Status;
import json.repository.GsonLabelRepository;
import json.repository.GsonPostRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Label label = Label.builder().name("lfdgpdfgl").status(Status.ACTIVE).build();
        GsonLabelRepository repository = new GsonLabelRepository();
        repository.save(label);
        System.out.println(repository.getAll());
        repository.deleteById(3);
        System.out.println(repository.getAll());
        System.out.println(repository.getById(3));


        List<Label> labels = new ArrayList<>();
        labels.add(Label.builder().name("lfdgpdfgl").status(Status.ACTIVE).id(1).build());
        labels.add(Label.builder().name("dasd").status(Status.ACTIVE).id(2).build());
        Post post = Post
                .builder()
                .content("какой-то контент")
                .labels(labels)
                .updated(new Date())
                .created(new Date())
                .status(PostStatus.ACTIVE)
                .build();

        GsonPostRepository gsonPostRepository = new GsonPostRepository();

        gsonPostRepository.save(post);
    }
}
