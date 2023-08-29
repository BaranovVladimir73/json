package json.model;


import json.model.enums.Status;
import lombok.*;

@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Label {

    private int id;
    private String name;

    private Status status;

}
