package ma.Kiddy204.treasurefinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TreasureFinderApplication extends ServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(TreasureFinderApplication.class, args);
	}

}
