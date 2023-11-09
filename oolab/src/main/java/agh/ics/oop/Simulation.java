package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> _animals;
    private final List<MoveDirection> _moves;
    public Simulation(List<Vector2d> vectors, List<MoveDirection> moves)
    {
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

        int it = 0;
        for(var move : _moves)
        {
            int idx = it % _animals.size();
            Animal animal = _animals.get(idx);

            animal.move(move);
            printAnimalMove(idx, animal);

            ++it;
        }
    }

    private void printAnimalMove(int idx, Animal animal)
    {
        System.out.println("Zwierze " + idx + " : " + animal);
    }
}
