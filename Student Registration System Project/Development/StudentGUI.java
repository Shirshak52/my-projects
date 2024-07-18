import javax.swing.*;//importing swing package
import java.util.ArrayList;//importing arraylist package
import java.awt.event.*;//importing awt package
import java.awt.Font;//importing Font class
import java.awt.Color;//importing Color class

public class StudentGUI implements ActionListener
{
    //DECLARING COMPONENTS--------------------------------------------------------------------------------------------------------------------
    
    //FRAME------------------------------------------------------------------------------------------------------------------------
    private JFrame f;  
    //FRAME END--------------------------------------------------------------------------------------------------------------------

    
    
    
    //PANELS-----------------------------------------------------------------------------------------------------------------------
    private JPanel regStudp, dropoutStudp;
    //PANELS END-------------------------------------------------------------------------------------------------------------------
    
    
    
    
    //TABBED PANE------------------------------------------------------------------------------------------------------------------
    private JTabbedPane tabbedP;
    //TABBED PANE END--------------------------------------------------------------------------------------------------------------
    
    
    
    
    
    //LABELS-----------------------------------------------------------------------------------------------------------------------
    
    //REGULAR STUDENT PANEL
    private JLabel regStudHeaderlb, 
    
    regStudNamelb, regEnrIDlb, regCourseNamelb, regCourseDurationlb, 
    regTuitionFeelb, regDateOfBirthlb, regDateOfEnrollmentlb,
    
    numOfModuleslb, numOfCreditHourslb, daysPresentlb,
    
    presentPercentageEnrIDlb, presentPercentageDaysPresentlb,
    grantCertEnrIDlb, grantCertDateOfEnrollmentlb, grantCertCourseNamelb;
    
    //DROPOUT STUDENT PANEL
    private JLabel dropoutStudHeaderlb, 
    
    dropoutStudNamelb, dropoutEnrIDlb, dropoutCourseNamelb, dropoutCourseDurationlb, 
    dropoutTuitionFeelb, dropoutDateOfBirthlb, dropoutDateOfEnrollmentlb,
    
    dateOfDropoutlb, numOfRemainingModuleslb, numOfMonthsAttendedlb, remainingAmountlb,
    payBillsEnrIDlb, removeStudEnrIDlb;
    
    //LABELS END-------------------------------------------------------------------------------------------------------------------
    
    
    
    
    
    //TEXTFIELDS-------------------------------------------------------------------------------------------------------------------
    
    //REGULAR STUDENT PANEL
    private JTextField regStudNametf, regEnrIDtf, regCourseNametf,
    regCourseDurationtf, regTuitionFeetf, 
    numOfModulestf, numOfCreditHourstf, daysPresenttf,
    
    presentPercentageEnrIDtf, presentPercentageDaysPresenttf,
    grantCertEnrIDtf, grantCertCourseNametf;
    
    //DROPOUT STUDENT PANEL
    private JTextField dropoutStudNametf, dropoutEnrIDtf, dropoutCourseNametf, dropoutCourseDurationtf, dropoutTuitionFeetf,
    numOfRemainingModulestf, numOfMonthsAttendedtf, remainingAmounttf,
    
    payBillsEnrIDtf, removeStudEnrIDtf;
    
    //TEXTFIELDS END---------------------------------------------------------------------------------------------------------------
    
    
    
    
    //COMBO BOXES------------------------------------------------------------------------------------------------------------------
    
    //REGULAR STUDENT PANEL
    private JComboBox<String> regYearOfBirthcb, regMonthOfBirthcb, regDayOfBirthcb, 
    regYearOfEnrollmentcb, regMonthOfEnrollmentcb, regDayOfEnrollmentcb,
    grantCertYearOfEnrollmentcb, grantCertMonthOfEnrollmentcb, grantCertDayOfEnrollmentcb;
    
    //DROPOUT STUDENT PANEL
    private JComboBox<String> dropoutYearOfBirthcb, dropoutMonthOfBirthcb, dropoutDayOfBirthcb, 
    dropoutYearOfEnrollmentcb, dropoutMonthOfEnrollmentcb, dropoutDayOfEnrollmentcb,
    yearOfDropoutcb, monthOfDropoutcb, dayOfDropoutcb;
    
    //COMBO BOXES END--------------------------------------------------------------------------------------------------------------
    
    
    
    
    //BUTTONS----------------------------------------------------------------------------------------------------------------------
    
    //REGULAR STUDENT PANEL
    private JButton addRegStudbtn, presentPercentagebtn, grantCertbtn, 
    regDisplaybtn, regClearbtn;
    
    //DROPOUT STUDENT PANEL
    private JButton addDropoutStudbtn, removeStudbtn, payBillsbtn,
    dropoutDisplaybtn, dropoutClearbtn;
    
    //BUTTONS END------------------------------------------------------------------------------------------------------------------
    
    
    
    

    //VARIABLES FOR BUTTON FUNCTIONALITY-------------------------------------------------------------------------------------------
    
    //REGULAR STUDENT PANEL
    //Strings
    private String regStudName, regDateOfBirth, regDateOfEnrollment, regCourseName,
    grantCertDateOfEnrollment, grantCertCourseName,
    
    regYearOfBirth, regMonthOfBirth, regDayOfBirth,
    regYearOfEnrollment, regMonthOfEnrollment, regDayOfEnrollment,
        
    grantCertYearOfEnrollment, grantCertMonthOfEnrollment, grantCertDayOfEnrollment;
     
    //integers
    private int regEnrID, regCourseDuration, regTuitionFee, numOfModules, numOfCreditHours, daysPresent,
    presentPercentageEnrID, presentPercentageDaysPresent, grantCertEnrID;
    
    
    
     
    //DROPOUT STUDENT PANEL
    //Strings
    private String dropoutStudName, dropoutDateOfBirth, dropoutDateOfEnrollment, dropoutCourseName, dateOfDropout,
    
    dropoutYearOfBirth, dropoutMonthOfBirth, dropoutDayOfBirth,
    dropoutYearOfEnrollment, dropoutMonthOfEnrollment, dropoutDayOfEnrollment,
    yearOfDropout, monthOfDropout, dayOfDropout;
   
    //integers
    private int dropoutEnrID, dropoutCourseDuration, dropoutTuitionFee, numOfRemainingModules, numOfMonthsAttended, remainingAmount,
    payBillsEnrID, removeStudEnrID;
    
