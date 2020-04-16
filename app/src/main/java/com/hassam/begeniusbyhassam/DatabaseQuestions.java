package com.hassam.begeniusbyhassam;

public class DatabaseQuestions {
    public String mDatabaseQuestions[] = {

            "What are the different view to present a Table ?",
            "In one-to-many relationship the table on 'many' side is called _______",
            "In which state one gathers and list all the necessary fields for the database design project.",
            "Which of the following enables us to view data from a table based on a specific criterion",
            "Which database object is ideal to view, change, andanalyze datain different ways ?",
            "In one-to-many relationship the table in 'one' side is called _______",
            "Which data type allows alphanumeric characters and special symbols to be entered?",
            "It is used to establish an association between related tables.",
            "This key that uniquely identifies each record is called :",
            "Which name must be unique within a database ?"
    };

    private String mDatabaseChoices[][] = {

            {"Datasheet View", "Design View", "Pivote TableView", "All Of Above"},
            {"Parent", "Child", "Sister", "Master"},
            {"Data Definition", "Data Refinement", "Establishing Relationship", "None"},
            {"Form", "Query", "Macro", "Report"},
            {"Table", "Form", "Query", "Report"},
            {"Child", "Owner", "Parent", "Handler"},
            {"Text", "Memo", "Auto number", "Mixed"},
            {"Line", "Relationship", "Primary Key", "Records"},
            {"Primary Key", "Key Record", "Unique Key", "Field Name"},
            {"Table", "Field", "Record", "Character"}
    };

    private String mDatabaseAnswers[] = {"All Of Above", "Child", "Data Definition", "Form", "Query", "Parent", "Text",
            "Relationship", "Primary Key", "Table"};

    public String getQuestion(int a) {

        String question = mDatabaseQuestions[a];
        return question;

    }

    public String getChoice1(int a) {
        String choice = mDatabaseChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mDatabaseChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mDatabaseChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mDatabaseChoices[a][3];
        return choice;
    }
    public String getCorrectAnswers(int a){
        String answer = mDatabaseAnswers[a];
        return answer;
    }
}
