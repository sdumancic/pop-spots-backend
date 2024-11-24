package eventfees.api.rest.dto;

import eventfeeprices.api.rest.dto.EventFeePriceDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class EventFeeDto {
    private Integer id;
    private String description;
    private Boolean active;
    private List<EventFeePriceDto> eventFeePrices;
}
