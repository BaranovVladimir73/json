package json.model;


import json.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
public class Label {

    private int id;
    private String name;

    private Status status;

}
