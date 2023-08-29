package json.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import json.model.Label;
import json.model.Post;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GsonPostRepository implements PostRepository{

    private final File file = new File("src/main/resources/posts.json");

    @Override
    public Post getById(Integer id) {

        return null;
    }

    @Override
    public List<Post> getAll() {

        List<Post> posts = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String jsonString = "";
            while (reader.ready()){
                jsonString = jsonString + reader.readLine();
            }
            Type typeToken = new TypeToken<List<Post>>(){}.getType();
            posts = new Gson().fromJson(jsonString, typeToken);

        } catch (IOException e) {
            System.out.println("Файл labels.json не найден");
        }
        return posts;
    }

    @Override
    public Post save(Post post) {

        List<Post> currentPosts = getAll();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            List<Post> newPosts = new ArrayList<>();
            int maxId = 0;
            if (currentPosts != null){
                newPosts.addAll(currentPosts);
                maxId = currentPosts
                        .stream()
                        .max(Comparator.comparing(Post::getId))
                        .get()
                        .getId();
            }
            maxId++;
            post.setId(maxId);
            newPosts.add(post);
            String jsonString = new Gson().toJson(newPosts);
            writer.write(jsonString);
        } catch (IOException e) {
            System.out.println("Файл labels.json не найден");
        }
        return post;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
