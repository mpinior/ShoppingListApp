package org.example.service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import org.example.controller.HomeScreenController;
import org.example.controller.ShoppingListController;

import java.io.IOException;

public class StageFactory {
    private final IMediator iMediator;
    private String pathToXMLs = "/";

    private static StageFactory instance;

    public synchronized static StageFactory getInstance(){
        if(instance == null){
            instance = new StageFactory();
        }
        return instance;
    }

    public StageFactory(){
        iMediator = new Mediator();

    }

    public Pair<GridPane, ShoppingListController>  createLoginStage(){
        return loadFromFxmnl(pathToXMLs+"loginScreen.fxml");
    }

    public Pair<GridPane, ShoppingListController>  createMainStage(){
        return loadFromFxmnl(pathToXMLs+"mainScreen.fxml");
    }

    private <TUIElement extends Node, TController> Pair<TUIElement, TController> loadFromFxmnl(String path) {
        try {
            var fxmlLoader = new FXMLLoader(getClass().getResource(path));

            fxmlLoader.setControllerFactory(e -> {
                if(e == ShoppingListController.class){
                    return new ShoppingListController(iMediator.getUserService());
                }
                if(e == HomeScreenController.class){
                    return new HomeScreenController(iMediator.getUserService(), iMediator.getUserRepository());
                }
                return null;
            });

            var result = fxmlLoader.<TUIElement>load();
            var controller = fxmlLoader.<TController>getController();
            return new Pair<>(result, controller);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
