package coen275project;


import java.io.Serializable;
import java.util.*;


public class ExpenseProfile implements Serializable {
    List<ExpenseRecord> explist = new ArrayList<>();
    
    public void addExpenseRecord(ExpenseRecord er) {
    	explist.add(er);
    	
    }
    
}
