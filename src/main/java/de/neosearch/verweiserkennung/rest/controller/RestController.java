package de.neosearch.verweiserkennung.rest.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;

import com.opencsv.CSVReader;

import de.neosearch.verweiserkennung.TextAnalyzer;
import de.neosearch.verweiserkennung.TextAnalyzerFactory;
import de.neosearch.verweiserkennung.tokenfilter.WhitelistFilter;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private static final Logger log = LoggerFactory.getLogger(RestController.class);
	private List<WhitelistFilter> whitelistFilters = new ArrayList<>();

	@Value("classpath:norms.csv")
	Path normsFile;

	@PostConstruct
	public void init() throws IOException {
//		resource.
		try (CSVReader reader = new CSVReader(Files.newBufferedReader(normsFile))) {
			reader.forEach(str -> {
				System.out.println(str[0] + " -> " + str[1]);
			});
		}

//		WhitelistFilter aktenzeichenFilter = new WhitelistFilter();

	}

	@PostMapping("annotate")
	public void annotate(AnnotationRequest req) {
		if (req == null || req.getText() == null)
			throw new RuntimeException("Nothing to annotate");
		String text = req.getText();
		TextAnalyzer textAnalyzer = null;

		log.info("Annotating Request : " + req.getText().substring(0, Math.max(15, req.getText().length())) + "...");

	}
}
