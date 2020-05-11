package sample.Charts;

import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;


public class LineChart extends Main {

    public LineChart()
    {
        this("Chart", 800, 600);
    }

    public LineChart(String title, int width, int height)
    {
        Stage window = new Stage ();

        window. initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Mėnesis");
        yAxis.setLabel("Mėnesio įmoka");
        final javafx.scene.chart.LineChart<Number,Number> lineChart = new javafx.scene.chart.LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Mokėjimo grafikas");
        XYChart.Series series = new XYChart.Series();


        for(int i = 0; i < mensk; i++)
        {
            series.getData().add(new XYChart.Data(i, menImokos.get(i) + menProcentas.get(i)));
        }
        Scene scenes = new Scene(lineChart, width, height);
        lineChart.getData().add(series);
        window.setScene(scenes);
        window.showAndWait();
        //menImokos.clear();
    }

}
