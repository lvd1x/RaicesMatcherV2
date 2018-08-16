package Participant;//Created By: Alx Pareja


public interface RaicesParticipant extends Participant {

    /** returns the priority of the participant based on
     * number of accommodations that it can fulfill
     */
    int priority();

    //void printMatches();

    /** returns true if the participant is completely matched */
    boolean isMatched();

    /** returns the array of accommodations */
    String[] getAccommodations();

}
