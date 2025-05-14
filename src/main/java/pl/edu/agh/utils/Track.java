package pl.edu.agh.utils;

import pl.edu.agh.TrackHandler;

import java.util.ArrayList;

public class Track {
    public String name;
    public ArrayList<TrackComponent> melodies;
    public int line;

    public Track(String name, int line){
        this.name = name;
        this.line = line;
    }

    public void add(TrackComponent tc){
        melodies.add(tc);
    }

    public void play() throws InterruptedException {
        for(TrackComponent tc: melodies) tc.start();
        for(TrackComponent tc: melodies) tc.join();
    }
}
