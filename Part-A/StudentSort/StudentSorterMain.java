/**
 * @author Jitesh Kumar Jha
 * @email jiteshjha96@gmail.com
 * Last Updated : 04 April 2016
 * Source(s) : https://docs.oracle.com/javase/7/docs/api/
 */

package studentsorter;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.HashSet;
import java.util.Set;

/**
 * Creates a Student Ranking System which gets minimum 5 records and sorts it on total marks.
 * If 2 or more students have the same total then prioritizes rank based on highest mark with the
 * order of subjects being Math, Science, ES, Language 1 and Language 2.
 * If unable to filter based on marks, then provide rank based on ascending order of name.
 */

/**
 * Custom Exception is invoked when the input marks is out of the given permissible bounds.
 * Input: MarksOutOfBoundsException(float a), where variable a is the incorrect marks.
 * Output: Returns a string description for the exception and the cause.
 */
class MarksOutOfBoundsException extends Exception {
    private float marks;
    MarksOutOfBoundsException(float a) {
    marks = a;
    }
    @Override
    public String toString() {
        return "\nInput marks out of bounds!\nYour input : " + marks + "\nPlease try again:";
    }
}

/**
 * Custom Exception is invoked when the input name contains one or more digits.
 * Input: IncorrectNameException(String a), where a is the incorrect name.
 * Output: Returns a string description for the exception and the cause.
 */
class IncorrectNameException extends Exception {
    private String name;
    IncorrectNameException(String a) {
        name = a;
    }
    @Override
    public String toString() {
        return "\nInput name contains an digit!\nYour input : " + name + "\nPlease try again:";
    }
}

/**
 * Custom Exception is invoked when the input roll number already exists.
 * Input: NonUniqueRollNumberException(int a), where a is the non-unique roll number.
 * Output: Returns a string description for the exception and the cause.
 */
 class NonUniqueRollNumberException extends Exception {
     private int rollNumber;
     NonUniqueRollNumberException(int a) {
         rollNumber = a;
     }
     @Override
     public String toString() {
         return "\nInput Roll Number already exists! Try another Roll Number.\nYour input : " + rollNumber
                + "\nPlease try again:";
    }
}


public class StudentSorterMain {
    // Scanner class instance.
    private static Scanner scanner = new Scanner(System.in);

    // Hashset instance which helps in maintaining unique rollNumbers constraint.
    private static Set<Integer> rollNumberSet = new HashSet<Integer>();

    // getRecord(float maxMarks) interacts with the user to get a Student's field values.
    // Input: maximum marks passed as a parameter.
    // Output: Returns Student object.
    // Exception(s): Throws MarksOutOfBoundsException, IncorrectNameException
    private static Student getRecord(float maxMarks) throws MarksOutOfBoundsException, IncorrectNameException, NonUniqueRollNumberException {

    // Create field variables to store values.
    int rollNumber;
    String name;
    float language1, language2, math, science, environmentalScience;

    // Get the values from the user with the aid of Scanner class.
    System.out.println("\nStudent ");
    System.out.print("Enter Roll Number\n> ");
    rollNumber = scanner.nextInt();

    // Check if the hashset already contains the input roll number
    if(rollNumberSet.contains(new Integer(rollNumber)) == true) {
        // Input rollNumber is not unique, throw NonUniqueRollNumberException.
        throw new NonUniqueRollNumberException(rollNumber);
    }

    System.out.print("Enter name\n> ");

    // Consume bad input.
    scanner.nextLine();
    name = scanner.nextLine();

    // Source : http://stackoverflow.com/questions/6344867/checking-whether-a-string-contains-a-number-value-in-java
    // If name contains any digit, throw IncorrectNameException.
    if(name.matches(".*\\d.*")){
        throw new IncorrectNameException(name);
    }

    System.out.println("Enter the following marks:");
    System.out.print("Language1\n> ");
    language1 = scanner.nextFloat();

    // If Language1 marks out of bounds, throw MarksOutOfBoundsException.
    if(language1 < 0 || language1 > maxMarks) {
        throw new MarksOutOfBoundsException(language1);
    }

    System.out.print("Language2\n> ");
    language2 = scanner.nextFloat();

    // If Language2 marks out of bounds, throw MarksOutOfBoundsException.
    if(language2 < 0 || language2 > maxMarks) {
        throw new MarksOutOfBoundsException(language2);
    }

    System.out.print("Math\n> ");
    math = scanner.nextFloat();

    // If Math marks out of bounds, throw MarksOutOfBoundsException.
    if(math < 0 || math > maxMarks) {
        throw new MarksOutOfBoundsException(math);
    }

    System.out.print("Science\n> ");
    science = scanner.nextFloat();

    // If Science marks out of bounds, throw MarksOutOfBoundsException.
    if(science < 0 || science > maxMarks) {
        throw new MarksOutOfBoundsException(science);
    }

    System.out.print("Environmental Science\n> ");
    environmentalScience = scanner.nextFloat();

    // If Environmental Science marks out of bounds, throw MarksOutOfBoundsException.
    if(environmentalScience < 0 || environmentalScience > maxMarks) {
        throw new MarksOutOfBoundsException(environmentalScience);
    }

    // After successful input, add the rollNumber to the hashset
    rollNumberSet.add(new Integer(rollNumber));
    // Return new Student object.
    return new Student(rollNumber, name, language1, language2, math, science, environmentalScience);
  }

