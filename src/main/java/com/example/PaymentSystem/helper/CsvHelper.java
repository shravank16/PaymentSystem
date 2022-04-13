package com.example.PaymentSystem.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.example.PaymentSystem.entity.Bill;

public class CsvHelper {

	public static ByteArrayInputStream tutorialsToCSV(List<Bill> tutorials) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (Bill tutorial : tutorials) {
	        List<String> data = Arrays.asList(
	              String.valueOf(tutorial.getId()),
	              String.valueOf(tutorial.getAmount()),
	              String.valueOf(tutorial.getDueDate()),
	              String.valueOf(tutorial.getStatus()));
	        csvPrinter.printRecord(data);
	      }
	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
}
