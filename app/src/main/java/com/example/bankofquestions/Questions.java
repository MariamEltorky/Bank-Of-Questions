package com.example.bankofquestions;

public class Questions {
    public String AllQuestion [] ={
            "What is log message in android?" ,
            " Which company developed android?" ,
            "Fragment in Android can be found through?" ,
            "Adb Stands For?" ,
            "Which Programming Language Is Used For Android Application Development?",
            "Which data type value is returned by all transcendental math functions?"
            ,
            "Which of these is an incorrect array declaration?" ,
            "Which of these operators is used to allocate memory to array variable in Java?" ,
            "Which of these is necessary to specify at time of array initialization?"
            ,
            " Which of the following is not OOPS concept in Java?" ,
            "Which of the following is a type of polymorphism in Java?",
            " Which of these keywords is used to make a class?" ,
            "Literal can be of which of these data types?" ,
            "Which of these can not be used for a variable name in Java?",
            "Which of the following is a valid declaration of an object of class Box?"
    };
    public String AllChoices [][] = {
            {"Log message is used to debug a program","Same as printf()","None of the above"} ,
                    {"Apple" ,"Google" ,"Android Inc"} ,
                    {"findByID()" ,"findFragmentByID()"
                            ,"FragmentManager.findFragmentByID()"} ,
                    {"Android Debug Bridge" ,"Android Destroy Bridge" ,"Android Drive Bridge"} ,
                            {"NodeJs" ,"PHP" ,"Java"} ,
                            {"Int" ,"Double" ,"Float" } ,
                            {"int arr[] = new int[5]" , "int arr[] = int [5] new" , "int arr[] = newint[5]"} ,
    {"malloc" ,"new" ,"alloc"} ,
    {"Row" ,"Column" ,"Both Row and Column"} ,
    {" Encapsulation" ,"Polymorphism" ,"Compilation"} ,
    {"Compile time polymorphism","Execution time polymorphism" ,"Multiple polymorphism"} ,
        {"class" ,"struct" ,"int"} ,
        {"integer" ,"boolean" ,"all of the mentioned"} ,
        {"identifier" ,"keyword" ,"identifier & keyword"} ,
        {"Box obj = new Box();" ,"Box obj = new Box;" ,"obj = new Box();"}
    };
    public String CorrectAnswers []= {
            "Log message is used to debug a program" , "Android Inc" ,
            "FragmentManager.findFragmentByID()" ,
            "Android Debug Bridge" , "Java" , "Double", "int arr[] = int [5] new" ,
            "new" ,"Row" ,
            "Compilation" , "Compile time polymorphism", "class" , "all of the mentioned" , "keyword",
            "Box obj = new Box();" };
    public String getQuestion (int a){
        String question =AllQuestion[a];
        return question;
    }
    public String getchoice1 (int a){
        String choice =AllChoices[a][0] ;
        return choice;
    }
    public String getchoice2 (int a){
        String choice =AllChoices[a][1] ;
        return choice;
    }
    public String getchoice3 (int a){
        String choice =AllChoices[a][2] ;
        return choice;
    }
    public String getCorrect (int a) {
        String correct=CorrectAnswers[a];
        return correct;
    }
    public int getLen () {
        return AllQuestion.length;
    }
}
