package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import java.util.HashMap;

public class SimpleReport {

  DefaultTableModel tableModel;

  public static void main(String[] args) {
    new SimpleReport();
  }


  public SimpleReport() {
    JasperPrint jasperPrint = null;
    TableModelData();
    try {
      JasperReport jasperReport = JasperCompileManager
          .compileReport(getClass().getClassLoader().getResourceAsStream("report1.jrxml"));
      jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(),
          new JRTableModelDataSource(tableModel));
      JasperViewer jasperViewer = new JasperViewer(jasperPrint);
      jasperViewer.setVisible(true);
    } catch (JRException ex) {
      ex.printStackTrace();
    }

  }

  private void TableModelData() {
    String[] columnNames = {"Id", "Name", "Department", "Email"};
    String[][] data = {
        {"111", "G Conger", " Orthopaedic", "jim@wheremail.com"},
        {"222", "A Date", "ENT", "adate@somemail.com"},
        {"333", "R Linz", "Paedriatics", "rlinz@heremail.com"},
        {"444", "V Sethi", "Nephrology", "vsethi@whomail.com"},
        {"555", "K Rao", "Orthopaedics", "krao@whatmail.com"},
        {"666", "V Santana", "Nephrology", "vsan@whenmail.com"},
        {"777", "J Pollock", "Nephrology", "jpol@domail.com"},
        {"888", "H David", "Nephrology", "hdavid@donemail.com"},
        {"999", "P Patel", "Nephrology", "ppatel@gomail.com"},
        {"101", "C Comer", "Nephrology", "ccomer@whymail.com"}
    };
    tableModel = new DefaultTableModel(data, columnNames);
  }
}
