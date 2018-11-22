// Created by Alx Pareja
package Participant;


public class Student implements RaicesParticipant {
    private String name;
    private String email;
    private String phone;
    private String homeTown;
    private boolean[] accommodations;
    private int priority;
    private boolean isMatched;
    private Host host;

    public Student(String name, String[] accommodations, String homeTown, String phone, String email) {
        this.name = name;
        this.homeTown = homeTown;
        this.phone = phone;
        this.email = email;
        this.accommodations = new boolean[accommodations.length];
        this.priority = setPref(accommodations);
        this.isMatched = false;
    }

    /** Calculates priority of host given a string list of required accommodations */
    private int setPref(String[] accommodationList) {
        int studentPriority = 0;

        try {

            for (int i = 0; i < accommodationList.length; i++) {
                if (accommodationList[i].equals("true")) {
                    studentPriority += (i + 1);
                    this.accommodations[i] = true;
                } else {
                    this.accommodations[i] = false;
                }
            }

        } catch (NullPointerException e) {
            System.out.println(this.name + " does not have sufficient accommodation information.");
        }

        return studentPriority;
    }

    protected void match(Host h) {
        host = h;
        isMatched = true;
    }

    /**
     * The following methods are used to retrieve information about the Participant.Student.
     * Method names indicate the information that is retrieved.
     * All methods do not require an input.
     */

    // Returns the student's name
    public String name() { return name; }

    // Returns the student's email
    public String email() { return email; }

    // Returns the students phone
    public String phone() { return phone; }

    // Returns the student's hometown
    public String homeTown() { return homeTown; }

    // Returns the student's priority
    public int priority() { return priority; }

    // Returns whether or not the student is paired with a host
    public boolean isMatched() { return isMatched; }

    // Returns string array with required accommodations
    public boolean[] getAccommodations() { return accommodations; }


    // Returns Name of student's host
    public String getHostName() {
        if (!isMatched) {
            return (name + " does not have a host.");
        } else {
            return host.name();
        }
    }

    // Compares one participant to another
    @Override
    public int compareTo(Participant other) { return this.priority - other.priority(); }
}
