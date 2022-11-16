package org.example;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.persistance.UserRepository;
import org.example.service.StageFactory;

import java.util.ArrayList;

public class ShippingListApp extends Application {
    public Stage stage;
    private static ShippingListApp instance;

    public synchronized static ShippingListApp getInstance(){
        if(instance == null){
            instance = new ShippingListApp();
        }
        return instance;
    }

    @Override
    public void start(Stage stage) throws Exception {
//        User user = new User("ala", "123");
//        Item item = new Item("zegarek", 1, MeasureEnum.szt);
//        Item item2 = new Item("obroza", 1, MeasureEnum.szt);
//        ArrayList lists = new ArrayList();
//        lists.add(item);
//        lists.add(item2);
//        ShoppingList list = new ShoppingList("2022-10-10", lists, "najnowsze");
//        user.getAllLists().add(list);
//        UserRepository.getInstance().add(user);
//        UserRepository.getInstance().saveAll();

        var pair = StageFactory.getInstance().createLoginStage();
        Scene scene = new Scene(pair.getKey(), 320, 240);
        stage.setTitle("ShoppingList App");
        stage.setScene(scene);
        stage.show();
        ShippingListApp.getInstance().stage=stage;

    }
}
