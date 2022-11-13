package matematica;

public class BMR {
    private double kgWeight, cmHeight, age,result;
    private String gender;

    public BMR(double cmHeight,double kgWeight,  double age, String gender) {
        //super();
        this.kgWeight = kgWeight;
        this.cmHeight = cmHeight;
        this.age = age;
        this.gender = gender;
    }

    public double  bmrCalculator()  {
        if(gender.equalsIgnoreCase("F"))
            result = 655 + (9.6 * kgWeight) + (1.8 * cmHeight) - (4.7 * age);

        else if(gender.equalsIgnoreCase("M"))
            result = 66 + (13.7 * kgWeight) + (5 * cmHeight) - (6.8 * age);

        //else if(gender.equalsIgnoreCase(" "))

        return Math.round(result*100.0)/100.0;
    }

    public double getResult() {
        return result;
    }
}
