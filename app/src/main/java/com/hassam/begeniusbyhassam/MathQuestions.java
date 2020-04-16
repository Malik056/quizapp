package com.hassam.begeniusbyhassam;

public class MathQuestions {
    public String mMathQuestions[] = {

            "The two straight lines in the same plane which never meet are called: ",
            "The locus of a point in a plane equidistant from a fixed point is known as",
            "The set of all the ordered pair (x, y) which satisfies the system of equations is called",
            "A straight line which touches the circumference of a circle at a single point only is known as",
            "A line that intersects two lines in different points is known as",
            "A tangent line intersects the circle at?",
            "A line segment joining any 2 points on the circumference of a circle is called",
            "A line segment determined by the centre and a point on the circle is called",
            "The quotient of two numbers or algebraic expressions is called a",
            "When a circle is drawn through its four vertices, a quadrilateral is said to be"
    };

    private String mMathChoices[][] = {

            {"angles", "transversal lines", "vertex", "parallel lines"},
            {"triangle", "rectangle", "hexagon", "circle"},
            {"solution set", "null set", "complex set", "subset"},
            {"secant", "sector", "tangent", "segment"},
            {"angles", "transversal lines", "vertex", "parallel lines"},
            {"two points", "three points", "single point", "no point"},
            {"arc", "chord", "segment", "radius"},
            {"radial segment", "diameter", "chord", "radius"},
            {"proportion", "ratio", "fraction", "variation"},
            {"non-cyclic", "cyclic", "collinear", "non-collinear"}
    };

    private String mMathAnswers[] = {"parallel lines", "circle", "solution set", "tangent", "transversal lines",
            "single point", "chord", "radial segment", "fraction", "cyclic"};

    public String getQuestion(int a) {

        String question = mMathQuestions[a];
        return question;

    }

    public String getChoice1(int a) {
        String choice = mMathChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mMathChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mMathChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mMathChoices[a][3];
        return choice;
    }
    public String getCorrectAnswers(int a){
        String answer = mMathAnswers[a];
        return answer;
    }
}
