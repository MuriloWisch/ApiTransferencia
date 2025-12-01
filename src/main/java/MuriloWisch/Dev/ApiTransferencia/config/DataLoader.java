package MuriloWisch.Dev.ApiTransferencia.config;

import MuriloWisch.Dev.ApiTransferencia.repository.CarteiraTipoRepository;
import MuriloWisch.Dev.ApiTransferencia.entity.CarteiraTipo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final CarteiraTipoRepository carteiraTipoRepository;

    public DataLoader(CarteiraTipoRepository carteiraTipoRepository) {
        this.carteiraTipoRepository = carteiraTipoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(CarteiraTipo.Enum.values())
                .forEach(carteiraTipo -> carteiraTipoRepository.save(carteiraTipo.get()));

    }
}
