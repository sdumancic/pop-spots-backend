package eventfees.api.rest.dto;

import eventfeeprices.api.rest.dto.EventFeePriceDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventFeeDto {
    private Long id;
    private String description;
    private Boolean active;
    private List<EventFeePriceDto> eventFeePrices;
}
