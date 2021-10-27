package br.com.letscode.java.stringapiletscode.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MovieInformation {

        @JsonProperty("imdbID")
        private String imdbId;
        @JsonProperty("Title")
        private String title;
        @JsonProperty("Year")
        private Integer year;
        @JsonProperty("Type")
        private String type;
        @JsonProperty("Released")
        private String released;
        @JsonProperty("Genre")
        private String genre;
        @JsonProperty("Language")
        private String language;
        @JsonProperty("Country")
        private String country;
        @JsonProperty("imdbRating")
        private String imdbRating;

        public void setYear(String year) {
            this.year = convertYear(year);
        }

        private int convertYear(final String year) {
            if (year.matches("\\d+")) {
                return Integer.parseInt(year);
            }
            return Arrays.stream(year.split("\\D"))
                    .map(Integer::parseInt)
                    .findFirst()
                    .orElseThrow();
        }
}
