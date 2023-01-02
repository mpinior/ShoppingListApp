package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.service.StageFactory;
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

        var pair = StageFactory.getInstance().createLoginStage();
        Scene scene = new Scene(pair.getKey(), 320, 240);
        stage.setTitle("ShoppingList App");
        stage.setScene(scene);
        stage.show();
        ShippingListApp.getInstance().stage=stage;

    }
}
