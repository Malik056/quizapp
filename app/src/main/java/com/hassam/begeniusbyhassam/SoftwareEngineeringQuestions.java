package com.hassam.begeniusbyhassam;

public class SoftwareEngineeringQuestions {
    public String mSoftwareEngineeringQuestions[] = {

            " _________ is a piece of programming code which performs a well defined task.",
            "A person who writes a program for running the hardware of a computer is called?",
            "The condition outside a system is called?",
            "The item of documentation added to the description of the new system is:",
            "The main purpose of the system investigation phase is to produce:",
            "The name of programming technique which emphasizes breaking large and complex task into successively smaller sections is:",
            "System implementation phase involve:",
            "At the time of system study, flow of charts are drawn using:",
            "A graphic representation of an information system is called?",
            "The systems which can preserve and reproduce the knowledge of experts but have a limited application focus is:"
    };

    private String mSoftwareEngineeringChoices[][] = {

            {"Computer Program", "Computer Software", "Both", "None "},
            {"System designer", "Data processor", "Programmer", "System analyst"},
            {"Interface", "Boundary", "Environment", "All of these"},
            {"Problem overview", "I/O analysis", "Control review", "Feedback"},
            {"A requirement report", "A feasibility report", "A feasibility report", "All of these"},
            {"Structured programming", "Micro-programming", "Object orienting", "Scrambling"},
            {"Parallel runs", "Pilot run", "System checkouts", "All of these"},
            {"General symbols", "Abbreviated symbols", "Specific symbols", "Non standard symbols"},
            {"Data flow diagram", "Pictogram", "Flowchart", "All of these"},
            {"Applications", "Expert system", "Benefits and limitations", "knowledge base"}
    };

    private String mSoftwareEngineeringAnswers[] = {"Computer Program", "Programmer", "Environment", "Feedback", "A feasibility report",
            "Structured programming", "System checkouts", "General symbols", "Data flow diagram", "Benefits and limitations"};

    public String getQuestion(int a) {

        String question = mSoftwareEngineeringQuestions[a];
        return question;

    }

    public String getChoice1(int a) {
        String choice = mSoftwareEngineeringChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mSoftwareEngineeringChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mSoftwareEngineeringChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mSoftwareEngineeringChoices[a][3];
        return choice;
    }
    public String getCorrectAnswers(int a){
        String answer = mSoftwareEngineeringAnswers[a];
        return answer;
    }
}
