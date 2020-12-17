package ch.aurachain.thirft;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ThirftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirftApplication.class, args);
	}

	@Bean
	public TProtocolFactory tProtocolFactory() {
		return new TCompactProtocol.Factory();
	}

}
