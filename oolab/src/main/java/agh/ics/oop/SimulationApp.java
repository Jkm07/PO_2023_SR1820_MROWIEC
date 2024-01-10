package agh.ics.oop;

import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SimulationApp extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();
        configureStage(primaryStage, viewRoot);

        var map = new GrassField(UUID.randomUUID(), 10);
        map.addListener(new ConsoleMapDisplay());
        map.addListener((mapLambda, message) -> System.out.println(new Date() + " " + message));
        presenter.setWorldMap(map);
        primaryStage.show();

        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(2,2));
        var simulation = new Simulation(map, positions);
        simulation.prepareGame();
        var simulationThread = new Thread(() -> runSimulationSeparateThread(presenter, simulation));
        simulationThread.start();
    }

    private void runSimulationSeparateThread(SimulationPresenter presenter, Simulation simulation) {
        while(true) {
            try {
                List<MoveDirection> directions = OptionParser.convert(presenter.getOptions());
                simulation.setMoves(directions);
                simulation.run();
            }
            catch(IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }

}
