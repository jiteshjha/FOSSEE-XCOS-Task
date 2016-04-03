/**
 * @author Jitesh Kumar Jha
 * @email jiteshjha96@gmail.com
 * Last Updated : 03 April 2016
 */

package studentsorter;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

/**
 * Creates a Student Ranking System which gets minimum 5 records and sorts it in a certain fashion.
 */

public class StudentSorterMain {
  // Scanner class instance
  private static Scanner scanner = new Scanner(System.in);
  // getRecord() interacts with the operator to get a Student's field values.
  // Returns Student object.

  private static Student getRecord() {
    //Create field variables to store values.
    int rollNumber;
    String name;
    float language1, language2, math, science, environmentalScience;

    //Get the values from the operator with the aid of Scanner class.
    System.out.println("\nStudent ");
    System.out.print("Enter Roll Number\n> ");
    rollNumber = scanner.nextInt();
    System.out.print("Enter name\n> ");
    // Consume bad input.
    scanner.nextLine();
    name = scanner.nextLine();
    System.out.println("Enter the following marks:");
    System.out.print("Language1\n> ");
    language1 = scanner.nextFloat();
    System.out.print("Language2\n> ");
    language2 = scanner.nextFloat();
    System.out.print("Math\n> ");
    math = scanner.nextFloat();
    System.out.print("Science\n> ");
    science = scanner.nextFloat();
    System.out.print("Environmental Science\n> ");
    environmentalScience = scanner.nextFloat();
    //return new Student object.
    return new Student(rollNumber, name, language1, language2, math, science, environmentalScience);
  }

  public static void main(String[] args) {
    // Answer variable is used to take input from the user as a 'y' or 'n'(yes or no).
    char answer;
    // Create ArrayList to store Student objects.
    ArrayList<Student> students = new ArrayList<Student>();
    //Get the Student records.
    System.out.println("Student Ranking System");
    System.out.println("Enter the details of students(Minimum 5):");
    for(int i = 0; i < 5; i++) {
      try {
        Student temp = getRecord();
        students.add(temp);
      } catch(InputMismatchException e) {
        System.out.println("Invalid input!\nPlease try again:");
        // Consume bad input.
        scanner.next();
        // If invalid input, go back one loop and try to get the Student record again.
        i--;
      }
    }

    // At this point, ArrayList has 5 Student objects.
    // Ask Operator for more records.
    while(true) {
      System.out.print("Do you want to insert one more record?(y/n)\n> ");
      answer = scanner.next().charAt(0);
      // If the answer is not yes, come out of the loop.
      if(Character.toLowerCase(answer) != 'y') {
        break;
      }
      try {
        Student temp = getRecord();
        students.add(temp);
      } catch(InputMismatchException e) {
        System.out.println("Invalid input!\nPlease try again:");
	// Consume bad input
	scanner.next();
	// Continue the loop.
	continue;
      }

    }
    // Sort students list with the Compare function defined in Student.
    Collections.sort(students, new Student());
    // Display the sorted records.
    System.out.println("\nSorted Records:\n");
    for(Student temp: students) {
      System.out.println(temp);
    }
  }
}
