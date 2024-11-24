package eventfeeprices.domain.model;

import eventfees.domain.model.EventFee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "[EventFeePrices]", schema = "[Core]")
public class EventFeePrices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price_all_gender")
    private BigDecimal priceAllGender;

    @Column(name = "price_male")
    private BigDecimal priceMale;

    @Column(name = "price_female")
    private BigDecimal priceFemale;

    @ManyToOne
    @JoinColumn(name = "event_fee_id", nullable = false)
    private EventFee eventFee;

}
