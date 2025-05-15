package pl.edu.agh.utils;

import pl.edu.agh.MusicParser;
import pl.edu.agh.MusicSuperVisitor;

/**
 * Class TrackComponent is aggregated by class Track
 */
public class TrackComponent {
    public MusicSuperVisitor msv;
    public MusicParser.ProgramContext program;
    Thread thread;

    public TrackComponent(MusicSuperVisitor msv, MusicParser.ProgramContext program){
       this.msv = msv;
       this.program = program;
    }

    public void start(){
        this.thread = new Thread(()-> msv.visit(program));
        this.thread.start();
    }

    public void join() throws InterruptedException {
        this.thread.join();
    }
}
