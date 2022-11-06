package org.example.persistance;

import org.example.domain.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public interface IPersistanceHelper {

    boolean saveFile(Path path, Object content);

    void saveUserFile(User user);

    void removeFile(File file);

    <T> T loadFile(File file, Class<T> type);
    List<File> getAllUserFiles();

    Path generatePathToJson(String directory, String name);

    static String getFileExtension(File file) {
        var fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }

    static String getFileNameWithoutExtension(File file) {
        var fileName = file.getName();
        var dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? fileName : fileName.substring(0, dotIndex);
    }


}
