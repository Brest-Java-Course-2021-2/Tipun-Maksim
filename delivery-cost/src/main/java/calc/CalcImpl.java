package calc;

import java.math.BigDecimal;

public class CalcImpl implements Calc{
    @Override
    public BigDecimal handle(BigDecimal weight, BigDecimal pricePerKg, BigDecimal length, BigDecimal pricePerKm) {
        BigDecimal result = weight.multiply(pricePerKg).add(length.multiply(pricePerKm));
        return result.setScale(3,BigDecimal.ROUND_CEILING);
    }
}
