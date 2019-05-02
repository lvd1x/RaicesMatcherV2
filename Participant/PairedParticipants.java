package Participant;

import java.util.LinkedList;

public class PairedParticipants {
    LinkedList<Host> Hosts;
    LinkedList<Student> RemainingStudents;

    public PairedParticipants() {
        Hosts = new LinkedList<Host>();
        RemainingStudents = new LinkedList<Student>();
    }

    public void addHost(Host host) {
        Hosts.add(host);
    }

    public void addStudent(Student student) {
        RemainingStudents.add(student);
    }

    public LinkedList<Host> getHosts() {
        return Hosts;
    }

    public LinkedList<Student> getRemainingStudents() {
        return getRemainingStudents();
    }
}