  public static void main(String[] args) {
    // answer variable is used to take input from the user as a 'y' or 'n'(yes or no).
    char answer;
    // maxMarks variable is used to store maximum marks from the user.
    float maxMarks;
    // rank variable is used to store rank integer values, beginning from 1.
    int rank = 1;
    // Create ArrayList to store Student objects.
    ArrayList<Student> students = new ArrayList<Student>();
    //Get the Student records.
    System.out.println("\nStudent Ranking System\n");
	// Get maximum marks.
    System.out.print("Enter the maximum marks obtainable\n>");
    maxMarks = scanner.nextFloat();

    System.out.println("Enter the details of students(Minimum 5):");
    for(int i = 0; i < 5; i++) {
        try {
            Student temp = getRecord(maxMarks);
            students.add(temp);
        } catch(InputMismatchException e) {
            System.out.println("Invalid input!\nPlease try again:");
            // Consume bad input.
            scanner.next();
            // If invalid input, go back one loop and try to get the Student record again.
            i--;
        } catch(MarksOutOfBoundsException e) {
            // Will display the result from overriden toString() method.
            System.out.println(e);
            // If input marks invalid, go back one loop and try to get the Student record again.
            i--;
        } catch(IncorrectNameException e) {
	        // Will display the result from overriden toString() method.
	        System.out.println(e);
	        // If input name invalid, go back one loop and try to get the Student record again.
	        i--;
        } catch(NonUniqueRollNumberException e) {
	       // Will display the result from overriden toString() method.
	        System.out.println(e);
	       // If input name invalid, go back one loop and try to get the Student record again.
	        i--;
      }
    }

    // At this point, ArrayList has 5 Student objects.
    // Ask user for more records.
    while(true) {
        System.out.print("Do you want to insert one more record?(y/n)\n> ");
        answer = scanner.next().charAt(0);
        // If the answer is not yes, come out of the loop.
        if(Character.toLowerCase(answer) != 'y') {
            break;
        }
        try {
            Student temp = getRecord(maxMarks);
            students.add(temp);
        } catch(InputMismatchException e) {
            System.out.println("\nInvalid input!\nPlease try again:");
	        // Consume bad input
	        scanner.next();
	        // Continue the loop.
	        continue;
        } catch(MarksOutOfBoundsException e) {
            // Will display the result from overriden toString() method.
	        System.out.println(e);
        } catch(IncorrectNameException e) {
	        // Will display the result from overriden toString() method.
	        System.out.println(e);
        } catch(NonUniqueRollNumberException e) {
	        // Will display the result from overriden toString() method.
	        System.out.println(e);
      }
    }

    // Sort students list with the compare method defined in Student.
    Collections.sort(students, new Student());

    // Display the rank list.
    System.out.println("\nRank list:\n");

    for(Student temp: students) {
        System.out.println("Rank : "+(rank++));
        System.out.println(temp);
    }
  }
}
