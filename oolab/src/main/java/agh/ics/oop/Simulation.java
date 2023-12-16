package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.exception.PositionAlreadyOccupiedException;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable{
    private final List<Animal> _animals;
    private List<MoveDirection> _moves;
    private final WorldMap<WorldElement, Vector2d> _map;
    public Simulation(WorldMap<WorldElement, Vector2d> map, List<Vector2d> vectors, List<MoveDirection> moves)
    {
        _map = map;
        _animals = new ArrayList<>(vectors.size());
        for (var vector: vectors) {
            _animals.add(new Animal(vector));
        }
        setMoves(moves);
    }

    public Simulation(WorldMap<WorldElement, Vector2d> map, List<Vector2d> vectors) {
        this(map, vectors, null);
    }

    public void setMoves(List<MoveDirection> moves) {
        _moves = moves;
    }

    public void prepareGame() {
        var animal_iterator = _animals.iterator();
        while(animal_iterator.hasNext()) {
            try {
                _map.place(animal_iterator.next());
            }
            catch (PositionAlreadyOccupiedException ex) {
                System.out.println(ex.getMessage());
                animal_iterator.remove();
            }
        }
    }

    @Override
    public void run()
    {
        if(_animals.isEmpty())
            return;
        Thread game = new Thread(this::executeGame);
        game.start();
    }

    private void executeGame() {
        int it = 0;
        for(var move : _moves)
        {
            doMove(move, it);
            ++it;
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doMove(MoveDirection move, int animalIdx) {
        int idx = animalIdx % _animals.size();
        Animal animal = _animals.get(idx);
        _map.move(animal, move);
    }
}
