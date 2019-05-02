package FileInOut;
import Matching.GreedyMatcher;
import Matching.Matcher;

import java.io.FileNotFoundException;


public class InputOutput {

    public static void main(String[] args) throws FileNotFoundException {
        Matcher males = new GreedyMatcher();
        Matcher females = new GreedyMatcher();

        FileRead.setStudents(males, females, "/Users/levid/Desktop/RaicesMatcherV2/FileInOut/studentsFinal.csv");
        FileRead.setHosts(males, females, "/Users/levid/Desktop/RaicesMatcherV2/FileInOut/hostData.csv");

        ((GreedyMatcher) males).runMatcher();
        ((GreedyMatcher) females).runMatcher();

        FileWrite.writeCSV(males, females, "/Users/levid/Desktop/RaicesMatcherV2/FileInOut/testPairings.csv");
    }
}
