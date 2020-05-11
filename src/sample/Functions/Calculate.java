package sample.Functions;

import javafx.scene.control.ChoiceBox;
import sample.Main;

import javafx.scene.control.TextField;

public class Calculate extends Main{
    public void Calculate(TextField proc, TextField suma, TextField men, TextField met, ChoiceBox<String> choiceBox)
    {
        double procentas, sum, menImok, sumaSuPalukanomis, menProc;
        int menesiai, metai;
        if (proc.getText().equals("")) procentas = 0;
        else procentas = Double.parseDouble(proc.getText());

        if(suma.getText().equals("")) sum = 0;
        else sum = Double.parseDouble(suma.getText());

        if (men.getText().equals("")) menesiai = 0;
        else menesiai = Integer.parseInt(men.getText());

        if (met.getText().equals("")) metai = 0;
        else metai = Integer.parseInt(met.getText());

        mensk = menesiai + 12*metai;
        menImok = sum / mensk;
        sumaSuPalukanomis = sum + sum * procentas / 100;

        if (choiceBox.getValue().equals("Anuiteto"))
        {
            menImokos.clear();
            likoNesumoketa.clear();
            menProcentas.clear();
            for(int i = 0; i < mensk; i++)
            {
                menProc = menImok * procentas / 100;
                sumaSuPalukanomis = sumaSuPalukanomis - menImok - menProc;
                menImokos.add(menImok);
                menProcentas.add(menProc);
                likoNesumoketa.add(sumaSuPalukanomis);
            }
        }
        else if (choiceBox.getValue().equals("Linijinis"))
        {
            menImokos.clear();
            likoNesumoketa.clear();
            menProcentas.clear();
            for (int i = 0; i < mensk; i++)
            {
                menProc = sum/mensk*procentas/100;
                sumaSuPalukanomis = sumaSuPalukanomis - menImok - menProc;
                sum = sum - menImok;
                menImokos.add(menImok);
                menProcentas.add(menProc);
                likoNesumoketa.add(sumaSuPalukanomis);
            }
        }
    }

    public double countMonths ()
    {
        if (!interv1.getText().equals("") && !interv1.getText().equals(""))
        return super.getValue(Integer.parseInt(interv1.getText()), Integer.parseInt(interv2.getText()));
        else return 0;
    }
}
