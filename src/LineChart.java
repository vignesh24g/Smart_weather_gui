import java.io.*;

import org.jfree.chart.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

public class LineChart {
   static int t[] = new int[14];
   String c;

   LineChart(int t[], String cityn) {
      for (int i = 0; i < 14; i++) {
         LineChart.t[i] = t[i];
      }
      this.c = cityn;

   }

   void cc() throws Exception {
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      line_chart_dataset.addValue(t[0], "Day", "Today");
      line_chart_dataset.addValue(t[1], "Day", "tommorow");
      line_chart_dataset.addValue(t[2], "Day", "day-after");
      line_chart_dataset.addValue(t[3], "Day", "nextday");
      line_chart_dataset.addValue(t[4], "Day", "nextday");
      line_chart_dataset.addValue(t[5], "Day", "nextday");
      line_chart_dataset.addValue(t[6], "Day", "nextday");

      line_chart_dataset.addValue(t[7], "Night", "Today");
      line_chart_dataset.addValue(t[8], "Night", "tommorow");
      line_chart_dataset.addValue(t[9], "Night", "day-after");
      line_chart_dataset.addValue(t[10], "Night", "nextday");
      line_chart_dataset.addValue(t[11], "Night", "nextday");
      line_chart_dataset.addValue(t[12], "Night", "nextday");
      line_chart_dataset.addValue(t[13], "Night", "nextday");

      JFreeChart lineChartObject = ChartFactory.createLineChart(
            "Temp*c Vs days", "week-days",
            "Temperature *c",
            line_chart_dataset, PlotOrientation.VERTICAL,
            true, true, false);

      int width = 640; /* Width of the image */
      int height = 400; /* Height of the image */
      String s = c + ".jpeg";
      File lineChart = new File(s);
      ChartUtilities.saveChartAsJPEG(lineChart, lineChartObject, width, height);
   }
}