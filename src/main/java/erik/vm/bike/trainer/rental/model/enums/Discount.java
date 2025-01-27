package erik.vm.bike.trainer.rental.model.enums;

import lombok.Getter;

@Getter
public enum Discount {

    ZERO_PRESENT(1.0),
    TEN_PRESENT(0.1),
    TWENTY_PRESENT(0.2),
    THIRTY_PRESENT(0.3),
    FORTY_PRESENT(0.4),
    FIFTY_PRESENT(0.5),
    SIXTY_PRESENT(0.6),
    SEVENTY_PRESENT(0.7),
    EIGHTY_PRESENT(0.8),
    NINETY_PRESENT(0.9),
    HUNDRED_PRESENT(0);


    private final double present;

    Discount(double present) {
        this.present = present;
    }

}
