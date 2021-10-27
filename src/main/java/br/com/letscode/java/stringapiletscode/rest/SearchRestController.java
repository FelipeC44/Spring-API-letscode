package br.com.letscode.java.stringapiletscode.rest;

import br.com.letscode.java.stringapiletscode.omdb.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class SearchRestController {
    FileCsv fileCsv = new FileCsv();

    private final MovieMinimalRestRepository restRepository;
    private final MovieInformationScrapRepository scrapRepositoryInformation;

    public SearchRestController(MovieMinimalRestRepository restRepository,
                                MovieInformationScrapRepository scrapRepositoryInformation) {
        this.restRepository = restRepository;
        this.scrapRepositoryInformation = scrapRepositoryInformation;
    }

    @GetMapping("/movies")
    public MovieInformation information (@PathVariable ("id") String movieId) {
        return this.scrapRepositoryInformation.information(movieId);
    }
    @GetMapping("/search")
    public Optional<ResultSearch> search(@RequestParam String title){
        List<ResultSearch> resultSearch = fileCsv.cacheCsv(title);
        if (resultSearch == null){
            ResultSearch result = this.restRepository.search(title);
            fileCsv.writeFile(result, title);
            return Optional.ofNullable(result);
        } else {
            return resultSearch.stream().findFirst();

        }
    }
}