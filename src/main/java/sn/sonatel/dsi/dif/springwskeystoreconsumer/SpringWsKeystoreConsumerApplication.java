package sn.sonatel.dsi.dif.springwskeystoreconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.WebServiceException;
import sn.sonatel.dsi.dif.springwskeystoreconsumer.client.TeamClient;
import sn.sonatel.dsi.dif.springwskeystoreconsumer.wsdl.GetTeamResponse;
import sn.sonatel.dsi.dif.springwskeystoreconsumer.wsdl.Team;

@SpringBootApplication
@Slf4j
public class SpringWsKeystoreConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWsKeystoreConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(TeamClient teamClient) {
		log.info("TeamClient: {} ", teamClient);
		return args -> {
			String countryCode = "HU";
			try {
				GetTeamResponse response = teamClient.getTeamByCountryCode(countryCode);
				Team team = response.getTeam();
				if (team != null) {
					log.info("countryCode: '{}', country: '{}', team nick name:'{}', coach:'{}'",
							team.getCountryCode(), team.getCountry(), team.getNickName(), team.getCoach());
				}
			} catch (WebServiceException e) {
				log.error("Error {} ", e.getMessage());
			}
		};
	}

}

