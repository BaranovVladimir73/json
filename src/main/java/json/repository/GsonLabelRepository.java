package json.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import json.model.Label;
import json.model.enums.Status;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class GsonLabelRepository implements LabelRepository {

    private final File file = new File("src/main/resources/labels.json");

    public Label getById(Integer id) {
        Label label = getAll()
                .stream()
                .filter((o)-> o.getId()==id)
                .findAny()
                .orElseThrow();
        return label;
    }

    public List<Label> getAll() {
        List<Label> labels = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String jsonString = "";
            while (reader.ready()){
                jsonString = jsonString + reader.readLine();
            }
            Type typeToken = new TypeToken<List<Label>>(){}.getType();
            labels = new Gson().fromJson(jsonString, typeToken);

        } catch (IOException e) {
            System.out.println("Файл labels.json не найден");
        }
        return labels;
    }

    public Label save(Label label) {
        List<Label> currentLabels = getAll();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            List<Label> newLabels = new ArrayList<>();
            int maxId = 0;
            if (currentLabels != null){
                newLabels.addAll(currentLabels);
                maxId = currentLabels
                        .stream()
                        .max(Comparator.comparing(Label::getId))
                        .get()
                        .getId();
            }
            maxId++;
            label.setId(maxId);
            newLabels.add(label);
            String jsonString = new Gson().toJson(newLabels);
            writer.write(jsonString);
        } catch (IOException e) {
            System.out.println("Файл labels.json не найден");
        }
        return label;
    }

    public Label update(Label label) {

        List<Label> labels = getAll().stream().peek((e)-> {
            if(e.getId() == label.getId()){
                e.setStatus(label.getStatus());
                e.setName(label.getName());
            }
        }).collect(Collectors.toList());

        String stringJson = new Gson().toJson(labels);
        try(FileWriter writer = new FileWriter(file)){
            writer.write(stringJson);
        } catch (IOException e){
            System.out.println("Файл labels.json не найден");
        }
        return label;
    }

    public void deleteById(Integer id) {

        List<Label> labels = getAll().stream().peek((e)-> {
            if(e.getId() == id){
                e.setStatus(Status.DELETED);
            }
        }).collect(Collectors.toList());

        String stringJson = new Gson().toJson(labels);
        try(FileWriter writer = new FileWriter(file)){
            writer.write(stringJson);
        } catch (IOException e){
            System.out.println("Файл labels.json не найден");
        }

    }
}
