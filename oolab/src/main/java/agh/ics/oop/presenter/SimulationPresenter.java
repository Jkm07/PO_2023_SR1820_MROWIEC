package agh.ics.oop.presenter;

import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class SimulationPresenter implements MapChangeListener {

    private final double CELL_SIZE = 45;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Label infoLabel;
    @FXML
    private GridPane gridMap;
    @FXML
    private TextField textCommandLine;
    private final Object lock = new Object();
    private String optionBuffer = null;

    public String[] getOptions() {
        String result;
        synchronized (lock) {
            if (optionBuffer == null)
                try {
                    lock.wait();
                }
                catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            result = optionBuffer;
            optionBuffer = null;
        }
        return result.split(" ");
    }

    public void setWorldMap(WorldMap<WorldElement, Vector2d> map) {
        if (map  instanceof AbstractWorldMap) {
            ((AbstractWorldMap) map).addListener(this);
        }
        gridMap.setGridLinesVisible(true);
        mainPane.getLeft().resize(10, 20);
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> infoLabel.setText(message));
        if ( worldMap instanceof  AbstractWorldMap) {
            Platform.runLater(() -> drawGrid((AbstractWorldMap) worldMap));
        }
    }

    @FXML
    private void startButtonClick(){
        synchronized (lock) {
            optionBuffer =  textCommandLine.getText();
            lock.notifyAll();
        }
    }

    private void drawGrid(AbstractWorldMap worldMap)
    {
        clearGrid();
        var bounds = worldMap.getCurrentBounds();
        var grid_row = bounds.topRight().y() - bounds.bottomLeft().y() + 1;
        var grid_col = 1;
        for(var row = bounds.bottomLeft().y(); row <= bounds.topRight().y(); ++row)
        {
            for(var col = bounds.bottomLeft().x(); col <= bounds.topRight().x(); ++col)
            {
                var object = worldMap.objectAt(new Vector2d(col, row));
                var cell = createCell(object.isPresent() ? object.get().toString() : "");
                gridMap.add(cell, grid_col, grid_row);
                grid_col++;
            }
            grid_row--;
            grid_col = 1;
        }
        createAxis(bounds);
    }

    private void createAxis(Boundary<Vector2d> bounds)
    {
        var grid_row = bounds.topRight().y() - bounds.bottomLeft().y() + 1;
        for(var row = bounds.bottomLeft().y(); row <= bounds.topRight().y(); ++row)
        {
            var cell = createCell(String.valueOf(row));
            gridMap.add(cell, 0, grid_row);
            grid_row--;
        }
        var grid_col = 1;
        for(var col = bounds.bottomLeft().x(); col <= bounds.topRight().x(); ++col)
        {
            var cell = createCell(String.valueOf(col));
            gridMap.add(cell, grid_col, 0);
            grid_col++;
        }
        var cell = createCell("y/x");
        gridMap.add(cell, 0, 0);
    }

    private BorderPane createCell(String value)
    {
        var pane = new BorderPane();
        var label = new Label(value);
        pane.setPrefSize(CELL_SIZE, CELL_SIZE);
        pane.setCenter(label);
        return pane;
    }

    private void clearGrid()
    {
        gridMap.getChildren().retainAll(gridMap.getChildren().get(0));
        gridMap.getColumnConstraints().clear();
        gridMap.getRowConstraints().clear();
    }
}
