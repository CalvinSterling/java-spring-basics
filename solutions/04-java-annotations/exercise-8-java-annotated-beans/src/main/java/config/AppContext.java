package config;

import logic.dispenser.Dispenser;
import logic.dispenser.DispenserV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class AppContext {
    @Bean
    @Scope(value = "prototype")
    public Dispenser getDispenser() {
        return new DispenserV2();
    }
}
