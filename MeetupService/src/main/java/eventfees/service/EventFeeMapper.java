package eventfees.service;

import common.utils.BooleanUtils;
import eventfeeprices.service.EventFeePriceMapper;
import eventfees.api.rest.dto.EventFeeDto;
import eventfees.domain.model.EventFee;

public class EventFeeMapper {

    public static EventFeeDto toEventFeeDto(EventFee eventFee) {
        if (eventFee == null) {
            return null;
        }
        return EventFeeDto.builder()
                .id(eventFee.getId())
                .description(eventFee.getDescription())
                .active(BooleanUtils.fromShort(eventFee.getActive()))
                .eventFeePrices(eventFee.getEventsFeePrices().stream().map(EventFeePriceMapper::toEventFeePricesDto).toList())
                .build();
    }

    public static EventFee toEventFee(EventFeeDto dto) {
        if (dto == null) {
            return null;
        }
        EventFee eventFee = new EventFee();
        eventFee.setId(dto.getId());
        eventFee.setDescription(dto.getDescription());
        eventFee.setActive(BooleanUtils.fromBoolean(dto.getActive()));
        eventFee.setEventsFeePrices(dto.getEventFeePrices().stream().map(EventFeePriceMapper::toEventFeePrices).toList());

        return eventFee;
    }
}
