package eventtypes.api.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventTypeDto {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
}
