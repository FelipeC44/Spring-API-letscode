package br.com.letscode.java.stringapiletscode.omdb;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "movieInformationScrap", url = "${omdb.url}")
public interface MovieInformationScrapRepository {
    @GetMapping
    MovieInformation information(@RequestParam("i") String imdbId);
}
