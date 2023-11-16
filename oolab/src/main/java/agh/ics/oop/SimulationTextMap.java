package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class SimulationTextMap {
    private final List<String> _strings;
    private final List<MoveDirection> _moves;
    private final WorldMap<String, Integer> _map;
    public SimulationTextMap(WorldMap<String, Integer> map, List<String> strings, List<MoveDirection> moves)
    {
        _map = map;
        _strings = strings;
        _moves = moves;
    }

    public void run()
    {
        if(_strings.isEmpty())
            return;
        for(var a : _strings) {
            _map.place(a);
        }
        int it = 0;
        System.out.println(_map);
        for(var move : _moves)
        {
            int idx = it % _strings.size();
            var string = _strings.get(idx);
            _map.move(string, move);

            printAnimalMove(idx, string, move);
            ++it;
        }
    }

    private void printAnimalMove(int idx, String str, MoveDirection move)
    {
        System.out.println("String " + str + " moves in direction : " + move);
        System.out.println(_map);
    }
}
