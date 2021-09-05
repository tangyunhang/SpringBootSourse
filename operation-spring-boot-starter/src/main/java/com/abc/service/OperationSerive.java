package com.abc.service;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * 核心业务类（运算）
 */
@AllArgsConstructor
public class OperationSerive {
    private final String ADD = "+";
    private final String SUBTRACT = "-";
    private final String MUlLTIPLY = "*";
    private final String DIVIDE = "/";
    private String operator;

    public Double operation(String d1, String d2) {
        BigDecimal b1 = BigDecimal.valueOf(Double.valueOf(d1));
        BigDecimal b2 = BigDecimal.valueOf(Double.valueOf(d2));
        BigDecimal b = null;
        switch (operator) {
            case ADD:
                b = b1.add(b2);
                break;
            case SUBTRACT:
                b = b1.subtract(b2);
                break;
            case MUlLTIPLY:
                b = b1.multiply(b2);
                break;
            case DIVIDE:
                b = b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP);
                break;
            default:
                b = BigDecimal.ZERO;
                break;
        }
        return b.doubleValue();
    }
}
