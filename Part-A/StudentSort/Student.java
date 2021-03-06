/**
 * @author Jitesh Kumar Jha
 * @email jiteshjha96@gmail.com
 * Last Updated : 04 April 2016
 * Source(s) : https://docs.oracle.com/javase/7/docs/api/
 */

package studentsorter;

import java.util.Comparator;

/**
 * Creates a Student Class.
 * Constructor : Student(int, String, float, float, float, float, float)
 * toString() -> Description of the Student Class instance.
 * compare(Student, Student) -> returns an integer value indicating the result of a compare operation
 *                              between two Student objects in the order :
 *                              total marks, language1 marks, language2 marks, math marks, science marks, environmentalScience marks, name.
 */

public class Student implements Comparator<Student>{
  // Student field variables.
    private int rollNumber;
    private String name;
    // Student's marks field variables.
    private float language1;
    private float language2;
    private float math;
    private float science;
    private float environmentalScience;
    // Defualt constructor.
    public Student() {

    }
    // Creates an Student object with the given values.
    public Student(int rollNumber, String name, float language1, float language2, float math, float science, float environmentalScience) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.language1 = language1;
        this.language2 = language2;
        this.math = math;
        this.science = science;
        this.environmentalScience = environmentalScience;
    }

  /**
   * Get methods.
   */

   public int getRollNumber() {
       return rollNumber;
   }
   public String getName() {
       return name;
   }
   public float getLanguage1Marks() {
       return language1;
   }
   public float getLanguage2Marks() {
       return language2;
   }
   public float getMathMarks() {
       return math;
   }
   public float getScienceMarks() {
       return science;
   }
   public float getEnvironmentalScienceMarks() {
       return environmentalScience;
   }
   public float getTotal() {
       return language1 + language2 + math + science + environmentalScience;
   }

   // Returns a description about the Student object.
   @Override
   public String toString() {
       return "Roll Number: " + rollNumber + "\nName: " + name +
                    "\nLanguage1: " + getLanguage1Marks() +
                    "\nLanguage2: " + getLanguage2Marks() +
                    "\nMath: " + getMathMarks() +
                    "\nScience: " + getScienceMarks() +
                    "\nEnvironmental Science: " + getEnvironmentalScienceMarks() +
                    "\nTotal marks: " + getTotal() + "\n";
    }

    // Returns an integer value based on the comparison of two Student class objects.
    @Override
    public int compare(Student s1, Student s2) {
        // Compare total marks
        int compareStudent = new Float(s2.getTotal()).compareTo(new Float(s1.getTotal()));

        // If total marks are same, compare language1 marks.
        if(compareStudent == 0) {
            compareStudent = new Float(s2.getLanguage1Marks()).compareTo(new Float(s1.getLanguage1Marks()));
        }
        // If language1 marks are same, compare language2 marks.
        if(compareStudent == 0) {
            compareStudent = new Float(s2.getLanguage2Marks()).compareTo(new Float(s1.getLanguage2Marks()));
        }
        // If language2 marks are same, compare math marks.
        if(compareStudent == 0) {
            compareStudent = new Float(s2.getMathMarks()).compareTo(new Float(s1.getMathMarks()));
        }
        // If math marks are same, compare science marks.
        if(compareStudent == 0) {
            compareStudent = new Float(s2.getScienceMarks()).compareTo(new Float(s1.getScienceMarks()));
        }
        // If science marks are same, compare environmental science marks.
        if(compareStudent == 0) {
            compareStudent = new Float(s2.getEnvironmentalScienceMarks()).compareTo(new Float(s1.getEnvironmentalScienceMarks()));
        }
        // If the total marks and all individual subject marks are same, compare name.
        if(compareStudent == 0) {
            compareStudent = s1.getName().compareTo(s2.getName());
        }
        // Return resultant value.
        return compareStudent;
    }
}
