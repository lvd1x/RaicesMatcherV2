package Matching;

import Participant.Host;
import Participant.Student;
import Participant.Methoder;

import java.util.LinkedList;

public interface Matcher {

    /**
     * The function matches the host and student together
     * while updating the appropriate values accordingly.
     * @param h: the host that is being matched
     * @param s: the student that is being matched
     */
    static void match(Host h, Student s) {
        Methoder.pair(h, s);
    }

    /** returns true if student and host are compatible, false otherwise */
    boolean areCompatible(Host h, Student s);

    /** returns the total number of hosts */
    int totalHosts();

    /** returns the total number of students*/
    int totalStudents();

    /** returns the sum of initial capacity of all the hosts */
    int totalCapacity();

    /** adds student who needs a host to matcher */
    void addStudent(Student s);

    void addStudents(LinkedList<Student> s);

    /** adds host to list of available hosts in matcher */
    void addHost(Host h);

    void addHosts(LinkedList<Host> h);

    /** returns the group of pairings in matcher */
    LinkedList<Host> getPairings();

    /** returns the list of students who need host */
    LinkedList<Student> getStudents();

}
