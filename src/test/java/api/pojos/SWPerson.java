package api.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
public class SWPerson {
    private String name;
    private String height;
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    @JsonProperty("homeworld")
    private String homeWorld;
    private String created;
    private String edited;
    private String url;
    private List<Object> species;
    private List<String> vehicles;
    private List<String> starships;
    private List<String> films;


}
