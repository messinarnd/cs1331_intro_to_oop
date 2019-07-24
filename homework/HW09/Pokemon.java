// I worked on this alone.

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;

/**
 * Class representing a Pokemon that is recorded in the Pokedex
 * @author Christopher Messina
 * @version 1.1
 */
public class Pokemon {
    private String name;
    private HBox type = new HBox();
    private Image pic;
    private String description;
    private int generation;
    private int number;
    private HBox sideView;
    private ScrollPane mainView;

    /**
     * Creates a Pokemon instance
     *
     * @param name of the Pokemon
     * @param pic the path to the image file
     * @param types the types of the Pokemon
     */
    public Pokemon(String name, String pic, Type ... types) {
        this.name = name;
        for (Type t : types) {
            type.getChildren().add(t.getTypeView());
        }
        type.setSpacing(5);
        type.setAlignment(Pos.CENTER);
        this.pic = new Image(pic);

        createSideView();
        createDetailView();
    }

    /**
     * Creates the detail view of the Pokemon to be displayed in
     * the main section of the Pokedex.
     */
    public void createDetailView() {
        //Create the bigger detail view for the main pane here
        //Remember to actually save this view or change this method
        //header to return the view.
        //This method is called inside of PokemonFactory
        mainView = new ScrollPane();
        VBox vb = new VBox();
        ImageView mainIV = new ImageView();
        mainIV.setImage(pic);
        mainIV.setFitWidth(300);
        mainIV.setFitHeight(300);
        mainIV.setPreserveRatio(true);
        Text pokemonName = new Text(name);
        Text num = new Text("#" + number);
        Text gen = new Text("Generation: " + generation);
        Text label = new Text("Pokedex Entry");
        Text des = new Text(description);
        des.setWrappingWidth(300);
        vb.getChildren().addAll(mainIV, pokemonName, type,
            num, gen, label, des);
        vb.setAlignment(Pos.CENTER);
        mainView.setContent(vb);
    }

    /**
     * Creates the list view of the Pokemon to be displayed in
     * the list view panel
     */
    public void createSideView() {
        //create the view that will be displayed for each entry in the list
        //in the side panel.
        //Remember to actually save this view or change this method header
        //to return the view. So that you can actually use it.
        //This method is called inside of PokemonFactory.
        sideView = new HBox();
        ImageView sideIV = new ImageView();
        sideIV.setImage(pic);
        sideIV.setFitWidth(50);
        sideIV.setFitHeight(50);
        sideIV.setPreserveRatio(true);
        Text pokeName = new Text(name);
        sideView.getChildren().addAll(sideIV, pokeName);
    }

    /**
     * Sets the description
     * @param d the description
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Sets the generation
     * @param generation An int
     */
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
     * Sets the number of the Pokemon
     * @param number An int
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
    * Gets the detailed view of each pokemon.
    * @return a ScrollPane with the details of each pokemon
    */
    public ScrollPane getMainView() {
        return mainView;
    }

    /**
    * Gets the view for each menu item of pokemon
    * @return an HBox with the picture and name of pokemon
    */
    public HBox getSideView() {
        return sideView;
    }
}
