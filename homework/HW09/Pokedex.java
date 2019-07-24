// I worked on this alone

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
import javafx.scene.control.ScrollPane;


/**
* A GUI that represents a Pokedex.
* @author Christopher Messina
* @version 1.0
*/
public class Pokedex extends Application {

    /**
    * The start method for this application.
    * @param primary A Stage
    */
    @Override
    public void start(Stage primary) {
        Image ss = new Image("newSplashscreen.jpg");
        ImageView splashscreen = new ImageView();
        splashscreen.setImage(ss);

        // Splashscreen
        StackPane root = new StackPane();
        Scene splashScene = new Scene(root);
        Button goBtn = new Button("Enter Here!");
        root.getChildren().addAll(splashscreen, goBtn);
        primary.setScene(splashScene);


        // Pokedex
        BorderPane theDex = new BorderPane();
        ArrayList<Pokemon> al = PokemonFactory.createPokemon();
        ArrayList<HBox> hal = new ArrayList<HBox>();
        for (int i = 0; i < al.size(); i++) {
            hal.add(al.get(i).getSideView());
        }
        ObservableList<HBox> myPokemon = FXCollections.observableArrayList(hal);
        ListView<HBox> pokemonDir = new ListView<HBox>(myPokemon);
        theDex.setLeft(pokemonDir);
        ScrollPane initial = al.get(0).getMainView();
        theDex.setCenter(initial);
        pokemonDir.setOnMouseClicked((e) -> {
                int i = pokemonDir.getSelectionModel().getSelectedIndex();
                ScrollPane item = al.get(i).getMainView();
                theDex.setCenter(item);
            });

        Scene dexScene = new Scene(theDex);

        goBtn.setOnMouseClicked((e) -> {
                primary.setScene(dexScene);
            });

        primary.show();
    }
}