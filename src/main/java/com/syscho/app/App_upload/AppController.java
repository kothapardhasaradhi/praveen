package com.syscho.app.App_upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

	private static final String CANDIDATE = "classpath:templates/TechGig.txt";

	@GetMapping("/app")
	public String index() {
		return "Upload";
	}

	@GetMapping("/download/candidate")
	public String downlaod(HttpServletResponse response) throws IOException {

		File file = ResourceUtils.getFile(CANDIDATE);
		InputStream inputStream = new FileInputStream(file);
		response.setContentType("application/csv");
		response.setHeader("Content-Disposition", "attachment; filename=TechGig.txt");
		IOUtils.copy(inputStream, response.getOutputStream());
		response.flushBuffer();
		inputStream.close();
		return "Upload";
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile mulFile, RedirectAttributes redirectAttributes)
			throws IOException, ClassNotFoundException {

		// https://howtodoinjava.com/apache-commons/parse-read-write-csv-files-opencsv-tutorial/

		return "Upload";

	}

}
