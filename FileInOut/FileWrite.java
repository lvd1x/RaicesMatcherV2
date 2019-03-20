package FileInOut;

import java.io.FileWriter;
import java.util.LinkedList;
import Participant.Host;
import Participant.Student;
import Matching.Matcher;

public class FileWrite {
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";

    private static final String FILE_HEADER = "First,Last,Host First,Host Last,Host Email,Student Phone,Student email";

    // Helper function for writing paired participants to file
    private static void writePairings(FileWriter writer, LinkedList<Host> matches) {
        try {
            for (Host h: matches) {
                System.out.println("currently writing host: " + h.name());
                for (Student s: h.getHosting()) {
                    writer.append(s.firstName());
                    writer.append(COMMA);
                    writer.append(s.lastName());
                    writer.append(COMMA);
                    writer.append(h.firstName());
                    writer.append(COMMA);
                    writer.append(h.lastName());
                    writer.append(COMMA);
                    writer.append(h.email());
                    writer.append(COMMA);
                    writer.append(s.phone());
                    writer.append(COMMA);
                    writer.append(s.email());
                    writer.append(NEWLINE);
                }
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error in writePairing function");
        }
    }

    // Writer for unpaired students
    private static void unpaired(FileWriter writer, LinkedList<Student> students) {
        try {
            writer.append(NEWLINE);
            for (Student s: students) {
                writer.append(s.firstName());
                writer.append(COMMA);
                writer.append(s.lastName());
                writer.append(NEWLINE);
            }
        } catch (Exception e) {
            System.out.println("Error in unpaired helper function");
        }
    }

    // Main writer function to write out all results on file
    public static void writeCSV(Matcher matcherOne, Matcher matcherTwo, String fileName) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(fileName);

            writer.append(FILE_HEADER);
            writer.append(NEWLINE);

            writePairings(writer, matcherOne.getPairings());
            writePairings(writer, matcherTwo.getPairings());
            writer.append(NEWLINE);
            writer.append("Unmatched Students");
            unpaired(writer, matcherOne.getStudents());
            unpaired(writer, matcherTwo.getStudents());
        } catch (Exception e) {
            System.out.println("Error in writeCSV function");
        } finally {
            try {
                writer.flush();
                writer.close();

            } catch (Exception e) {
                System.out.println("Error flushing and closing file");
            }
        }
    }
}
