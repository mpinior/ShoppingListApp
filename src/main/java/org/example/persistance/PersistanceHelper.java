package org.example.persistance;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import org.example.domain.AggregateRoot;
import org.example.domain.Entity;
import org.example.domain.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersistanceHelper implements IPersistanceHelper {

    private static volatile PersistanceHelper instance;
    public synchronized static PersistanceHelper getInstance(){
        if(instance == null){
            instance = new PersistanceHelper();
        }
        return instance;
    }

    private final Path persistenceDirectory = Paths.get("persistence").toAbsolutePath();
    private final Path userDirectory = persistenceDirectory.resolve("users").toAbsolutePath();
    private final ObjectMapper objectMapper;


    private PersistanceHelper(){
        var polymorphicTypeValidator = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType(Entity.class)
                .allowIfBaseType(List.class)
                .allowIfBaseType(Map.class)
                .build();
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(polymorphicTypeValidator, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        setupDirectories();
    }


    @Override
    public List<File> getAllUserFiles(){
        return getAllFilesInDirectory(userDirectory, "json").collect(Collectors.toList());
    }

    @Override
    public void saveUserFile(User user){
        saveFile(generatePathToJson(userDirectory.toString(), user.getName()), user);
    }

    private void setupDirectories(){
        var paths = Arrays.asList(persistenceDirectory, userDirectory);

        for (var path : paths) {
            if (!Files.isDirectory(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Stream<File> getAllFilesInDirectory(Path directory) {
        return Stream.of(Objects.requireNonNull(new File(directory.toAbsolutePath().toString()).listFiles()));
    }

    private Stream<File> getAllFilesInDirectory(Path directory, String... extensions) {
        return getAllFilesInDirectory(directory).filter(file -> file.isFile() && Arrays.stream(extensions).anyMatch(x -> IPersistanceHelper.getFileExtension(file).equals(x)));
    }

    @Override
    public Path generatePathToJson(String directory, String name) {
        return Paths.get(String.format("%s/%s.json", directory, name));
    }
    @Override
    public boolean saveFile(Path path, Object content) {
        try {
            objectMapper.writeValue(path.toAbsolutePath().toFile(), content);//new JsonWrapper<>(content));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void removeFile(File file) {
        // TODO Add check for testing whether we are trying to delete file from our persistence and not some random file from drive.

        try {
            Files.delete(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads file and converts it to Java Object.
     * @param file File.
     * @param <T> Type to be returned.
     * @return Returns the new Java Object or null in case of failure.
     */
    @Override
    public <T> T loadFile(File file, Class<T> type) {
        try {
            return objectMapper.readValue(file, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
