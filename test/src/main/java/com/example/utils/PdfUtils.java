
package com.example.utils;

import net.sf.jasperreports.engine.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class PdfUtils {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PdfUtils.class);	

	
	public static void  generatePdf(HashMap<String, Object> params,
			String manifestPath,
			Collection<?> optionalList,
			InputStream secondaryPdfToAppend) throws JRException, IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();			
		JasperReport report = JasperCompileManager.compileReport(new ClassPathResource(manifestPath).getInputStream());
		//it's important to provide an instance of JREmptyDataSource otherwise by default the report will have no pages
		JasperPrint print = null;
		if(optionalList != null)
			print = JasperFillManager.fillReport(report, params, new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource(optionalList));
		else
			print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
		//		finally, export it to PDF
		LOGGER.info("Exporting the filled out report to a file.");

		File pdfOutputFile = new File("jasper.pdf");
		FileOutputStream output = new FileOutputStream(pdfOutputFile);

		JasperExportManager.exportReportToPdfStream(print, output);
		LOGGER.info("Done with export. Find the file at \"{}\" then end this process when done");
		
		output.flush();
		output.close();
	
	}
	
}

