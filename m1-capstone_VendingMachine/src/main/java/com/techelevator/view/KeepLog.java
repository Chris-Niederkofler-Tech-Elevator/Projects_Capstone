package com.techelevator.view;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class KeepLog {
	
	public void writer (String transactionType, BigDecimal amount, BigDecimal balance) {
		
		LocalDate today = LocalDate.now();
		LocalTime timeNow = LocalTime.now();
		try(PrintWriter keepLog = new PrintWriter (new FileOutputStream (new File("./log.text"), true))) {
			
			String printCurrentDate = today.toString();
			String printCurrentTime = timeNow.toString().substring(0, timeNow.toString().length() - 4);
			String printTransactionType = transactionType.toString();
			String printAmount = amount.toString();
			String printBalance = balance.toString();
			
			keepLog.println(printCurrentDate + " " + printCurrentTime + " " +  String.format("%-20s", printTransactionType) +
					String.format("%-10s", "$" + printAmount) + String.format("%-10s", "$" + printBalance));
			
		}catch (FileNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	

}

