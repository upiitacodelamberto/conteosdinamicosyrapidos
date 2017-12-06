package components;

import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Histograma1 extends ApplicationFrame {
	public Histograma1(String title) {
		super(title);
		JPanel chartPanel = crearPanel();
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 475));
		setContentPane(chartPanel);
	}

	private static IntervalXYDataset crearDataset() {
		HistogramDataset dataset = new HistogramDataset();
		// vecto almacena los ingresos quincenales de 45 personas
		double vector[] = { 63, 89, 36, 49, 56, 64, 59, 35, 78, 43, 53, 70, 57, 62, 43, 68, 62, 26, 64, 72, 52, 51, 62,
				60, 71, 61, 55, 59, 60, 67, 57, 67, 61, 67, 51, 81, 53, 64, 76, 44, 73, 56, 62, 63, 60 };
		System.out.println("vector.lengt="+vector.length);
//		double vector[] = {1, 2, 3, 4, 5, 4, 4, 4, 3, 3};
		// En el ejercicio nos piden construir una distribucion de frecuencias
		// de 8 intervalos
		// Por eso ponemos 8 en el tercer parametro del addSeries
		dataset.addSeries("Frecuencias de los ingresos", vector, 8);
		return dataset;
	}

	private static JFreeChart crearChart(IntervalXYDataset dataset) {
		JFreeChart chart = ChartFactory.createHistogram("Histograma", null, null, dataset, PlotOrientation.VERTICAL,
				true, true, false);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		try {
//			ChartUtilities.saveChartAsJPEG(new File("C:\\histograma.jpg"), chart, 500, 475);
			ChartUtilities.saveChartAsJPEG(new File("C:/histograma.jpg"), chart, 500, 475);
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo");
		}
		return chart;
	}

	public static JPanel crearPanel() {
		JFreeChart chart = crearChart(crearDataset());
		return new ChartPanel(chart);
	}

	public static void main(String[] args) throws IOException {
		Histograma1 histo = new Histograma1("Histograma");
		histo.pack();
		RefineryUtilities.centerFrameOnScreen(histo);
		histo.setVisible(true);
	}
}
