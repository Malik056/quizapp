package com.hassam.begeniusbyhassam;

public class GKnowledgeQuestions {
    public String mGKnowledgeQuestion[] = {

            "Which is the oldest forest in Pakistan?",
            "The oldest constructed Barrage of Pakistan:",
            "Which is the largest desert in the World?",
            "Which is the largest lake of the World?",
            "The first airline of Pakistan is____________________.",
            "Which one is the largest island of the World?",
            "How many members were there in the First Constituent Assembly of Pakistan when it was set up?",
            "Name the National Animal of Pakistan:",
            "The national game of Pakistan is _____________________",
            "Name the current president of Pakistan:"
    };

    private String mGKnowledgeChoice[][] = {

            {"Changa Manga", "Junipur", "Chitral", "Chichawatni"},
            {"Jinnah Barrage", "Tunsa Barrage", "Kotri Barrage", "Sukkur Barrage"},
            {"Arabian", "Australian", "Sahara", "Gobi"},
            {"Lake Victoria", "Superior Lake", "Red Sea", "Caspian Sea"},
            {"Pak Airways", "Orient Airline", "PIA", "Air Blue"},
            {"Borneo", "Great Britain", "Victoria", "Greenland"},
            {"69", "79", "89", "99"},
            {"Goat", "Markhor", "Buffalo", "Camel"},
            {"Football", "Hockey", "Cricket", "Kabaddi"},
            {"Arif Alvi", "Imran Ismail", "Mamnoon", "Asad"}
    };

    private String mGKnowledgeAnswers[] = {"Junipur", "Sukkur Barrage", "Sahara", "Caspian Sea", "Orient Airlines",
            "Greenland", "69", "Markhor", "Hockey", "Arif Alvi"};

    public String getQuestion(int a) {

        String question = mGKnowledgeQuestion[a];
        return question;

    }

    public String getChoice1(int a) {
        String choice = mGKnowledgeChoice[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mGKnowledgeChoice[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mGKnowledgeChoice[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mGKnowledgeChoice[a][3];
        return choice;
    }
    public String getCorrectAnswers(int a){
        String answer = mGKnowledgeAnswers[a];
        return answer;
    }

}
