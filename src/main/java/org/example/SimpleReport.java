package org.example;

import java.util.Collections;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.table.DefaultTableModel;
import java.io.InputStream;
import java.util.HashMap;

public class SimpleReport {

  public static void main(String[] args) {

    MyData myData = new MyData();
    Map<String, Object> noParameters = new HashMap<>();
    
    DefaultTableModel tableModel = new DefaultTableModel(myData.getData(), myData.getColumnNames());
    JRTableModelDataSource dataSource = new JRTableModelDataSource(tableModel);

    try {
      JasperReport jasperReport = JasperCompileManager
          .compileReport(SimpleReport.class.getClassLoader().getResourceAsStream("report1.jrxml"));
      JasperPrint jasperPrint = JasperFillManager
          .fillReport(jasperReport, noParameters, dataSource);

      JasperViewer jasperViewer = new JasperViewer(jasperPrint);
      jasperViewer.setVisible(true);
    } catch (JRException ex) {
      ex.printStackTrace();
    }
  }
}
