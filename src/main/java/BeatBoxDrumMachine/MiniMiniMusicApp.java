package BeatBoxDrumMachine;

import javax.sound.midi.*;

import static javax.sound.midi.ShortMessage.*;

public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
        System.out.println("end");
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open(); //1

            Sequence seq = new Sequence(Sequence.PPQ, 4); //2

            Track track = seq.createTrack(); //3
            //4
            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            track.add(noteOff);

            System.out.println("hey");

            player.setSequence(seq);

            System.out.println("hey2");

            player.start();
            System.out.println("hey3");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
