package FileInOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Matching.Matcher;
import Participant.Student;
import Participant.Host;

public class FileRead {

    // Reads file of incoming students and sets instances in matchers
    public static void setStudents(Matcher males, Matcher females, String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        input.useDelimiter(",");
        input.nextLine();

        String name = "";
        String hometown = "";
        String phone = "";
        String email = "";
        String gender = "";
        String comments = "";
        String[] accommodations = {"false", "false", "false"};

        while (input.hasNextLine()) {
            name = input.next() + " " + input.next();
            phone = input.next();

            hometown = input.next();
            hometown = hometown.substring(4, hometown.length());

            gender = input.next();
            if (gender.matches("(?i).*she.*") || gender.matches("(?i).*female.*")) {
                gender = "F";
            } else {
                gender = "M";
            }

            email = input.next();
            comments = input.next();

            // sets the accommodation request for the students
            if (comments.matches("(?i).*undoc.*")) {
                accommodations[1] = "true";
            } else {
                accommodations[1] = "false";
            }
            if (comments.matches("(?i).*lgbt.*")) {
                accommodations[2] = "true";
            } else {
                accommodations[2] = "false";
            }

            // places student in correct matcher
            if (gender.equals("M")) {
                males.addStudent(new Student(name, accommodations, hometown, phone, email));
            } else {
                females.addStudent(new Student(name, accommodations, hometown, phone, email));
            }

            input.nextLine();
        }
    }

    // Reads files of hosts and sets instances in matchers
    public static void setHosts(Matcher males, Matcher females, String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        input.useDelimiter(",");
        input.nextLine();

        String name = "";
        String hometown = "";
        String phone = "";
        String email = "";
        String gender = "";
        String capacity = "";
        String comments = "";
        String[] accommodations = {"false", "false", "false"};

        while (input.hasNextLine()) {
            name = input.next() + " " + input.next();
            hometown = input.next();
            phone = input.next();
            email = input.next();

            gender = input.next();
            if (gender.matches("(?i).*she.*") || gender.matches("(?i).*female.*")) {
                gender = "F";
            } else {
                gender = "M";
            }

            capacity = input.next();

            // gets the accommodations for the hosts
            if (input.next().equals("Yes")) {
                accommodations[1] = "true";
            }
            if (input.next().equals("Yes")) {
                accommodations[0] = "true";
            }
            if (input.next().equals("Yes")) {
                accommodations[2] = "true";
            }
//            comments = input.next();
//            if (comments.matches("(?i).*undoc.*")){
//                accommodations[1] = "true";
//            }

            // places host in correct matcher
            if (gender.equals("M")) {
                males.addHost(new Host(name, accommodations, hometown, phone, email, capacity));
            } else {
                females.addHost(new Host(name, accommodations, hometown, phone, email, capacity));
            }
//            System.out.println(name);

            input.nextLine();
        }
    }

}
