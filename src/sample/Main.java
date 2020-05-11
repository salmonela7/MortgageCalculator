package sample;
import sample.Charts.LineChart;
import sample.Functions.AddLabel;
import sample.Functions.Calculate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.util.ArrayList;

public class Main extends Application {

    Stage window;

    public static ArrayList<Double> menImokos = new ArrayList<>();
    public static ArrayList<Label> detImokos = new ArrayList<>();
    public static ArrayList<Double> likoNesumoketa = new ArrayList<>();
    public static ArrayList<Double> menProcentas = new ArrayList<>();
    public static TextField interv1 = new TextField();
    public static TextField interv2 = new TextField();
    public static int mensk;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Titulas");
        window.setWidth(800);
        window.setHeight(600);

        AnchorPane root = new AnchorPane();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10.0);

        VBox vbox2 = new VBox();
        vbox2.setPadding(new Insets(10, 10, 10, 10));
        vbox2.setSpacing(5.0);

        AnchorPane.setLeftAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox2, 70.0);

        TextField text1 = new TextField();
        text1.setPromptText("Įveskite paskolos sumą");

        Button button2 = new Button("Skaičiuoti");

        ChoiceBox<String> choicebox = new ChoiceBox<>();
        choicebox.getItems().addAll("Pasirinkite paskolos grafiką", "Anuiteto", "Linijinis");
        choicebox.setValue("Pasirinkite paskolos grafiką");

        /*final ToggleGroup group = new ToggleGroup();

        RadioButton check1 = new RadioButton("Linijinis");
        check1.setToggleGroup(group);
        check1.setSelected(true);

        RadioButton check2 = new RadioButton("Anuiteto");
        check2.setToggleGroup(group);
        */

        TextField metai = new TextField();
        metai.setPromptText("Įveskite metus");

        TextField menesiai = new TextField();
        menesiai.setPromptText("Įveskite mėnesius");

        TextField procentas = new TextField();
        procentas.setPromptText("Įveskite procentą");

        interv1.setPromptText("Nuo");
        interv1.setPrefWidth(50);

        interv2.setPromptText("Iki");
        interv2.setPrefWidth(50);

        HBox intervalai = new HBox();
        intervalai.getChildren().addAll(interv1, interv2);

        Label ivestiSuma = new Label("Įveskite norimą paskolos sumą: ");

        Label ivestiMenesius = new Label("Įveskite mėnesius: ");

        Label ivestiMetus = new Label("Įveskite metus: ");

        Label ivestiProcenta = new Label("Įveskite procenta: ");

        Label interv = new Label("Iveskite mėnesių intervalą:");

        Button button1 = new Button("Grafikas");

        Button button3 = new Button ("Rodyti papildomus nustatymus");

        Button button4 = new Button("Gauti ataskaitą faile");

        HBox paskolosSuma = new HBox();
        paskolosSuma.setSpacing(10.0);
        paskolosSuma.getChildren().addAll(ivestiSuma, text1);

        HBox paskolosMetai = new HBox();
        paskolosMetai.setSpacing(10.0);
        paskolosMetai.getChildren().addAll(ivestiMetus, metai);

        HBox paskolosMenesiai = new HBox();
        paskolosMenesiai.setSpacing(10.0);
        paskolosMenesiai.getChildren().addAll(ivestiMenesius, menesiai);

        HBox paskolosProcentas = new HBox();
        paskolosProcentas.setSpacing(10.0);
        paskolosProcentas.getChildren().addAll(ivestiProcenta, procentas);

        VBox vbox3 = new VBox();
        vbox3.setPadding(new Insets(10, 10, 10, 10));
        vbox3.setSpacing(5.0);

        vbox.getChildren().addAll(paskolosSuma, paskolosMetai, paskolosMenesiai, paskolosProcentas, choicebox, button2, button3);

        root.getChildren().addAll(vbox2, vbox);

        Scene scene = new Scene(root, 800, 600);

        button1.setOnAction(e ->
        {
            if(choicebox.getValue().equals("Linijinis"))
            {
                new LineChart("Linijinis mokėjimo grafikas", 600, 600);
            }
            if(choicebox.getValue().equals("Anuiteto"))
            {
                new LineChart("Anuiteto mokėjimo grafikas", 600, 600);
            }

        });

        button2.setOnAction(e -> {
            vbox2.getChildren().clear();
            Calculate calculate = new Calculate();
            calculate.Calculate(procentas, text1, menesiai, metai, choicebox);
            AddLabel addlabel = new AddLabel();
            addlabel.AddLabel();
            vbox2.getChildren().addAll(detImokos);

        });

        button3.setOnAction(e ->
        {
            if (button3.getText().equals("Slėpti papildomus nustatymus"))
            {
                button3.setText("Rodyti papildomus nustatymus");
                vbox.getChildren().removeAll(interv, intervalai, button1, button4);
            }
            else
            {
                button3.setText("Slėpti papildomus nustatymus");
                vbox.getChildren().addAll(interv, intervalai, button1, button4);
            }
        });

        button4.setOnAction(e ->
        {
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null)
            {

                vbox3.getChildren().clear();
                vbox3.getChildren().addAll(detImokos);
                job.showPrintDialog(window);
                job.printPage(vbox3);
                job.endJob();
            }
        });
        window.setScene(scene);
        window.show();
    }

    public double getValue(int index1, int index2)
    {
        double value = 0;
        for (; index1-1 < index2; index1++)
        {
            value = value + menImokos.get(index1-1) + menProcentas.get(index1-1);
        }
        return value;

    }

}
