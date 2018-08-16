package Participant;

public class Methoder {

    // Used to pair host and student in matcher package while maintaining match() as protected method
    public static void pair(Host h,Student s) {
        h.match(s);
        s.match(h);
    }
}
