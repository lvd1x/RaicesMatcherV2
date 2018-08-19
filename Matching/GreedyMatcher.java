package Matching;

import Participant.Host;
import Participant.Student;
import java.util.HashSet;
import java.util.LinkedList;
import edu.princeton.cs.algs4.MaxPQ;

public class GreedyMatcher implements Matcher {
    private int hostsAvailable;
    private int studentsRemaining;
    private int totalCapacity;
    private MaxPQ<Host> HOSTS;
    private MaxPQ<Student> STUDENTS;
    private LinkedList<Host> PAIRINGS;


    public boolean areCompatible(Host h, Student s) {
        return false;
    }

    public int totalHosts() {
        return 0;
    }

    public int totalStudents() {
        return 0;
    }

    public int totalCapacity() {
        return 0;
    }
}
