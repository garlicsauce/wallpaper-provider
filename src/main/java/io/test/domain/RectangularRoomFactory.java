package io.test.domain;

import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RectangularRoomFactory {

    private static final Logger LOGGER = Logger.getLogger(RectangularRoomFactory.class.getName());
    private static final String DIMENSIONS_SEPARATOR = "x";
    private static final Pattern VALID_LINE_PATTERN = Pattern.compile(
        String.format("((\\d+\\.?\\d+)|\\d+)%s((\\d+\\.?\\d+)|\\d+)%s((\\d+\\.?\\d+)|\\d+)",
            DIMENSIONS_SEPARATOR, DIMENSIONS_SEPARATOR));
    private static final RectangularRoomFactory INSTANCE = new RectangularRoomFactory();

    private RectangularRoomFactory() {}

    public static RectangularRoomFactory getInstance() {
        return INSTANCE;
    }

    public RectangularRoom create(String dimensionsString) {
        if (dimensionsString == null || dimensionsString.isBlank() || !isValidPattern(dimensionsString)) {
            LOGGER.warning(String.format("Dimensions definition %s invalid, skipping", dimensionsString));
            return null;
        } else {
            String[] dimensions = dimensionsString.split(DIMENSIONS_SEPARATOR);
            return new RectangularRoom(
                new BigDecimal(dimensions[0]),
                new BigDecimal(dimensions[1]),
                new BigDecimal(dimensions[2]));
        }
    }

    private static boolean isValidPattern(String line) {
        return VALID_LINE_PATTERN.matcher(line).find();
    }
}
