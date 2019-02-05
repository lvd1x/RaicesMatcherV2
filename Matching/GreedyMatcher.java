package Matching;

import Participant.Host;
import Participant.Student;

import java.util.HashSet;
import java.util.Stack;

import edu.princeton.cs.algs4.MaxPQ;

public class GreedyMatcher implements Matcher {
    private int totalCapacity;
    private int totalStudents;
    private MaxPQ<Host> HOSTS;
    private MaxPQ<Student> STUDENTS;
    private Stack<Host> PAIRINGS;

    public GreedyMatcher() {
        HOSTS = new MaxPQ<>();
        STUDENTS = new MaxPQ<>();
        PAIRINGS = new Stack<>();
        totalCapacity = 0;
        totalStudents = 0;
    }

    /**
     * Adds student to max priority queue
     * @param s: the student being inserted
     */
    public void addStudent(Student s) {
        STUDENTS.insert(s);
        totalStudents += 1;
    }

    /**
     * Adds host to max priority queue
     * @param h: the host being inserted
     */
    public void addHost(Host h){
        HOSTS.insert(h);
        totalCapacity += h.capacity();
    }

    // returns the number of hosts that are not at capacity
    public int availableHosts(){
        return HOSTS.size();
    }

    // returns the number of students that still need a host
    public int remainingStudents() {
        return STUDENTS.size();
    }

    /**
     * Compares the accommodations given by the with the accommodations required by the student.
     * @param h Host: the host being compared
     * @param s Student: the student being compared
     * @return Boolean: true is the host can accommodate the student, false otherwise
     */
    public boolean areCompatible(Host h, Student s) {
        boolean[] provided = h.getAccommodations();
        boolean[] required = s.getAccommodations();

        for (int i = provided.length - 1; i >= 0; i--) {
            if (!provided[i] && required[i]) {
                return false;
            }
        }

        return true;
    }

    // total number of host
    public int totalHosts() {
        return HOSTS.size() + PAIRINGS.size();
    }

    // total number of students
    public int totalStudents() {
        return totalStudents;
    }

    // total original capacity of the host
    public int totalCapacity() {
        return totalCapacity;
    }


    // add host to top of stack in order to check whether or not it is full
    /**
     * Attempts to find a compatible host for student. If host is found and is not at capacity, it will be
     * @param s: Student that needs to be matched
     * @param Hosts: a PQ of potential host
     * @return Returns a stack of Host that were not compatible with the student
     */
    private Stack<Host> matchStudent(Student s, MaxPQ<Host> Hosts) {
        Stack<Host> notFullyMatched = new Stack<>();
        Host potentialHost = Hosts.delMax();

        while ((potentialHost.priority() <= potentialHost.priority())) {
            if (areCompatible(potentialHost, s)) {
                Matcher.match(potentialHost, s);
                //if host is not fully matched, should be put back into priority queue
                //consider case where fully matched and must be removed
                if (!potentialHost.isMatched()) {
                    notFullyMatched.push(potentialHost);
                } else if (potentialHost.isMatched()){

                }
            } else {
                notFullyMatched.push(potentialHost);
                // if hosts is empty, break loop
                if (Hosts.isEmpty()){
                    break;
                }
                potentialHost = Hosts.delMax();
            }
        }
        return notFullyMatched;
    }

}
