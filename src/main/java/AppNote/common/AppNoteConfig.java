package AppNote.common;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AppNoteConfig {
    @Bean
    public ModelMapper modelMapper() { return new ModelMapper(); }
}
