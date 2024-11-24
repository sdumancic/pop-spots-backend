package eventfeeprices.service;

import eventfeeprices.api.rest.dto.EventFeePriceDto;
import eventfeeprices.domain.model.EventFeePrices;

public class EventFeePriceMapper {

    public static EventFeePriceDto toEventFeePricesDto(EventFeePrices eventFeePrices) {
        return EventFeePriceDto.builder()
                .id(eventFeePrices.getId())
                .priceAllGender(eventFeePrices.getPriceAllGender())
                .priceFemale(eventFeePrices.getPriceFemale())
                .priceMale(eventFeePrices.getPriceMale())
                .build();
    }

    public static EventFeePrices toEventFeePrices(EventFeePriceDto dto) {
        EventFeePrices eventFeePrice = new EventFeePrices();
        eventFeePrice.setId(dto.getId());
        eventFeePrice.setPriceAllGender(dto.getPriceAllGender());
        eventFeePrice.setPriceFemale(dto.getPriceFemale());
        eventFeePrice.setPriceMale(dto.getPriceMale());

        return eventFeePrice;
    }
}
