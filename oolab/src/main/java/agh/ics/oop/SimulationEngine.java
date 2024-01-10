package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final List<Simulation> _simulations;
    private final List<Thread> _threads;
    private final ExecutorService _executorService;

    public SimulationEngine(List<Simulation> simulations) {
        _simulations = simulations;
        _threads = new LinkedList<>();
        _executorService = Executors.newFixedThreadPool(4);
    }

    public void runSync()
    {
        for(var s : _simulations) {
            s.run();
        }
    }

    public void runAsync()
    {
        for(var s : _simulations) {
            _threads.add(new Thread(s));
        }
        for(var t : _threads) {
            t.start();
        }
    }

    public void runAsyncInThreadPool() {
        for(var s : _simulations) {
            _executorService.submit(s);
        }
    }

    public void awaitSimulationEnd() {
        awaitSimulationEndList();
        awaitSimulationEndListPool();
    }

    private void awaitSimulationEndList() {
        for(var t: _threads) {
            try {
                t.join();
            }
            catch (InterruptedException ex) {

            }
        }
        _threads.clear();
    }

    private void awaitSimulationEndListPool() {
        try {
            if (!_executorService.awaitTermination(10, TimeUnit.SECONDS))  {
                _executorService.shutdownNow();
            }
        }
        catch (InterruptedException ex) {
            _executorService.shutdownNow();
        }
    }
}
