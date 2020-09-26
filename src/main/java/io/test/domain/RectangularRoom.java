package io.test.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RectangularRoom implements Room {

    private final BigDecimal length;
    private final BigDecimal width;
    private final BigDecimal height;

    RectangularRoom(BigDecimal length, BigDecimal width, BigDecimal height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public BigDecimal getRoomArea() {
        return BigDecimal.valueOf(2).multiply(
            length.multiply(width)
                .add(length.multiply(height))
                .add(width.multiply(height)));
    }

    @Override
    public BigDecimal getSmallestSideArea() {
        List<BigDecimal> sortedDimensions = Stream.of(length, width, height)
            .sorted()
            .collect(Collectors.toList());

        return sortedDimensions.get(0).multiply(sortedDimensions.get(1));
    }
}
