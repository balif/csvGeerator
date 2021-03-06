package pl.coma.agora.csvGenerator.csvGenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.coma.agora.csvGenerator.csvGenerator.CSVUtils;

import java.io.FileWriter;
import java.util.Arrays;

@SpringBootApplication
public class CsvGeneratorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CsvGeneratorApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        String csvFile = "abc.csv";
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, Arrays.asList("a", "b", "c", "d"));

        //custom separator + quote
        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bb,b", "cc,c"), ',', '"');

        //custom separator + quote
        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bbb", "cc,c"), '|', '\'');

        //double-quotes
        CSVUtils.writeLine(writer, Arrays.asList("aaa", "bbb", "cc\"c"));


        writer.flush();
        writer.close();
    }
}
