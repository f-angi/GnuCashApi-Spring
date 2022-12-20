package party.fangi.gnucashapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import party.fangi.gnucashapi.security.RsaKeyProperties;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(RsaKeyProperties.class)
public class GnuCashApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GnuCashApiApplication.class, args);
    }

}