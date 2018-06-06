package pl.agora.test.csvGenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.util.Arrays;

@SpringBootApplication
public class ZalandotestApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ZalandotestApplication.class, args);
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
