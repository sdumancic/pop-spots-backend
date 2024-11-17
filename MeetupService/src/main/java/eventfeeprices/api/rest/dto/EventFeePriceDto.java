package eventfeeprices.api.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EventFeePriceDto {
    private Long id;
    private Boolean active;
    private BigDecimal price;
    private BigDecimal priceMale;
    private BigDecimal priceFemale;
}
