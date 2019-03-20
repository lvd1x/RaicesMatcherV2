package Matching;

import Participant.Host;
import Participant.PairedParticipants;
import Participant.Student;
import java.util.LinkedList;

import edu.princeton.cs.algs4.MaxPQ;

public class GreedyMatcher implements Matcher {
    private int totalCapacity;
    private int totalStudents;
    private LinkedList<Host> HOSTS;
    private LinkedList<Student> STUDENTS;
    private LinkedList<Host> PAIRINGS;

    public GreedyMatcher() {
        HOSTS = new LinkedList<>();
        STUDENTS = new LinkedList<>();
        PAIRINGS = new LinkedList<>();
        totalCapacity = 0;
        totalStudents = 0;
    }

    // Needs to take in generic class in LinkedList
//    private void addParticipantTo(LinkedList<Object> l, RaicesParticipant p) {
//
//        if (p.priority() == 0) {
//            l.addLast(p);
//        } else {
//            for (int i = 0; i < l.size(); i++) {
//                if (p.priority() >= l.get(i).priority()) {
//                    l.add(i, p);
//                    break;
//                }
//            }
//        }
//    }

    /**
     * Adds student to max priority queue
     * @param s: the student being inserted
     */
    public void addStudent(Student s) {

        if (s.priority() == 0) {
            STUDENTS.addLast(s);
        } else {
            for (int i = 0; i < STUDENTS.size(); i++) {
                if (s.priority() >= STUDENTS.get(i).priority()) {
                    STUDENTS.add(i, s);
                    break;
                }
            }
        }

        totalStudents += 1;
    }

    /**
     * Adds host to max priority queue
     * @param h: the host being inserted
     */
    public void addHost(Host h){

        if (h.priority() == 0 || HOSTS.isEmpty()) {
            HOSTS.addLast(h);
        } else {
            for (int i = 0; i < HOSTS.size(); i++) {
                if (h.priority() >= HOSTS.get(i).priority()) {
                    HOSTS.add(i, h);
                    break;
                }
            }
        }

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

    // returns the pairings
    public LinkedList<Host> getPairings() {
        return PAIRINGS;
    }

    public LinkedList<Student> getStudents() {
        return STUDENTS;
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
     * Attempts to find a compatible host for student. If host is found and is not at capacity, it will be matched.
     * If Host reaches capacity after being matched, it will be removed from HOSTS and placed in PAIRINGS
     * Student must be removed from STUDENTS in another function.
     * @param s: Student that needs to be matched
     */
    private boolean matchStudent(Student s) {
        boolean wasMatched = false;

        for (int i = 0; i < HOSTS.size(); i++) {
            if (s.priority() > HOSTS.get(i).priority()) {
                break;
            }

            if (areCompatible(HOSTS.get(i), s)) {
                Matcher.match(HOSTS.get(i), s);
                wasMatched = true;


                if (HOSTS.get(i).isMatched()) { // removes accommodating host if it has reached capacity
                    PAIRINGS.add(HOSTS.remove(i));
                }
                break;
            }
        }
        return wasMatched;
    }

    public void runMatcher() {
        LinkedList<Student> unhosted = new LinkedList<>();

        System.out.println("Total number of available host: " + totalHosts());
        System.out.println("Max students that can be hosted: " + totalCapacity());
        System.out.println("Total number of students: " + STUDENTS.size());

        while (!STUDENTS.isEmpty() && !HOSTS.isEmpty()) {
            Student currentStudent = STUDENTS.poll();
            if (!matchStudent(currentStudent)) {
                unhosted.add(currentStudent);
            }
        }

        if (!STUDENTS.isEmpty()) {
            for (Student s: STUDENTS) {
                unhosted.add(s);
            }
        }

        System.out.println("Number of students that need hosts: " + unhosted.size());
        System.out.println("Number of available hosts: " + HOSTS.size());

        STUDENTS = unhosted;
    }

    public void printPairings() {
        System.out.println("Pairings: ");
        for (Host h: PAIRINGS) {
            for (Student s: h.getHosting()) {
               s.hostInfo();
            }
        }
        for (Host h: HOSTS) {
            if (h.isHosting()) {
                for (Student s: h.getHosting()) {
                    s.hostInfo();
                }
            } else {
                System.out.println(h.name() + " is not hosting anyone");
            }
        }
    }



    public static void main(String args[]) {
        LinkedList<Integer> nums = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            nums.add(i);
        }

        nums.add(4, 12);
        //System.out.println(nums.size());

        for (int i: nums) {
            System.out.println(i);
        }
    }

}
