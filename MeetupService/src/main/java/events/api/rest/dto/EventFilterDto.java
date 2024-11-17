package events.api.rest.dto;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventFilterDto {

    @QueryParam("filter[name]")
    private String name;

    @QueryParam("filter[description]")
    private String description;

    @QueryParam("filter[type]")
    private Long typeId;

    @QueryParam("filter[startTs]")
    private String startTs;

    @QueryParam("filter[endTs]")
    private String endTs;
}
