
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @Id

    @JsonProperty("title")
    private String title;

    @JsonProperty("producers")
    private String producers;

    private String studios;

    @JsonProperty("year")
    private Integer year;

    public Movie() {
    }

}
