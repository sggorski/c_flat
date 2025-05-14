package pl.edu.agh.utils;

import pl.edu.agh.MusicParser;
import pl.edu.agh.MusicSuperVisitor;

public class TrackComponent {
    public MusicSuperVisitor msv;
    public MusicParser.ProgramContext program;
    Thread thread;

    public void TrackHandler(MusicSuperVisitor msv, MusicParser.ProgramContext program){
       this.msv = msv;
       this.program = program;
       this.thread = new Thread(()-> msv.visit(program));
    }

    public void start(){
        this.thread.start();
    }

    public void join() throws InterruptedException {
        this.thread.join();
    }
}
