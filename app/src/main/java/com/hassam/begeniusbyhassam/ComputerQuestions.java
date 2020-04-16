package com.hassam.begeniusbyhassam;

public class ComputerQuestions {

    public String mComputerQuestions[] = {

            "Android is licensed under which open source licensing license?",
            "Android is ____",
            "Android is not owned by Google. Who owns the Android Platform?",
            "Android is developed specially for :",
            "Android Operating system is based on",
            "What was the first phone released that ran the Android OS?",
            "Android 1.5 is known by the name ________",
            "Android 1.6 is known by the name ________",
            "___________ enables to store the data in a structured manner in Android",
            "What is Android file extension?"
    };

    private String mComputerChoices[][] = {

            {"GPL", "Apache", "OSS", "Sourforge"},
            {"Web", "Server", "OS", "None"},
            {"Oracle", "Dalvik", "OHA", "None"},
            {"Laptop", "Desktop", "Mobile", "Server"},
            {"Mac", "Windows", "LINUX", "Solaris"},
            {"gPhone", "T-Mobile", "Motorolla", "HTC"},
            {"Cupcake", "Donut", "Eclair", "Froyo"},
            {"Cupcake", "Donut", "Eclair", "Froyo"},
            {"Oracle", "DB2", "SQLite", "MySQL"},
            {".jar", ".ispw", ".apk", ".exe"}
    };

    private String mComputerAnswers[] = {"Apache", "OS", "OHA", "Mobile", "Windows", "T-Mobile", "Cupcake", "Donut", "SQLite", ".apk"};

    public String getQuestion(int a) {

        String question = mComputerQuestions[a];
        return question;

    }

    public String getChoice1(int a) {
        String choice = mComputerChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mComputerChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mComputerChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mComputerChoices[a][3];
        return choice;
    }
    public String getCorrectAnswers(int a){
        String answer = mComputerAnswers[a];
        return answer;
    }

}
