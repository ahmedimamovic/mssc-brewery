package ahmed.springframework.msscbrewery.web.controller;

import ahmed.springframework.msscbrewery.services.BeerService;
import ahmed.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeer(beerId), HttpStatus.OK);
    }

    @PostMapping()
//    @RequestBody()
    public ResponseEntity createBeer(@RequestBody BeerDto beerDto) {
        BeerDto savedDto = beerService.savedNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/"+savedDto.getId().toString());
        return new ResponseEntity(beerDto, headers, HttpStatus.CREATED);
    }

    @PutMapping()
//    @RequestBody()
    public ResponseEntity updateBeer(@RequestBody BeerDto beerDto) {

        BeerDto savedDto = beerService.updateExistingBeer(beerDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
