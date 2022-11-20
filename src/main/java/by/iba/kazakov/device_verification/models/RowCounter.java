package by.iba.kazakov.device_verification.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor

public class RowCounter {


  //public RowCounter rowCounter = new RowCounter();
  ArrayList<RowCounter> rowCounters = new ArrayList<RowCounter>();

  public ArrayList<RowCounter> setR(int x){

     for (int i=1; i<=x; i++){

         rowCounters.add(null);

     }
     return rowCounters;
  }

   public ArrayList<RowCounter> getRowCounters() {
      return rowCounters;
   }
}




