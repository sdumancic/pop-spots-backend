package eventfeeprices.api.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class EventFeePriceDto {
    private Integer id;
    private BigDecimal priceAllGender;
    private BigDecimal priceMale;
    private BigDecimal priceFemale;
}
