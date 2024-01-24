package ahmed.springframework.msscbrewery.services;

import ahmed.springframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeer(UUID beerId) {
        return BeerDto.builder()
                .id(beerId)
                .beerName("Nularica")
                .beerStyle("Bezalkoholno")
                .upc(387L)
                .build();
    }

    @Override
    public BeerDto savedNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public BeerDto updateExistingBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.info("Pozvana metoda deleteBeerById");
    }
}
