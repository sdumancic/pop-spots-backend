package eventtypes.api.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventTypeDto {
    private Integer id;
    private String name;
    private String description;
    private Boolean active;
}
