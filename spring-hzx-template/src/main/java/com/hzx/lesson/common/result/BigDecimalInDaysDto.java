package com.hzx.lesson.common.result;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author shenzh
 */
@Data
@Builder
public class BigDecimalInDaysDto {
    private Integer date;
    private BigDecimal decimal;
}
