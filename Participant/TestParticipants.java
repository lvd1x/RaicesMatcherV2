package Participant;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestParticipants {

    @Test
    public void TestParticipants() {
        String[] accommodations = {"true", "true", "true"};
        String capacity = "5";

        Host h = new Host("host", accommodations, "hometown",
                "323-981-1234", "host@mail.com", capacity);
        Student s = new Student("student", accommodations,"studentTown",
                "323-234-345", "student@mail.com");

        Assert.assertEquals("Participant.Host should have a capacity of: ", Integer.parseInt(capacity), h.capacity());
        Assert.assertEquals("Priority of the host should be: ", 6, h.priority());
        Assert.assertEquals("Priority of the student should be: ", 6, s.priority());

    }

    @Test
    public void testMatch() {
        String[] accommodations = {"true", "true", "true"};
        String capacity = "2";

        Host h = new Host("host", accommodations, "hostown",
                "323-981-1234", "host@ymail.com", capacity);

        Student s = new Student("studentOne", accommodations,"studentTown",
                "323-234-345", "student@smail.com");
        Student t = new Student("studentTwo", accommodations,"studentTown",
                "323-234-346", "studenter@smail.com");

        h.match(s);
        s.match(h);

        assertTrue("Participant.Host should be hosting but not be at capacity. ", (h.isHosting() && !h.isMatched()));
        assertTrue("Participant.Student should be matched with a host. ", s.isMatched());

        h.match(t);
        t.match(h);
        assertTrue("Participant.Host should now be fully matched", h.isMatched());

        System.out.println();
        h.printMatches();
        System.out.println();

        System.out.print(s.name() + " is being hosted by " +  s.getHostName());
        System.out.println();
        System.out.print(t.name() + " is being hosted by " + t.getHostName());
    }
}
