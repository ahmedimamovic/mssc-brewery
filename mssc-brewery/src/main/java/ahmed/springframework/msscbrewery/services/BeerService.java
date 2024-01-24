package ahmed.springframework.msscbrewery.services;

import ahmed.springframework.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    public BeerDto getBeer(UUID beerId);

    BeerDto savedNewBeer(BeerDto beerDto);

    BeerDto updateExistingBeer(BeerDto beerDto);

    void deleteBeerById(UUID beerId);
}
