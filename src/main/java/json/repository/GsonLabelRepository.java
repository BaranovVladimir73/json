package json.repository;

import com.google.gson.Gson;
import json.model.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GsonLabelRepository implements LabelRepository {

    private final File file = new File("src/main/resources/labels.json");

    public Label getById(Integer integer) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){

        } catch (FileNotFoundException e) {
            System.out.println("Файл labels.json не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<Label> getAll() {
        List<Label> labels = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while (reader.ready()){
                labels.add(new Gson().fromJson(reader.readLine(), Label.class));
            }
        } catch (IOException e) {
            System.out.println("Файл labels.json не найден");
        }
        return labels;
    }

    public Label save(Label label) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
            List<Label> currentLabels = getAll();
            currentLabels.add(label);
            String jsonString = new Gson().toJson(currentLabels);
            writer.write(jsonString);
        } catch (IOException e) {
            System.out.println("Файл labels.json не найден");
        }
        return label;
    }

    public Label update(Label label) {
        return null;
    }

    public void deleteById(Integer integer) {

    }
}
