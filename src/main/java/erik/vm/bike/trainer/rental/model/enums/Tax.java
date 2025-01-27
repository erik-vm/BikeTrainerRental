package erik.vm.bike.trainer.rental.model.enums;

import lombok.Getter;

@Getter
public enum Tax {
    VAT(1.24);


    private final double taxPresent;

    Tax(double taxPresent) {
        this.taxPresent = taxPresent;
    }
}
