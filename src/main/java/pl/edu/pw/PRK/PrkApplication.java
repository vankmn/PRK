package pl.edu.pw.PRK;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
