package sample.Functions;

import javafx.scene.control.Label;
import sample.Main;

import java.text.DecimalFormat;

public class AddLabel extends Main {

    public void AddLabel()
    {
        detImokos.clear();
        for (int i = 0; i < menImokos.size(); i++) {
            detImokos.add(new Label((i + 1) + " menesis: " + new DecimalFormat(".##").format(menImokos.get(i)) + " + " + new DecimalFormat("##.##").format(menProcentas.get(i)) + " = " + new DecimalFormat(".##").format(menImokos.get(i) + menProcentas.get(i)) +"; Liko nesumokėta: " + new DecimalFormat(".##").format(likoNesumoketa.get(i)) + ";" ));
        }
        Calculate obj = new Calculate();
        if (obj.countMonths() != 0 && Integer.parseInt(interv1.getText()) < Integer.parseInt(interv2.getText()))
        {
            detImokos.add(new Label("Įvesto intervalo mėnesių imokų suma: " + new DecimalFormat(".##").format(obj.countMonths())));
        }
    }

}
