/*  |------Code by Joseph Vusumzi Duda------|
    |---------dudajoseph@gmail.com----------|
    |-----Task 2 for CodSoft Internship-----|
                                               STUDENT GRADE CALCULATOR
###################################################################################################################################
1. Take marks obtained (out of 100) in each subject.
2. Sum up the marks obtained in all subjects.
3. Divide the total marks by the total number of subjects to get the average percentage.
4. Assign grades based on the average percentage achieved.
5. Show the total marks, average percentage, and the corresponding grade to the user.
####################################################################################################################################
*/           
import java.util.*;

public class GradeCalculator{
   public static void main(String[] args){
      // Create Scanner object
      Scanner input = new Scanner(System.in); 
      int n,d,c=1;// number of courses
      int sum=0; // initialize the total sum of marks
      ArrayList<StudentGrade> report =new ArrayList<StudentGrade>(); // arraylist containing report for each mark
      
      System.out.println("|#####################################################|");
      System.out.println("|-------WELCOME TO THE STUDENT GRADE CALCULATOR-------|");
      System.out.println("|#####################################################|");
      System.out.println("| This is a System for calculating your grades.       |");
      System.out.println("|                                  jvd.systems@codsoft|");
      System.out.println("|#####################################################|");
      System.out.println("[Please Enter your name:]");
      System.out.print("~");
      String name =input.nextLine(); 
      System.out.println();
      
      while(true){
         System.out.println("[Enter number of subject(s).]");
           try{ 
             // Tell user to enter an integer from 0 to 100
             System.out.print(">>");
             int num_of_subjects = input.nextInt();
             if (!(num_of_subjects>0)){
                System.out.println("[Subjects cannot be less than 1.]");
                System.out.println(); 
                continue;
             }
             else{System.out.println("[Number of Subjects stored successfully.]");n=num_of_subjects;d=num_of_subjects; break;}
           }
           // Tell user to enter an integer if they enter a string
           catch(InputMismatchException e){
              System.out.println("[Enter an integer, integer>=1.]");      
              System.out.println();
              input.nextLine();
              continue;
          }
      }
      while(true){
           try{ 
             System.out.println();
             System.out.println("[Enter subject name"+'('+c+')'+".]");
             System.out.print("~");
             String subject = input.next();
             input.nextLine();
             // Tell user to enter an integer from 0 to 100
             System.out.println("[Enter mark for "+subject+", 0<= mark <=100.]");
             System.out.print(">>");
             int mark = input.nextInt();
             if (!(mark>=0 && mark<=100)){
                System.out.println("[Try again, 0<= mark <=100.]"); 
                continue;
             }
             else{
                report.add(new StudentGrade(subject,mark));
                Collections.sort(report);             
                System.out.println("["+subject+"'s mark recorded successfully.]");
                sum+=mark;n--;c++;               
                if (n==0){break;}
                else{continue;}
            }
          }
           // Tell user to enter an integer if they enter a string
          catch(InputMismatchException e){
             System.out.println("[Enter an integer.]");      
             input.nextLine();
             continue;
         }
      }
      System.out.println();
      System.out.println("|#####################################################");
      System.out.println("|        Student Grade Report for: "+name+".");
      System.out.println("|#####################################################");
      for(StudentGrade grade:report){
         System.out.println("|-----------------------------------------------------");
         System.out.println(grade);
         
      }
      System.out.println("|-----------------------------------------------------");
      System.out.println("|#####################################################");
      System.out.println("|                                  jvd.systems@codsoft");
      System.out.println("|#####################################################");
      System.out.println("|Total mark:"+sum+" for "+d+" subject(s)");
      System.out.println("|-----------------------------------------------------");
      System.out.println(new StudentGrade(("|Average"),(sum/d)));
      System.out.println("|#####################################################");
      
   }
}   


// create a class for a student marks
class StudentGrade implements Comparable<StudentGrade>{
   private String subject;  // name of subject
   private int mark;  // mark in % out of 100
   private int grade;  // corresponding garde to the mark
    
   // create a no argument constructor
   public StudentGrade(){
      this.subject="Subject Uknown";
      this.mark=0;
      this.grade=1;
   }
    
   // create an argument constructor
   public StudentGrade(String subject,int mark){
      this.subject=subject;
      this.mark=mark;
      if(mark>=0 && mark<29){this.grade=1;}
      else if(mark>=30 && mark<40){this.grade=2;}
      else if(mark>=40 && mark<50){this.grade=3;}
      else if(mark>=50 && mark<60){this.grade=4;}
      else if(mark>=60 && mark<70){this.grade=5;}
      else if(mark>=70 && mark<80){this.grade=6;}
      else if(mark>=80 && mark<=100){this.grade=7;}
   }
   
   // Accessor Methods
   public String getSubject(){ return subject;} 
   public int getMark(){ return mark;}
   public int getGrade(){ return grade;}
   
   //toString Method for printing
   public String toString(){
      if (getSubject().equals("|Average")){return getSubject()+" Mark:"+getMark()+"%, "+" Grade:"+getGrade();}
      else{return  "|Subject: "+getSubject()+", Mark:"+getMark()+"%,"+" Grade:"+getGrade();}
   }
   
   //Equals Method
   public boolean equals (Object o){
      if(o==null){return false;}
      else if (!(o instanceof StudentGrade)){ return false;}
      else{
         StudentGrade other = (StudentGrade)o;
         return(this.mark==other.getMark()&&this.grade==other.getGrade()&&this.subject.equals(other.getSubject()));  
      }
   }
   
   //CompareTo Method
   public int compareTo (StudentGrade other){return Integer.compare(getMark(),other.getMark());}
}                                 