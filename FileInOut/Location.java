package FileInOut;

import Matching.GreedyMatcher;
import Matching.Matcher;
import Participant.Student;
import Participant.Host;
import java.util.LinkedList;

public class Location {
    String location;
    Matcher matcher;
    LinkedList<Host> HOSTS;
    LinkedList<Student> STUDENTS;

    public Location(String location, Matcher matcher) {
        this.location = location;
        this.matcher = matcher;
    }

    public void addHost(Host host) {
        HOSTS.add(host);
    }

    public void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public void setMatcher() {
        matcher.addHosts(HOSTS);
        matcher.addStudents(STUDENTS);
    }
}
