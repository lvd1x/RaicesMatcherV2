package Matching;

import Participant.Host;
import Participant.Student;
import java.util.HashSet;
import java.util.LinkedList;
import edu.princeton.cs.algs4.MaxPQ;

public class GreedyMatcher implements Matcher {
    private int totalCapacity;
    private MaxPQ<Host> HOSTS;
    private MaxPQ<Student> STUDENTS;
    private LinkedList<Host> PAIRINGS;

    public GreedyMatcher(){
        HOSTS = new MaxPQ<>();
        STUDENTS = new MaxPQ<>();
        PAIRINGS = new LinkedList<>();
        totalCapacity = 0;
    }

    public void addStudent(Student s) {
        STUDENTS.insert(s);
    }

    public void addHost(Host h){
        HOSTS.insert(h);
        totalCapacity += h.capacity();
    }

    public int availableHosts(){
        return HOSTS.size();
    }

    public int remainingStudents() {
        return STUDENTS.size();
    }

    public boolean areCompatible(Host h, Student s) {
        boolean[] provided = h.getAccommodations();


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
