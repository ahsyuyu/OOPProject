package coen275project;

import java.util.*;

public class ExpenseRecord {
    private Date time;
    private float totalExpense;
    private String location;
    private HashMap<String, Float> foodConsumeList;
    
    public ExpenseRecord(Date time, float totalExpense, String location, HashMap<String, Float> foodConsumeList) {
    	this.time = time;
    	this.totalExpense = totalExpense;
    	this.location = location;
    	this.foodConsumeList = foodConsumeList;
    		
    }
    
}
