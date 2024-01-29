package agh.ics.oop.model;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class WorldElementBox {
    private static Map<String, Image> images = new HashMap<>();
    private ImageView imageView;
    private Label label;
    private VBox vbox;
    private final int size = 20;
    public WorldElementBox(WorldElement element)
    {
        createLabel(element);
        var pathImage = element.getImagePath();
        images.computeIfAbsent(pathImage, Image::new);
        setImageView(pathImage);
        setContainer();
    }

    public Node getVbox() {
        return vbox;
    }

    private void createLabel(WorldElement element)
    {
        label = new Label();
        label.setText(element.getLabel());
    }

    private void setImageView(String path)
    {
        imageView = new ImageView(images.get(path));
        imageView.setFitHeight(size);
        imageView.setFitWidth(size);
    }

    private void setContainer()
    {
        vbox = new VBox();
        vbox.getChildren().add(imageView);
        vbox.getChildren().add(label);
        vbox.setAlignment(Pos.CENTER);
    }
}
