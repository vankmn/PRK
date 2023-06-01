package pl.edu.pw.PRK;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.edu.pw.PRK.dao.ScheduleOfMoviesDAO;

@SpringBootApplication
public class PrkApplication {
	public static void main(String[] args) {
		SpringApplication.run(PrkApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner (ScheduleOfMoviesDAO scheduleOfMoviesDAO){
//		return runner -> {
//			createScheduleOfMovies(scheduleOfMoviesDAO);
//		};
//	}
//
//	private void createScheduleOfMovies(ScheduleOfMoviesDAO scheduleOfMoviesDAO) {
//	}
}