    //VARIABLES FOR BUTTON FUNCTIONALITY END-------------------------------------------------------------------------------------
    
    
    
    
    //ARRAYLIST--------------------------------------------------------------------------------------------------------------------
    private ArrayList<Student> studList = new ArrayList<Student>();
    //ARRAYLIST END----------------------------------------------------------------------------------------------------------------
    
    
    //DECLARING COMPONENTS END---------------------------------------------------------------------------------------------------------------------
    public StudentGUI()//CONSTRUCTOR
    {
        //CREATING COMPONENTS-------------------------------------------------------------------------------------------------------------------
        
        //FRAME------------------------------------------------------------------------------------------------------------
        
        f = new JFrame("Student GUI");
        
        //FRAME END--------------------------------------------------------------------------------------------------------
        
        
        
        
        
        //PANELS-------------------------------------------------------------------------------------------------------------
        
        regStudp = new JPanel();//regular student panel
        dropoutStudp = new JPanel();//dropout student panel
        
        //PANELS END----------------------------------------------------------------------------------------------------------
        

        
        
        
        
        //LABELS---------------------------------------------------------------------------------------------------------------
        
        //REGULAR PANEL
        regStudHeaderlb = new JLabel("Regular Student");//panel header
        regStudHeaderlb.setFont(new Font("Arial",Font.BOLD,25));//setting the font of panel header
        
        regStudNamelb = new JLabel("Student Name");//student name
        regEnrIDlb = new JLabel("Enrollment ID");//enrollment ID
        presentPercentageEnrIDlb = new JLabel("Enrollment ID");//enrollment ID for present percentage
        regCourseNamelb = new JLabel("Course Name");//course name
        regCourseDurationlb = new JLabel("Course Duration");//course duration
        regTuitionFeelb = new JLabel("Tuition Fee");//tuition fee
        regDateOfBirthlb = new JLabel("Date of Birth");//date of birth
        regDateOfEnrollmentlb = new JLabel("Date of Enrollment");//date of enrollment
        
        grantCertEnrIDlb = new JLabel("Enrollment ID");//enrollment ID for grant certificate
        grantCertDateOfEnrollmentlb = new JLabel("Date of Enrollment");//date of enrollment for grant certificate
        grantCertCourseNamelb = new JLabel("Course Name");//course name for grant certificate
        
        numOfModuleslb = new JLabel("Number of Modules");//num of modules
        numOfCreditHourslb = new JLabel("Number of Credit Hours");//num of credit hours
        daysPresentlb = new JLabel("Number of Days Present");//number of days present
        presentPercentageDaysPresentlb = new JLabel("Number of Days Present");//number of days present for present percentage
        
        
        
        //DROPOUT PANEL
        dropoutStudHeaderlb = new JLabel("Dropout Student");//panel header
        dropoutStudHeaderlb.setFont(new Font("Arial",Font.BOLD,25));//setting the font of panel header
        
        dropoutStudNamelb = new JLabel("Student Name");//student name
        dropoutEnrIDlb = new JLabel("Enrollment ID");//enrollment ID
        dropoutCourseNamelb = new JLabel("Course Name");//course name
        dropoutCourseDurationlb = new JLabel("Course Duration");//course duration
        dropoutTuitionFeelb = new JLabel("Tuition Fee");//tuition fee
        dropoutDateOfBirthlb = new JLabel("Date of Birth");//date of birth
        dropoutDateOfEnrollmentlb = new JLabel("Date of Enrollment");//date of enrollment
        
        dateOfDropoutlb = new JLabel("Date of Dropout");//date of dropout
        numOfRemainingModuleslb = new JLabel("Number of Remaining Modules");//num of remaining modules
        numOfMonthsAttendedlb = new JLabel("Number of Months Attended");//num of months attended
        remainingAmountlb = new JLabel("Remaining Amount");//remaining amount
        
        payBillsEnrIDlb = new JLabel("Enrollment ID");//enrollment ID for pay bills
        removeStudEnrIDlb = new JLabel("Enrollment ID");//enrollment ID for remove student
        
        //LABELS END---------------------------------------------------------------------------------------------------------
        
        
        
        
        
        
        //TEXTFIELDS----------------------------------------------------------------------------------------------------------
        
        //REGULAR PANEL
        regStudNametf = new JTextField();//student name
        regEnrIDtf = new JTextField();//enrollment ID
        presentPercentageEnrIDtf = new JTextField();//enrollment ID for present percentage
        regCourseNametf = new JTextField();//course name
        regCourseDurationtf = new JTextField();//course duration
        regTuitionFeetf = new JTextField();//tuition fee 
        
        grantCertEnrIDtf = new JTextField();//enrollment ID for grant certificate
        grantCertCourseNametf = new JTextField();//course name for grant certificate
        
        numOfModulestf = new JTextField();//num of modules
        numOfCreditHourstf = new JTextField();//num of credit hours
        daysPresenttf = new JTextField();//num of days present
        
        presentPercentageDaysPresenttf = new JTextField();//num of days present for present percentage
        
        
        //DROPOUT PANEL
        dropoutStudNametf = new JTextField();//student name
        dropoutEnrIDtf = new JTextField();//enrollment ID
        dropoutCourseNametf = new JTextField();//course name
        dropoutCourseDurationtf = new JTextField();//course duration
        dropoutTuitionFeetf = new JTextField();//tuition fee
        
        numOfRemainingModulestf = new JTextField();//num of remaining modules
        numOfMonthsAttendedtf = new JTextField();//num of months attended
        remainingAmounttf = new JTextField();//remaining amount
        
        payBillsEnrIDtf = new JTextField();//enrollment ID for pay bills
        removeStudEnrIDtf = new JTextField();//enrollment ID for remove student
        
        //TEXTFIELDS END--------------------------------------------------------------------------------------------------------
        
        
        
        
        
        
        //BUTTONS---------------------------------------------------------------------------------------------------------------
        
        //REGULAR PANEL
        addRegStudbtn = new JButton("Add Regular Student");//add a regular student
        presentPercentagebtn = new JButton("Present Percentage");//calculate present percentage
        grantCertbtn = new JButton("Grant Certificate");//grant certificate
       
        regDisplaybtn = new JButton("Display");//display 
        regClearbtn = new JButton("Clear Fields");//clear fields
        
        
        //DROPOUT PANEL
        addDropoutStudbtn = new JButton("Add Dropout Student");//add a dropout student
        payBillsbtn = new JButton("Pay Bills");//pay bills
        removeStudbtn = new JButton("Remove Student");//remove a student
        
        dropoutDisplaybtn = new JButton("Display");//display 
        dropoutClearbtn = new JButton("Clear Fields");//clear fields
        
        //BUTTONS END-----------------------------------------------------------------------------------------------------------
        
        
        
        
        
        
        
        //COMBO BOXES-----------------------------------------------------------------------------------------------------------
        
        //ARRAYS FOR COMBO BOXES-------------------------------------------------------------
        String[] yearar = new String[50];//years  
        String[] monthar = new String[12];//months
        String[] dayar = new String[31];//days
        
                
        
        
    
        
        //ADDING VALUES TO THE ARRAYS----------------------------------------------------------------
        //adding years to the year array
        int year = 1990;
        for(int i=0; i<50; i++){
            yearar[i] = String.valueOf(year);
            year++;
        }
        
        //adding months to the month array
        int month = 1;
        for(int i=0; i<=11; i++){
            monthar[i] = String.valueOf(month);
            month++;
        }
        
        //adding days to the day array
        int day = 1;
        for(int i=0; i<=30; i++){
            dayar[i] = String.valueOf(day);
            day++;
        }
        //ADDING VALUES TO THE ARRAYS END-----------------------------------------------------------------
        
        
        
        //CREATING COMBO BOXES----------------------------------------------------------------------------
        
        //REGULAR PANEL
        regYearOfBirthcb = new JComboBox<String>(yearar);//year of birth
        regMonthOfBirthcb = new JComboBox<String>(monthar);//month of birth
        regDayOfBirthcb = new JComboBox<String>(dayar);//day of birth

        regYearOfEnrollmentcb = new JComboBox<String>(yearar);//year of enrollment
        regMonthOfEnrollmentcb = new JComboBox<String>(monthar);//month of enrollment
        regDayOfEnrollmentcb = new JComboBox<String>(dayar);//day of enrollment
        
        grantCertYearOfEnrollmentcb = new JComboBox<String>(yearar);//year of enrollment for grant certificate
        grantCertMonthOfEnrollmentcb = new JComboBox<String>(monthar);//month of enrollment for grant certificate
        grantCertDayOfEnrollmentcb = new JComboBox<String>(dayar);//day of enrollment for grant certificate
        
        
        //DROPOUT PANEL
        dropoutYearOfBirthcb = new JComboBox<String>(yearar);//year of birth
        dropoutMonthOfBirthcb = new JComboBox<String>(monthar);//month of birth
        dropoutDayOfBirthcb = new JComboBox<String>(dayar);//day of birth

        dropoutYearOfEnrollmentcb = new JComboBox<String>(yearar);//year of enrollment
        dropoutMonthOfEnrollmentcb = new JComboBox<String>(monthar);//month of enrollment
        dropoutDayOfEnrollmentcb = new JComboBox<String>(dayar);//day of enrollment
        
        yearOfDropoutcb = new JComboBox<String>(yearar);//year of dropout
        monthOfDropoutcb = new JComboBox<String>(monthar);//month of dropout
        dayOfDropoutcb = new JComboBox<String>(dayar);//day of dropout
        
        //CREATING COMBO BOXES END------------------------------------------------------------------------
        
        //COMBO BOXES END---------------------------------------------------------------------------------------------------------
        
        //CREATING COMPONENTS END------------------------------------------------------------------------------------------------------------------
        
        
        
        
        
        
        
        
        //SETTING BOUNDS OF COMPONENTS-------------------------------------------------------------------------------------------------------------        
        
        //REGULAR PANEL
        regStudHeaderlb.setBounds(550,20,200,25);//panel header
        
        regEnrIDlb.setBounds(20,80,100,20);//enrollment ID label
        regEnrIDtf.setBounds(170,80,150,20);//enrollment ID textfield
        
        regStudNamelb.setBounds(20,120,100,20);//student name label
        regStudNametf.setBounds(170,120,150,20);//student name textField
        
        regDateOfBirthlb.setBounds(20,160,100,20);//date of birth label
        regYearOfBirthcb.setBounds(170,160,100,20);//year of birth combo box
        regMonthOfBirthcb.setBounds(280,160,100,20);//month of birth combo box
        regDayOfBirthcb.setBounds(390,160,100,20);//day of birth combo box
        
        regDateOfEnrollmentlb.setBounds(20,200,150,20);//date of enrollment label
        regYearOfEnrollmentcb.setBounds(170,200,100,20);//year of enrollment combo box
        regMonthOfEnrollmentcb.setBounds(280,200,100,20);//month of enrollment combo box
        regDayOfEnrollmentcb.setBounds(390,200,100,20);//day of enrollment combo box
        
        regCourseNamelb.setBounds(20,240,100,20);//course name label
        regCourseNametf.setBounds(170,240,150,20);//course name textfield
        
        regCourseDurationlb.setBounds(20,280,100,20);//course duration label
        regCourseDurationtf.setBounds(170,280,150,20);//course duration textfield
        
        regTuitionFeelb.setBounds(20,320,100,20);//tuition fee label
        regTuitionFeetf.setBounds(170,320,150,20);//tuition fee text field
        
        numOfModuleslb.setBounds(600,80,150,20);//num of modules label
        numOfModulestf.setBounds(770,80,150,20);//num of modules textfield
        
        numOfCreditHourslb.setBounds(600,120,150,20);//num of credit hours label
        numOfCreditHourstf.setBounds(770,120,150,20);//num of credit hours textfield
        
        daysPresentlb.setBounds(600,160,150,20);//num of days present label
        daysPresenttf.setBounds(770,160,150,20);//num of days present textfield
        
        addRegStudbtn.setBounds(675,200,170,30);//add regular student button
        
        presentPercentageEnrIDlb.setBounds(20,440,150,20);//enrollment ID label for present percentage
        presentPercentageEnrIDtf.setBounds(170,440,150,20);//enrollment ID textfield for present percentage
        
        presentPercentageDaysPresentlb.setBounds(20,480,150,20);//days present label for present percentage
        presentPercentageDaysPresenttf.setBounds(170,480,150,20);//days present textfield for present percentage
        
        presentPercentagebtn.setBounds(80,520,170,30);//calculate present percentage btn
        
        grantCertEnrIDlb.setBounds(600,400,100,20);//enrollment ID label for grant certificate
        grantCertEnrIDtf.setBounds(770,400,150,20);//enrollment ID text field for grant certificate
        
        grantCertDateOfEnrollmentlb.setBounds(600,440,150,20);//date of enrollment label for grant certificate
        grantCertYearOfEnrollmentcb.setBounds(770,440,100,20);//year of enrollment combo box for grant certificate
        grantCertMonthOfEnrollmentcb.setBounds(880,440,100,20);//month of enrollment combo box for grant certificate
        grantCertDayOfEnrollmentcb.setBounds(990,440,100,20);//day of enrollment combo box for grant certificate
        
        grantCertCourseNamelb.setBounds(600,480,100,20);//course name label for grant certificate
        grantCertCourseNametf.setBounds(770,480,150,20);//course name text field for grant certificate
        
        grantCertbtn.setBounds(680,520,170,30);//grant certificate button
        
        regDisplaybtn.setBounds(1060,600,100,25);//display button
        regClearbtn.setBounds(1170,600,100,25);//clear button
        
        
        
        //DROPOUT PANEL        
        dropoutStudHeaderlb.setBounds(550,20,200,25);//panel header
        
        dropoutEnrIDlb.setBounds(20,80,100,20);//enrollment ID label
        dropoutEnrIDtf.setBounds(170,80,150,20);//enrollment ID textfield
        
        dropoutStudNamelb.setBounds(20,120,100,20);//student name label
        dropoutStudNametf.setBounds(170,120,150,20);//student name textfield
        
        dropoutDateOfBirthlb.setBounds(20,160,100,20);//date of birth label
        dropoutYearOfBirthcb.setBounds(170,160,100,20);//year of birth combo box
        dropoutMonthOfBirthcb.setBounds(280,160,100,20);//month of birth combo box
        dropoutDayOfBirthcb.setBounds(390,160,100,20);//day of birth combo box
        
        dropoutDateOfEnrollmentlb.setBounds(20,200,150,20);//date of enrollment label
        dropoutYearOfEnrollmentcb.setBounds(170,200,100,20);//year of enrollment combo box
        dropoutMonthOfEnrollmentcb.setBounds(280,200,100,20);//month of enrollment combo box
        dropoutDayOfEnrollmentcb.setBounds(390,200,100,20);//day of enrollment combo box
        
        dropoutCourseNamelb.setBounds(20,240,100,20);//course name label
        dropoutCourseNametf.setBounds(170,240,150,20);//course name textfield
        
        dropoutCourseDurationlb.setBounds(20,280,100,20);//course duration label
        dropoutCourseDurationtf.setBounds(170,280,150,20);//course duration textfield
        
        dropoutTuitionFeelb.setBounds(20,320,100,20);//tuition fee label
        dropoutTuitionFeetf.setBounds(170,320,150,20);//tuition fee textfield
        
        numOfRemainingModuleslb.setBounds(600,80,200,20);//number of remaining modules label
        numOfRemainingModulestf.setBounds(800,80,150,20);//number of remaining modules textfield
        
        numOfMonthsAttendedlb.setBounds(600,120,200,20);//number of months attended label
        numOfMonthsAttendedtf.setBounds(800,120,150,20);//number of months attended label
        
        remainingAmountlb.setBounds(600,160,150,20);//remaining amount label
        remainingAmounttf.setBounds(800,160,150,20);//remaining amount textfield
        
        dateOfDropoutlb.setBounds(600,200,100,20);//date of dropout label
        yearOfDropoutcb.setBounds(800,200,100,20);//year of dropout combo box
        monthOfDropoutcb.setBounds(910,200,100,20);//month of dropout combo box
        dayOfDropoutcb.setBounds(1020,200,100,20);//day of dropout combo box
        
        addDropoutStudbtn.setBounds(675,240,170,30);//add dropout student button
        
        payBillsEnrIDlb.setBounds(20,480,100,20);//enrollment ID label for pay bills
        payBillsEnrIDtf.setBounds(170,480,150,20);//enrollment ID text field for pay bills
        payBillsbtn.setBounds(80,520,170,30);//pay bills btn
        
        removeStudEnrIDlb.setBounds(620,480,100,20);//enrollment ID label for remove student
        removeStudEnrIDtf.setBounds(770,480,150,20);//enrollment ID text field for remove student
        removeStudbtn.setBounds(680,520,170,30);//remove student button
        
        dropoutDisplaybtn.setBounds(1060,600,100,25);//display button
        dropoutClearbtn.setBounds(1170,600,100,25);//clear button
        
        //SETTING BOUNDS OF COMPONENTS END--------------------------------------------------------------------------------------------------------
        
        
        
        
        
        //REGISTERING BUTTONS WITH ACTION LISTENERS-----------------------------------------------------------------------------------------------    
        
        //REGULAR PANEL
        addRegStudbtn.addActionListener(this);//add regular student button
        presentPercentagebtn.addActionListener(this);//present percentage button
        grantCertbtn.addActionListener(this);//grant certificate button
        
        regDisplaybtn.addActionListener(this);//display button
        regClearbtn.addActionListener(this);//clear button
        
        
        //DROPOUT PANEL
        addDropoutStudbtn.addActionListener(this);//add dropout student button
        payBillsbtn.addActionListener(this);//pay bills button
        removeStudbtn.addActionListener(this);//remove student button
        
        dropoutDisplaybtn.addActionListener(this);//display button
        dropoutClearbtn.addActionListener(this);//clear button
        
        //REGISTERING BUTTONS WITH ACTION LISTENERS END------------------------------------------------------------------------------------------
        
        
        
        
        
        
        //ADDING COMPONENTS TO PANELS------------------------------------------------------------------------------------------------------------        
        
        //REGULAR PANEL
        regStudp.add(regStudHeaderlb);//panel header
        
        regStudp.add(regEnrIDlb);//enrollment ID label
        regStudp.add(regEnrIDtf);//enrollment ID textfield
        
        regStudp.add(regStudNamelb);//student name label
        regStudp.add(regStudNametf);//student name textfield
        
        regStudp.add(regDateOfBirthlb);//date of birth label
        regStudp.add(regYearOfBirthcb);//year of birth combo box
        regStudp.add(regMonthOfBirthcb);//month of birth combo box
        regStudp.add(regDayOfBirthcb);//day of birth combo box
                
        regStudp.add(regDateOfEnrollmentlb);//date of enrollment label
        regStudp.add(regYearOfEnrollmentcb);//year of enrollment combo box
        regStudp.add(regMonthOfEnrollmentcb);//month of enrollment combo box
        regStudp.add(regDayOfEnrollmentcb);//day of enrollment combo box
        
        regStudp.add(regCourseNamelb);//course name label
        regStudp.add(regCourseNametf);//course name textfield
        
        regStudp.add(regCourseDurationlb);//course duration label
        regStudp.add(regCourseDurationtf);//course duration textfield
        
        regStudp.add(numOfModuleslb);//num of modules label
        regStudp.add(numOfModulestf);//num of modules textfield
        
        regStudp.add(numOfCreditHourslb);//num of credit hours label
        regStudp.add(numOfCreditHourstf);//num of credit hours textfield
        
        regStudp.add(regTuitionFeelb);//tuition fee label
        regStudp.add(regTuitionFeetf);//tuition fee textfield
        
        regStudp.add(daysPresentlb);//num of days present label
        regStudp.add(daysPresenttf);//num of days present textfield
        
        regStudp.add(addRegStudbtn);//add regular student button
        
        regStudp.add(presentPercentageEnrIDlb);//enrollment ID label for present percentage
        regStudp.add(presentPercentageEnrIDtf);//enrollment ID textfield for present percentage
        
        regStudp.add(presentPercentageDaysPresentlb);//number of days present label for present percentage
        regStudp.add(presentPercentageDaysPresenttf);//number of days present textfield for present percentage
        
        regStudp.add(presentPercentagebtn);//calculate present percentage button
        
        regStudp.add(grantCertEnrIDlb);//enrollment ID label for grant certificate
        regStudp.add(grantCertEnrIDtf);//enrollment ID text field for grant certificate
        
        regStudp.add(grantCertDateOfEnrollmentlb);//date of enrollment label for grant certificate 
        regStudp.add(grantCertYearOfEnrollmentcb);//year of enrollment combo box for grant certificate 
        regStudp.add(grantCertMonthOfEnrollmentcb);//month of enrollment combo box for grant certificate
        regStudp.add(grantCertDayOfEnrollmentcb);//day of enrollment combo box for grant certificate
        
        regStudp.add(grantCertCourseNamelb);//course name label for grant certificate 
        regStudp.add(grantCertCourseNametf);//course name text field for grant certificate 
        
        regStudp.add(grantCertbtn);//grant certificate button
        
        regStudp.add(regDisplaybtn);//display button
        regStudp.add(regClearbtn);//clear button
        
        
        
        //DROPOUT PANEL
        dropoutStudp.add(dropoutStudHeaderlb);//panel header
        
        dropoutStudp.add(dropoutEnrIDlb);//enrollment ID label
        dropoutStudp.add(dropoutEnrIDtf);//enrollment ID textfield
        
        dropoutStudp.add(dropoutStudNamelb);//student name label
        dropoutStudp.add(dropoutStudNametf);//student name textfield
        
        dropoutStudp.add(dropoutDateOfBirthlb);//date of birth label
        dropoutStudp.add(dropoutYearOfBirthcb);//year of birth combo box
        dropoutStudp.add(dropoutMonthOfBirthcb);//month of birth combo box
        dropoutStudp.add(dropoutDayOfBirthcb);//day of birth combo box
                
        dropoutStudp.add(dropoutDateOfEnrollmentlb);//date of enrollment label
        dropoutStudp.add(dropoutYearOfEnrollmentcb);//year of enrollment combo box
        dropoutStudp.add(dropoutMonthOfEnrollmentcb);//month of enrollment combo box
        dropoutStudp.add(dropoutDayOfEnrollmentcb);//day of enrollment combo box
        
        dropoutStudp.add(dropoutCourseNamelb);//course name label
        dropoutStudp.add(dropoutCourseNametf);//course name textfield
        
        dropoutStudp.add(dropoutCourseDurationlb);//course duration label
        dropoutStudp.add(dropoutCourseDurationtf);//course duration textfield
        
        dropoutStudp.add(numOfRemainingModuleslb);//num of remaining modules label
        dropoutStudp.add(numOfRemainingModulestf);//num of remaining modules textfield
        
        dropoutStudp.add(numOfMonthsAttendedlb);//num of months attended label
        dropoutStudp.add(numOfMonthsAttendedtf);//num of months attended textfield
        
        dropoutStudp.add(dropoutTuitionFeelb);//tuition fee label
        dropoutStudp.add(dropoutTuitionFeetf);//tuition fee textfield
        
        dropoutStudp.add(remainingAmountlb);//remaining amount label
        dropoutStudp.add(remainingAmounttf);//remaining amount textfield
        
        dropoutStudp.add(dateOfDropoutlb);//date of dropout label
        dropoutStudp.add(yearOfDropoutcb);//year of dropout combo box
        dropoutStudp.add(monthOfDropoutcb);//month of dropout combo box
        dropoutStudp.add(dayOfDropoutcb);//day of dropout combo box
        
        dropoutStudp.add(addDropoutStudbtn);//add dropout student button
        
        dropoutStudp.add(payBillsEnrIDlb);//enrollment ID label for pay bills
        dropoutStudp.add(payBillsEnrIDtf);//enrollment ID text field for pay bills
        dropoutStudp.add(payBillsbtn);//pay bills button
        
        dropoutStudp.add(removeStudEnrIDlb);//enrollment ID label for remove student
        dropoutStudp.add(removeStudEnrIDtf);//enrollment ID text field for remove student
        dropoutStudp.add(removeStudbtn);//remove student button
        
        dropoutStudp.add(dropoutDisplaybtn);//display button
        dropoutStudp.add(dropoutClearbtn);//clear button
        
        //ADDING COMPONENTS TO PANELS END------------------------------------------------------------------------------------------------------
        
        
        
        
        
        
        //DECORATIONS--------------------------------------------------------------------------------------------------------------------------
        
        //BACKGROUND COLOR----------------------------------------------------------------------------------------
        
        //PANELS
        regStudp.setBackground(new Color(181,245,248));//regular student panel
        dropoutStudp.setBackground(new Color(181,245,248));//dropout student panel
        
        
        //BUTTONS
        //REGULAR PANEL
        addRegStudbtn.setBackground(new Color(255,181,112));//add regular student button
        presentPercentagebtn.setBackground(new Color(255,181,112));//present percentage button
        grantCertbtn.setBackground(new Color(255,181,112));//grant certificate button
        
        regDisplaybtn.setBackground(new Color(255,204,153));//display button
        regClearbtn.setBackground(new Color(255,204,153));//clear button
        
        //DROPOUT PANEL
        addDropoutStudbtn.setBackground(new Color(255,181,112));//add dropout student button
        payBillsbtn.setBackground(new Color(255,181,112));//pay bills button
        removeStudbtn.setBackground(new Color(255,181,112));//remove student button
        
        dropoutDisplaybtn.setBackground(new Color(255,204,153));//display button
        dropoutClearbtn.setBackground(new Color(255,204,153));//clear button
        
        //BACKGROUND COLOR END---------------------------------------------------------------------------------------
        
        
        
        
        
        
        
        //BORDERS-----------------------------------------------------------------------------------------------------
        
        //TEXTFIELDS-----------------------------------------------------------------------------------
        //REGULAR PANEL
        regEnrIDtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//enrollment ID
        regStudNametf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//student name
        regCourseNametf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//course name
        regCourseDurationtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//course duration
        regTuitionFeetf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//tuition fee
        numOfModulestf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//number of modules
        numOfCreditHourstf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//number of credit hours
        daysPresenttf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//number of days present
        
        presentPercentageEnrIDtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//enrollment ID for present percentage
        presentPercentageDaysPresenttf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//number of days present for present percentage
        
        grantCertEnrIDtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//enrollment ID for grant certificate
        grantCertCourseNametf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//course name for grant certificate
        
        
        //DROPOUT PANEL
        dropoutEnrIDtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//enrollment ID
        dropoutStudNametf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//student name
        dropoutCourseNametf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//course name
        dropoutCourseDurationtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//course duration
        dropoutTuitionFeetf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//tuition fee
        numOfRemainingModulestf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//number of remaining modules
        numOfMonthsAttendedtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//number of months attended
        remainingAmounttf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//remaining amount
        
        payBillsEnrIDtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//enrollment ID for pay bills
        removeStudEnrIDtf.setBorder(BorderFactory.createLineBorder(Color.BLACK));//enrollment ID for remove student
        
        //TEXTFIELDS END---------------------------------------------------------------------------------
        
        
        
        
        //BUTTONS----------------------------------------------------------------------------------------
        //REGULAR PANEL
        addRegStudbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        
        presentPercentagebtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        grantCertbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        
        regDisplaybtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        regClearbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        
        
        //DROPOUT PANEL
        addDropoutStudbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        payBillsbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        removeStudbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        
        dropoutDisplaybtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        dropoutClearbtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));//add regular student button
        
        //BUTTONS END-------------------------------------------------------------------------------------
        
        //BORDERS END------------------------------------------------------------------------------------------------
        
        //DECORATIONS END----------------------------------------------------------------------------------------------------------------------
        
        
        
        
        
        
        
        
        //SETTING UP THE PANELS-----------------------------------------------------------------------------------------------------------------
        
        //REGULAR PANEL
        regStudp.setSize(1300,720);//setting width, height of panel
        regStudp.setLayout(null);//disabling default layout
        
        
        
        //DROPOUT PANEL
        dropoutStudp.setSize(1300,720);//setting width, height of panel
        dropoutStudp.setLayout(null);//disabling default layout
        
        //SETTING UP THE PANELS END-------------------------------------------------------------------------------------------------------------
                
        
        
        
        //ADDING PANELS TO TABBED PANE-----------------------------------------------------------------------------------------------------------
        
        tabbedP = new JTabbedPane(JTabbedPane.TOP);//creating a tabbed pane
        
        tabbedP.addTab("Regular",regStudp);//adding regular student panel
        tabbedP.addTab("Dropout",dropoutStudp);//adding dropout student panel
        
        //ADDING PANELS TO TABBED PANE END--------------------------------------------------------------------------------------------------------
        
        
        
        
        
        //SETTING UP THE TABBED PANE-------------------------------------------------------------------------------------------------------------
        
        tabbedP.setVisible(true);//displaying the tabbed pane
        tabbedP.setBounds(27,0,1300,670);//setting bounds of tabbed pane
        
        //SETTING UP THE TABBED PANE END---------------------------------------------------------------------------------------------------------
        
        
        //ADDING TABBED PANE TO FRAME
        f.add(tabbedP);
                    
        //SETTING UP THE FRAME--------------------------------------------------------------------------------------------------------------------
        
        f.setSize(1366,726);//setting width, height of frame
        f.setLayout(null);//disabling default layout
        f.setResizable(false);//disabling resizing of frame
        f.setVisible(true);//making frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//making sure the frame closes after quitting
        
        //SETTING UP THE FRAME END----------------------------------------------------------------------------------------------------------------
    }
    
    
    //ACTION PERFOERMED METHOD
    @Override
    public void actionPerformed(ActionEvent e)
    {        
        //ADDING FUNTIONALITY TO THE BUTTONS------------------------------------------------------------------------------------------------------
        //REGULAR PANEL-------------------------------------------------------------------------------------------
        //ADD REGULAR STUDENT BUTTON
        /*
         * This button first checks if any required textfields are empty, and displays a message if so
         * If not, it retrieves text from those textfields and converts them to integers where necessary
         * It then creates a new Regular object
         * It then checks if the user has entered a negative value for the enrollment ID, and displays a mesage if so
         * It then checks if the Student arraylist is empty, and directly adds the student to it and displays a message if so
         * If not, it checks if the user has entered a duplicate enrollment ID and displays a message if so
         * If not, it adds the student to the Student arraylist and displays a message
        */
        if (e.getSource() == addRegStudbtn){
            
            boolean emptyTextfields = regEnrIDtf.getText().isEmpty() || regStudNametf.getText().isEmpty() || regCourseNametf.getText().isEmpty() 
            || regCourseDurationtf.getText().isEmpty() || regTuitionFeetf.getText().isEmpty() || numOfModulestf.getText().isEmpty() 
            || numOfCreditHourstf.getText().isEmpty() || daysPresenttf.getText().isEmpty();
            
            //CHECKING IF ANY TEXTFIELDS ARE EMPTY
            if(emptyTextfields){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f, "Empty fields detected; please fill out all the fields.","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                //SETTING VARIABLES WITH TEXT FIELD VALUES--------------------------------------------------------------------------------------------
                //REGULAR PANEL
                regStudName = regStudNametf.getText();//student name
                    
                regYearOfBirth = (String) regYearOfBirthcb.getSelectedItem();//year of birth
                regMonthOfBirth = (String) regMonthOfBirthcb.getSelectedItem();//month of birth
                regDayOfBirth = (String) regDayOfBirthcb.getSelectedItem();//day of birth
                regDateOfBirth = regYearOfBirth + "-" + regMonthOfBirth + "-" + regDayOfBirth;//date of birth
                    
                regYearOfEnrollment = (String) regYearOfEnrollmentcb.getSelectedItem();//year of enrollment
                regMonthOfEnrollment = (String) regMonthOfEnrollmentcb.getSelectedItem();//month of enrollment
                regDayOfEnrollment = (String) regDayOfEnrollmentcb.getSelectedItem();//day of enrollment
                regDateOfEnrollment = regYearOfEnrollment + "-" + regMonthOfEnrollment + "-" + regDayOfEnrollment;//date of enrollment
                    
                regCourseName = regCourseNametf.getText();//course name
                    
                
                try{   
                    regEnrID = Integer.parseInt(regEnrIDtf.getText());//enrollment ID
                    
                    regCourseDuration = Integer.parseInt(regCourseDurationtf.getText());//course duration
                    regTuitionFee = Integer.parseInt(regTuitionFeetf.getText());//tuition fee
                   
                    numOfModules = Integer.parseInt(numOfModulestf.getText());//number of modules
                    numOfCreditHours = Integer.parseInt(numOfCreditHourstf.getText());//number of credit hours
                    daysPresent = Integer.parseInt(daysPresenttf.getText());//number of days present
                
                
                    //CREATING AND UPCASTING A NEW Regular STUDENT OBJECT
                    Student regStud = new Regular(regEnrID,regDateOfBirth,regCourseName,regStudName,regDateOfEnrollment,regCourseDuration,
                                      regTuitionFee,numOfModules,numOfCreditHours,daysPresent);
                    
                    //CHECKING IF THE USER ENTERS A NEGATIVE ENROLLMENT ID
                    if(regEnrID <= 0){
                        //displaying message to notify the user
                        JOptionPane.showMessageDialog(f,"Invalid enrollment ID detected; please enter a non-negative value.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else{
                        //CHECKING IF STUDENT ARRAYLIST IS EMPTY
                        if (studList.isEmpty()){
                            studList.add(regStud);//adding student to student arraylist
                            
                            //displaying message to notify the user
                            JOptionPane.showMessageDialog(f,"Successfully added regular student.","Success",JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        //IF STUDENT LIST IS NOT EMPTY
                        else{
                            boolean isDuplicate = false;//setting a flag
    
                            for(Student stud:studList){
                                
                                //IF THE STUDENT OBJECT IS AN INSTANCE OF Regular CLASS
                                if(stud instanceof Regular){
                                    
                                    //IF USER ENTERS DUPLICATE ENROLLMENT ID
                                    if(stud.getEnrollmentID() == regStud.getEnrollmentID()){
                                        isDuplicate = true;//setting the flag to true
                                        break;
                                    }
                                }
                            }
                            
                            //IF USER ENTERS UNIQUE ENROLLMENT ID
                            if(isDuplicate == false){
                                studList.add(regStud);//adding student to student list
                                
                                //displaying message to notify the user
                                JOptionPane.showMessageDialog(f,"Successfully added regular student.","Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                //displaying message to notify the user
                                JOptionPane.showMessageDialog(f,"Duplicate enrollment ID detected; please enter a valid enrollment ID",
                                                                "Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }catch(NumberFormatException regularEx){ 
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f, "Invalid input detected; please enter numbers.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //PRESENT PERCENTAGE BUTTON
        /*
         * This button first checks if any required textfields are empty, and displays a message if so
         * If not, it retrieves text from those textfields and converts them to integers where necessary
         * It then checks if there are Regular students in the Student arraylist, and displays a message if not so
         * If so, it checks if the user has entered a matching enrollment ID, and displays the attendance grade of that student if so
         * If not, it displays a message to inform the user that they entered a non-existent enrollment ID
        */
        else if(e.getSource() == presentPercentagebtn){
            
            //CHECKING IF ANY OF THE REQUIRED TEXTFIELDS ARE EMPTY
            boolean emptyTextfields = presentPercentageEnrIDtf.getText().isEmpty() || presentPercentageDaysPresenttf.getText().isEmpty();
            if(emptyTextfields){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"Empty fields detected; please fill all the required fields.","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                //SETTING VARIABLES WITH THE VALUES FROM REQUIRED TEXTFIELDS
                try{
                    presentPercentageEnrID = Integer.parseInt(presentPercentageEnrIDtf.getText());//enrollment ID for present percentage
                    presentPercentageDaysPresent = Integer.parseInt(presentPercentageDaysPresenttf.getText());//number of days present for present percentage
                
                    //CHECKING IF THE LIST OF STUDENTS IS EMPTY
                    if(studList.isEmpty()){
                        //displaying message to notify the user
                        JOptionPane.showMessageDialog(f,"List of students is empty.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        boolean calculatedPresentPercentage = false;//setting a flag
                        
                        for(Student stud:studList){
                            
                            //IF THE STUDENT IS OF Regular CLASS
                            if(stud instanceof Regular){
                                Regular regStud = (Regular) stud;//downcasting stud as an object of Regular class
                                
                                //IF THE USER-ENTERED ENROLLMENT ID MATCHES THAT OF A PRE-EXISTING Regular STUDENT
                                if(stud.getEnrollmentID() == presentPercentageEnrID){
                                    calculatedPresentPercentage = true;//setting the flag to true
                                    
                                    //calculating present percentage of student
                                    String presentPercentageMessage = String.valueOf(regStud.presentPercentage(presentPercentageDaysPresent));
                                    
                                    //displaying message to notify the user
                                    JOptionPane.showMessageDialog(f,presentPercentageMessage,"Attendance Grade",JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                        }
                        
                        //IF THERE ARE NO Regular STUDENTS WITH USER-INPUT ENROLLMENT iD IN THE STUDENT LIST
                        if(calculatedPresentPercentage == false){
                            //displaying message to notify the user
                            JOptionPane.showMessageDialog(f,"No regular student with given enrollment ID found; please enter a valid enrollment ID.",
                                                            "Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch(NumberFormatException presentPercentageEx){
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f,"Invalid input detected; please enter numbers.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //GRANT CERTIFICATE BUTTON
        /*
         * This button first checks if any required textfields are empty, and displays a message if so
         * If not, it retrieves text from those textfields and converts them to integers where necessary
         * It then checks if there are Regular students in the Student arraylist, and displays a message if not so
         * If so, it checks if the user has entered a matching enrollment ID, and displays a message showing the student's details of graduation if so
         * If not, it displays a message to inform the user that they entered a non-existent enrollment ID
        */
        else if(e.getSource() == grantCertbtn){
            
            boolean emptyTextfields = grantCertCourseNametf.getText().isEmpty() || grantCertEnrIDtf.getText().isEmpty();
            
            //CHECKING IF ANY OF THE REQUIRED TEXTFIELDS ARE EMPTY
            if(emptyTextfields){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"Empty textfields detected; please fill all the required fields.","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                //SETTING VARIABLES WITH VALUES FROM THE REQUIRED TEXTFIELDS
                grantCertCourseName = grantCertCourseNametf.getText();//course name for grant certificate
                
                grantCertYearOfEnrollment = (String) grantCertYearOfEnrollmentcb.getSelectedItem();//year of enrollment for grant certificate
                grantCertMonthOfEnrollment = (String) grantCertMonthOfEnrollmentcb.getSelectedItem();//month of enrollment for grant certificate
                grantCertDayOfEnrollment = (String) grantCertDayOfEnrollmentcb.getSelectedItem();//day of enrollment for grant certificate
                
                //date of enrollment for grant certificate
                grantCertDateOfEnrollment = grantCertYearOfEnrollment + "-" + grantCertMonthOfEnrollment + "-" + grantCertDayOfEnrollment;
                
                try{
                    grantCertEnrID = Integer.parseInt(grantCertEnrIDtf.getText());//enrollment ID for grant certificate
                
                    //CHECKING IF THE LIST OF STUDENTS IS EMPTY
                    if(studList.isEmpty()){
                        //displaying message to notify the user
                        JOptionPane.showMessageDialog(f,"List of students is empty.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        boolean grantedCertificate = false;//setting a flag
                        
                        for(Student stud:studList){
                            
                            //IF THE STUDENT IS OF Regular CLASS
                            if(stud instanceof Regular){
                                Regular regStud = (Regular) stud;//downcasting stud as an object of Regular class 
                        
                                //IF THE USER-ENTERED ENROLLMENT ID MATCHES THAT OF A PRE-EXISTING Regular STUDENT
                                if(regStud.getEnrollmentID() == grantCertEnrID){
                                    grantedCertificate = true;//setting the flag to true
                                    
                                    //granting certificate to regStud
                                    String grantedCertificateMessage = regStud.grantCertificate(grantCertCourseName,grantCertEnrID,grantCertDateOfEnrollment);
                                    
                                    //displaying message to notify the user
                                    JOptionPane.showMessageDialog(f,grantedCertificateMessage,"Grant Certificate",JOptionPane.INFORMATION_MESSAGE);
                                    
                                    break;
                                }
                            }
                        }
                        
                        //IF THERE ARE NO Regular STUDENTS WITH USER-INPUT ENROLLMENT ID IN THE STUDENT LIST
                        if(grantedCertificate == false){
                            //displaying message to notify the user
                            JOptionPane.showMessageDialog(f,"No regular student with given enrollment ID found; please enter a valid enrollment ID.",
                                                            "Error",JOptionPane.ERROR_MESSAGE);
                                    
                        }
                    }
                }catch(NumberFormatException grantCertEx){
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f,"Invalid input detected; please enter numbers.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //DISPLAY BUTTON
        /*
         * This button first checks if there are Regular students in the Student arraylist, and displays a message if so
         * If so, it displays all the details of those students in a dialog box
        */
        else if(e.getSource() == regDisplaybtn){
            boolean displayedStudent = false;//setting a flag
            
            for(Student stud:studList){
                
                //IF THE STUDENT IS OF Regular CLASS
                if(stud instanceof Regular){
                    displayedStudent = true;//setting the flag to true
                    
                    Regular regStud = (Regular) stud;//downcasting stud as an object of Regular class
                    String displayInfo = regStud.display();
                    
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f,displayInfo,"Student Info",JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }
            
            //IF THERE ARE Regular STUDENTS IN THE STUDENT LIST
            if(displayedStudent == true){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"Successfully displayed information of Regular student.","Success",JOptionPane.INFORMATION_MESSAGE);
            }
            
            //IF THERE ARE NO Regular STUDENTS IN THE STUDENT LIST
            else{
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"No regular students found in the student list.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //CLEAR BUTTON
        /*
         * This button sets the text of all the required textfields to empty strings
        */
        else if(e.getSource()==regClearbtn){
            JOptionPane.showMessageDialog(f,"All fields will be cleared.","Warning",JOptionPane.WARNING_MESSAGE);//displaying a warning to the user
            
            ArrayList<JTextField> textfieldList = new ArrayList<JTextField>();//creating an arraylist to store textfields
            
            //adding textfields to the arraylist
            textfieldList.add(regEnrIDtf);//enrollment ID
            textfieldList.add(regStudNametf);//student name
            textfieldList.add(regCourseNametf);//course name
            textfieldList.add(regCourseDurationtf);//course duration
            textfieldList.add(regTuitionFeetf);//tuition fee
            textfieldList.add(numOfModulestf);//number of modules
            textfieldList.add(numOfCreditHourstf);//number of credit hours
            textfieldList.add(daysPresenttf);//number of days present
            
            textfieldList.add(presentPercentageEnrIDtf);//enrollment ID for present percentage
            textfieldList.add(presentPercentageDaysPresenttf);//number of days present for present percentage
            textfieldList.add(grantCertEnrIDtf);//enrollment ID for grant certificate
            textfieldList.add(grantCertCourseNametf);//course name for grant certificate
            
            for(JTextField eachField:textfieldList){
                eachField.setText("");//setting every text field to empty strings
            }
        }
        //REGULAR PANEL END---------------------------------------------------------------------
        
        
        

        
        
        
        
        
        
        
        
        
        
        //DROPOUT PANEL-------------------------------------------------------------------------
        //ADD DROPOUT STUDENT BUTTON
        /*
         * This button first checks if any required textfields are empty, and displays a message if so
         * If not, it retrieves text from those textfields and converts them to integers where necessary
         * It then creates a new Dropout object
         * It then checks if the user has entered a negative value for the enrollment ID, and displays a mesage if so
         * It then checks if the Student arraylist is empty, and directly adds the student to it and displays a message if so
         * If not, it checks if the user has entered a duplicate enrollment ID and displays a message if so
         * If not, it adds the student to the Student arraylist and displays a message
        */
        else if(e.getSource() == addDropoutStudbtn){
            
            boolean emptyTextfields = dropoutEnrIDtf.getText().isEmpty() || dropoutStudNametf.getText().isEmpty() || dropoutCourseNametf.getText().isEmpty() 
                                      || dropoutCourseDurationtf.getText().isEmpty() || dropoutTuitionFeetf.getText().isEmpty() 
                                      || numOfRemainingModulestf.getText().isEmpty() || numOfMonthsAttendedtf.getText().isEmpty() 
                                      || remainingAmounttf.getText().isEmpty();
            
            //CHECKING IF ANY OF THE REQUIRED TEXTFIELDS ARE EMPTY
            if(emptyTextfields){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"Empty fields detected; please fill out all the fields.","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                //SETTING VARIABLES WITH VALUES FROM THE REQUIRED TEXTFIELDS
                dropoutStudName = dropoutStudNametf.getText();//student name
                
                dropoutYearOfBirth = (String) dropoutYearOfBirthcb.getSelectedItem();//year of birth
                dropoutMonthOfBirth = (String) dropoutMonthOfBirthcb.getSelectedItem();//month of birth
                dropoutDayOfBirth = (String) dropoutDayOfBirthcb.getSelectedItem();//day of birth
                dropoutDateOfBirth = dropoutYearOfBirth + "-" + dropoutMonthOfBirth + "-" + dropoutDayOfBirth;//date of birth
                
                dropoutYearOfEnrollment = (String) dropoutYearOfEnrollmentcb.getSelectedItem();//year of enrollment
                dropoutMonthOfEnrollment = (String) dropoutMonthOfEnrollmentcb.getSelectedItem();//month of enrollment
                dropoutDayOfEnrollment = (String) dropoutDayOfEnrollmentcb.getSelectedItem();//day of enrollment
                dropoutDateOfEnrollment = dropoutYearOfEnrollment + "-" + dropoutMonthOfEnrollment + "-" + dropoutDayOfEnrollment;//date of enrollment
                
                yearOfDropout = (String) yearOfDropoutcb.getSelectedItem();//year of dropout
                monthOfDropout = (String) monthOfDropoutcb.getSelectedItem();//month of dropout
                dayOfDropout = (String) dayOfDropoutcb.getSelectedItem();//day of dropout
                dateOfDropout = yearOfDropout + "-" + monthOfDropout + "-" + dayOfDropout;//date of dropout
                
                dropoutCourseName = dropoutCourseNametf.getText();//course name
                    
                try{
                    dropoutEnrID = Integer.parseInt(dropoutEnrIDtf.getText());//enrollment ID
                    
                    dropoutCourseDuration = Integer.parseInt(dropoutCourseDurationtf.getText());//course duration
                    dropoutTuitionFee = Integer.parseInt(dropoutTuitionFeetf.getText());//tuition fee
                    
                    numOfRemainingModules = Integer.parseInt(numOfRemainingModulestf.getText());//number of remaining modules
                    numOfMonthsAttended = Integer.parseInt(numOfMonthsAttendedtf.getText());//number of months attended
                    remainingAmount = Integer.parseInt(remainingAmounttf.getText());//remaining amount
                 
                
                    //CREATING AND UPCASTING A NEW Dropout OBJECT
                    Student dropoutStud = new Dropout(dropoutEnrID,dropoutDateOfBirth,dropoutCourseName,dropoutStudName,dropoutDateOfEnrollment,
                                          dropoutCourseDuration,dropoutTuitionFee,numOfRemainingModules,numOfMonthsAttended,remainingAmount,
                                          dateOfDropout);
                                          
                    //CHECKING IF THE USER ENTERS A NEGATIVE ENROLLMENT ID
                    if(dropoutEnrID <= 0){
                        //displaying message to notify the user
                        JOptionPane.showMessageDialog(f,"Invalid enrollment ID detected; please enter a non-negative value.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                
                    else{
                        //CHECKING IF STUDENT ARRAYLIST IS EMPTY
                        if (studList.isEmpty()){
                            studList.add(dropoutStud);//adding student to student arraylist
                            
                            //displaying message to notify the user
                            JOptionPane.showMessageDialog(f,"Successfully added dropout student.","Success",JOptionPane.INFORMATION_MESSAGE);
                        }
                        
                        //IF STUDENT LIST IS NOT EMPTY
                        else{
                            boolean isDuplicate = false;//setting a flag
    
                            for(Student stud:studList){
                                
                                //IF THE STUDENT OBJECT IS AN INSTANCE OF Dropout CLASS
                                if(stud instanceof Dropout){
                                    
                                    //IF USER ENTERS DUPLICATE ENROLLMENT ID
                                    if(stud.getEnrollmentID() == dropoutStud.getEnrollmentID()){
                                        isDuplicate = true;//setting the flag to true
                                        break;
                                    }
                                }
                            }
                            
                            //IF USER ENTERS UNIQUE ENROLLMENT ID
                            if(isDuplicate == false){
                                studList.add(dropoutStud);//adding student to student list
                                
                                //displaying message to notify the user
                                JOptionPane.showMessageDialog(f,"Successfully added dropout student.","Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else{
                                //displaying message to notify the user
                                JOptionPane.showMessageDialog(f,"Duplicate enrollment ID detected; please enter a valid enrollment ID",
                                                                "Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }catch(NumberFormatException dropoutEx){ 
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f, "Invalid input detected; please enter numbers.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //PAY BILLS BUTTON
        /*
         * This button first checks if any required textfields are empty, and displays a message if so
         * If not, it retrieves text from those textfields and converts them to integers where necessary
         * It then checks if there are Dropout students in the Student arraylist, and displays a message if not so
         * If so, it checks if the user has entered a matching enrollment ID, and displays a message showing the student's remaining fees if so
         * If not, it displays a message to inform the user that they entered a non-existent enrollment ID
        */
        else if(e.getSource() == payBillsbtn){
            boolean emptyTextfields = payBillsEnrIDtf.getText().isEmpty();
            
            //CHECKING IF THE REQUIRED TEXTFIELD IS EMPTY
            if(emptyTextfields){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"Empty textfields detected; please fill all the required fields.","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                //SETTING VARIABLE WITH VALUE FROM THE REQUIRED TEXTFIELD
                try{
                    payBillsEnrID = Integer.parseInt(payBillsEnrIDtf.getText());//enrollment ID for pay bills
                
                    //IF THE LIST OF STUDENTS IS EMPTY
                    if(studList.isEmpty()){
                        //displaying message to notify the user
                        JOptionPane.showMessageDialog(f,"List of students is empty.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        boolean paidBills = false;//setting a flag
                        
                        for(Student stud:studList){
                            
                            //CHECKING IF stud IS AN OBJECT OF Dropout
                            if(stud instanceof Dropout){
                                Dropout dropoutStud = (Dropout) stud;//downcasting stud as an object of Dropout class
                                
                                //IF USER-ENTERED ENROLLMENT ID IS USED BY ANY PRE-EXISTING Dropout STUDENT
                                if(dropoutStud.getEnrollmentID() == payBillsEnrID){
                                    paidBills = true;//setting the flag to true
                                    
                                    String remainingFeeMessage = dropoutStud.billsPayable();//paying bills of dropoutStud
                                    
                                    //displaying message to notify the user
                                    JOptionPane.showMessageDialog(f,remainingFeeMessage,"Remaining Fee",JOptionPane.INFORMATION_MESSAGE);
                                    
                                    break;
                                }
                            }
                        }
                                                    
                        //IF THERE ARE NO Dropout STUDENTS WITH USER-INPUT ENROLLMENT iD IN THE STUDENT LIST
                        if(paidBills == false){
                            //displaying message to notify the user
                            JOptionPane.showMessageDialog(f,"No dropout students with given enrollment ID found in the student list.",
                                                            "Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch(NumberFormatException payBillsEx){
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f,"Invalid input detected in dropout; please enter numbers.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //REMOVE STUDENT BUTTON
        /*
         * This button first checks if any required textfields are empty, and displays a message if so
         * If not, it retrieves text from those textfields and converts them to integers where necessary
         * It then checks if there are Dropout students in the Student arraylist, and displays a message if not so
         * If so, it checks if the user has entered a matching enrollment ID, and displays a message showing that the student's details have been removed if so
         * If not, it displays a message to inform the user that they entered a non-existent enrollment ID
        */
        else if(e.getSource() == removeStudbtn){
            boolean emptyTextfields = removeStudEnrIDtf.getText().isEmpty();
            
            //CHECKING IF ANY OF THE REQUIRED TEXTFIELDS ARE EMPTY
            if(emptyTextfields){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"Empty textfields detected; please fill all the required fields.","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                //SETTING VARIABLE WITH VALUE FROM REQUIRED TEXTFIELD
                try{
                    removeStudEnrID = Integer.parseInt(removeStudEnrIDtf.getText());//enrollment ID for remove student
                
                    //CHECKING IF THE LIST OF STUDENTS IS EMPTY
                    if(studList.isEmpty()){
                        //displaying message to notify the user
                        JOptionPane.showMessageDialog(f,"List of students is empty.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        boolean isRemoved = false;//setting a flag
                        
                        for(Student stud:studList){
                            
                            //CHECKING IF stud IS AN OBJECT OF Dropout
                            if(stud instanceof Dropout){
                                Dropout dropoutStud = (Dropout) stud;//downcasting stud as an object of Dropout class
                                
                                //IF USER-ENTERED ENROLLMENT ID MATCHES THAT OF A PRE-EXISTING Dropout STUDENT
                                if(stud.getEnrollmentID() == removeStudEnrID){
                                    isRemoved = true;//setting the flag to true
                                    
                                    String removedStudentMessage = dropoutStud.removeStudent();//removing dropoutStud fro student list
                                    
                                    //displaying message to notify the user
                                    JOptionPane.showMessageDialog(f,removedStudentMessage,"Remove Student",JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            }
                        }
                        
                        //IF THERE ARE NO Dropout STUDENTS WITH USER-INPUT ENROLLMENT ID IN THE STUDENT LIST
                        if(isRemoved == false){
                            //displaying message to notify the user
                            JOptionPane.showMessageDialog(f,"No dropout students with the given enrollment ID found in the student list.",
                                                            "Error",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch(NumberFormatException payBillsEx){
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f,"Invalid input detected in dropout; please enter numbers.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //DISPLAY BUTTON
        /*
         * This button first checks if there are Dropout students in the Student arraylist, and displays a message if so
         * If so, it displays all the details of those students in a dialog box
        */
        else if(e.getSource() == dropoutDisplaybtn){
            boolean displayedStudent = false;//setting a flag
            
            for(Student stud:studList){
                
                //IF THE STUDENT IS OF Dropout CLASS
                if(stud instanceof Dropout){
                    displayedStudent = true;//setting the flag to true
                    
                    Dropout dropoutStud = (Dropout) stud;//downcasting stud as an object of Dropout class
                    String displayInfo = dropoutStud.display();
                    
                    //displaying message to notify the user
                    JOptionPane.showMessageDialog(f,displayInfo,"Student Info",JOptionPane.INFORMATION_MESSAGE);
                    
                }
            }
            
            //IF THERE ARE Dropout STUDENTS IN THE STUDENT LIST
            if(displayedStudent == true){
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"Successfully displayed information of Dropout student.","Success",JOptionPane.INFORMATION_MESSAGE);
            }
            
            //IF THERE ARE NO Dropout STUDENTS IN THE STUDENT LIST
            else{
                //displaying message to notify the user
                JOptionPane.showMessageDialog(f,"No dropout students found in the student list.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        //CLEAR BUTTON
        /*
         * This button sets the text of all the required textfields to empty strings
        */
        else{
            JOptionPane.showMessageDialog(f,"All fields will be cleared.","Warning",JOptionPane.WARNING_MESSAGE);//displaying a warning to the user
            
            ArrayList<JTextField> textfieldList = new ArrayList<JTextField>();//creating an arraylist to store textfields
            
            //adding textfields to the arraylist
            textfieldList.add(dropoutEnrIDtf);//enrollment ID
            textfieldList.add(dropoutStudNametf);//student name
            textfieldList.add(dropoutCourseNametf);//course name
            textfieldList.add(dropoutCourseDurationtf);//course duration
            textfieldList.add(dropoutTuitionFeetf);//tuition fee
            textfieldList.add(numOfRemainingModulestf);//number of remaining modules
            textfieldList.add(numOfMonthsAttendedtf);//number of months attended
            textfieldList.add(remainingAmounttf);//remaining amount
            
            textfieldList.add(payBillsEnrIDtf);//enrollment ID for pay bills
            textfieldList.add(removeStudEnrIDtf);//enrollment ID for remove student

            for(JTextField eachField:textfieldList){
                eachField.setText("");//setting every text field to empty strings
            }
        }
    }
    
    
    //MAIN METHOD
    public static void main(String[] args)
    {
        new StudentGUI();//creating a new object of this class, ie a GUI
    }
}