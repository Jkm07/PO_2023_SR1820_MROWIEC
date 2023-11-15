package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> _animals;
    private final List<MoveDirection> _moves;
    private final WorldMap _map;
    public Simulation(WorldMap map, List<Vector2d> vectors, List<MoveDirection> moves)
    {
        _map = map;
        _animals = new ArrayList<>(vectors.size());
        for (var vector: vectors) {
            _animals.add(new Animal(vector));
        }
        _moves = moves;
    }

    public void run()
    {
        if(_animals.isEmpty())
            return;
        for(var a : _animals) {
            _map.place(a);
        }
        int it = 0;
        for(var move : _moves)
        {
            int idx = it % _animals.size();
            Animal animal = _animals.get(idx);
            _map.move(animal, move);

            printAnimalMove(idx, animal, move);
            ++it;
        }
    }

    private void printAnimalMove(int idx, Animal animal, MoveDirection move)
    {
        System.out.println("Zwierze " + idx + " moves in direction : " + move);
        System.out.println(_map);
    }
}
