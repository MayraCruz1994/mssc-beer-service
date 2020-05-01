package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobd")
                    .beerStyle("IPA")
                    .qualityToBrew(200)
                    .minOnHand(12)
                    .upc(3025547847L)
                    .price(new BigDecimal(12.95))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale_Ale")
                    .qualityToBrew(200)
                    .minOnHand(12)
                    .upc(3126547847L)
                    .price(new BigDecimal(11.95))
                    .build());
        }
    }
}
