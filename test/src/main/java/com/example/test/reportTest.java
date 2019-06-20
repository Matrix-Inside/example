package com.example.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.example.dto.PeopleDto;
import com.example.utils.PdfUtils;

import net.sf.jasperreports.engine.JRException;


public class reportTest {

	
	public static void main(String[] args) throws JRException, IOException {

		List<PeopleDto> list = new ArrayList<>();
		PeopleDto male = new PeopleDto();
		male.setNome("MARIO");
		male.setCognome("ROSSI");
		PeopleDto fermale = new PeopleDto();
		fermale.setNome("MARIA");
		fermale.setCognome("VERDI");
		list.add(fermale);
		list.add(male);
		
		Locale locale = new Locale("en", "EN");
		ResourceBundle bundle = ResourceBundle.getBundle("labels", locale);
		HashMap<String, Object> params = new HashMap<>();
		params.put("REPORT_RESOURCE_BUNDLE", bundle);	
		params.put("test1", "Hello World");	

	    PdfUtils.generatePdf(params, "mySimpleReport.jrxml", list, null);
		
	}
}
