package app;

import frame.*;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        GymCAFrame finestra = new GymCAFrame("Alimentazione consigliata"
                + " GYM AC");
        Toolkit kit = finestra.getToolkit();
        Dimension dim = kit.getScreenSize();

        finestra.setBounds(dim.width/10, dim.height/6,
                dim.width/2,dim.height/2);
        finestra.setVisible(true);
    }
}