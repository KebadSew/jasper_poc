package org.example;

import lombok.Getter;

@Getter
public class MyData {
  private String[] columnNames;
  private String[][] data;

  public MyData() {
    init();
  }

  public void init(){
     columnNames = new String[]{"Id", "Name", "Department", "Email"};
     data = new String[][]{
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
  }
}
