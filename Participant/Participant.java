package Participant;// Created By: Alx Pareja

public interface Participant extends Comparable<Participant> {

    /** Returns the name of the participant */
    String name();

    /** Returns the phone number of the participant */
    String phone();

    /** Returns the email address of the participant */
    String email();

    /** Returns the home town of the participant */
    String homeTown();

    /** returns the priority of the participant based on
     * number of accommodations that it can fulfill
     */
    int priority();
}
