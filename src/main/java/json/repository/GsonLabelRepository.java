package json.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import json.model.Label;

import java.io.*;
import java.lang.reflect.Type;
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
            if (currentLabels != null){
                newLabels.addAll(newLabels);
            }
            newLabels.add(label);
            String jsonString = new Gson().toJson(newLabels);
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
