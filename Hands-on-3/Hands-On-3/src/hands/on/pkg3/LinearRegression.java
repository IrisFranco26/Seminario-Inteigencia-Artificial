package hands.on.pkg3;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.apache.commons.math.stat.regression.SimpleRegression;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

public class LinearRegression{
       double[] x={1,2,3,5,7,8,12,13,16,18};
       double[] y={1.3,3.4,5.4,7.2,10.3,9.3,8.9,11,13,12}; 
       SimpleRegression sr = new SimpleRegression();
       Plot2DPanel plot=new Plot2DPanel();
       JTextArea resultados= new JTextArea();
    
       public LinearRegression(){
           for(int i=0;i<x.length;i++){
               sr.addData(x[i], y[i]);
           }
           double[] yc =new double[y.length];
           for(int i=0;i<x.length;i++){
               yc[i]=sr.predict(x[i]);
           }
           plot.addLegend("South");
           plot.addScatterPlot("Datos Originales", x, y);
           plot.addLinePlot("Regresion", x, yc);
           
           BaseLabel titulo = new BaseLabel("Regresion Lineal", Color.BLUE, yc);
           plot.addPlotable(titulo);
           
           JFrame frame = new JFrame("Regresion Lineal Simple");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(600,500);
           frame.add(plot,BorderLayout.CENTER);
           frame.setVisible(true);
       }
       
       public static void main(String[] args) {
         new LinearRegression();
    }
    }