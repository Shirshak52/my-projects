public class Student
{
    private String dateOfBirth; 
    private String studentName;
    private String courseName;
    private String dateOfEnrollment;
    
    private int enrollmentID; 
    private int courseDuration;
    private int tuitionFee;
    
    
    
    // constructor
    public Student(String dateOfBirth, String studentName, int courseDuration, int tuitionFee)
    {
        this.dateOfBirth = dateOfBirth;
        this.studentName = studentName;
        this.courseDuration = courseDuration;
        this.tuitionFee = tuitionFee;
        
        enrollmentID = 0;
        courseName = " ";
        dateOfEnrollment = " ";
    }
    
    
    
    
    
    
    
    // ACCESSOR METHODS
    // accesor method for dateOfBirth
    public String getDateOfBirth()
    {
        return dateOfBirth;
    }
    
    // accesor method for studentName
    public String getStudentName()
    {
        return studentName;
    }
    
    // accesor method for courseName
    public String getCourseName()
    {
        return courseName;
    }
    
    // accesor method for dateOfEnrollment
    public String getDateOfEnrollment()
    {
        return dateOfEnrollment;
    }
    
    // accesor method for enrollmentID
    public int getEnrollmentID()
    {
        return enrollmentID;
    }
    
    // accesor method for courseDuration
    public int getCourseDuration()
    {
        return courseDuration;
    }
    
    // accesor method for tuitionFee
    public int getTuitionFee()
    {
        return tuitionFee;
    }
    
    
    
    
    
    
    
    // MUTATOR METHODS
    // mutator method for dateOfBirth
    public void setDateOfBirth(String enterDateOfBirth)
    {
        dateOfBirth = enterDateOfBirth;
    }
    
    // mutator method for courseName
    public void setCourseName(String enterCourseName)
    {
        courseName = enterCourseName;
    }
    
    // mutator method for studentName
    public void setStudentName(String enterStudentName)
    {
        studentName = enterStudentName;
    }
    
    // mutator method for dateOfEnrollment
    public void setDateOfEnrollment(String enterDateOfEnrollment)
    {
        dateOfEnrollment = enterDateOfEnrollment;
    }
    
    // mutator method for courseDuration
    public void setCourseDuration(int enterCourseDuration)
    {
        courseDuration = enterCourseDuration;
    }
    
    // mutator method for tuitionFee    
    public void setTuitionFee(int enterTuitionFee)
    {
        tuitionFee = enterTuitionFee;
    }
    
    // mutator method for enrollmentID
    public void setEnrollmentID(int enterEnrollmentID)
    {
        enrollmentID = enterEnrollmentID;
    }
    
    
    
    
    
    
    
    // display method
    public String display()
    {
        String displayInfo = "Student Name: " + studentName + "\n"
        +"DOB: " + dateOfBirth + "\n"
        +"Course Name: " + courseName + "\n"
        +"Course Duration (in months): " + courseDuration + "\n"
        +"Date of enrollment: " + dateOfEnrollment + "\n"
        +"Enrollment ID: " + enrollmentID + "\n"
        +"Tuition Fee: " + tuitionFee + "\n";

        if (dateOfBirth.isEmpty() || studentName.isEmpty() || courseName.isEmpty() || dateOfEnrollment.isEmpty() || enrollmentID == 0 || courseDuration == 0 || tuitionFee == 0){
            displayInfo += "Please fill in all required fields \n" ;
        }
        
        return displayInfo;
    }
}
