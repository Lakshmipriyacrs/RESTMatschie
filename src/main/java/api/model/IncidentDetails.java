package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import java.util.Optional;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class IncidentDetails {

    @JsonProperty("number")
    private String number;

    @JsonProperty("category")
    private String category;

    @JsonProperty("state")
    private String state;

    @JsonProperty("short_description")
    private String short_description;

    @JsonProperty("description")
    private String description;

}
