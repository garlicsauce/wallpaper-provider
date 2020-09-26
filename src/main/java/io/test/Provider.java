package io.test;

import io.test.domain.RectangularRoomFactory;
import io.test.domain.Room;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;

public class Provider {

    private static final Logger LOGGER = Logger.getLogger(Provider.class.getName());

    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("src\\main\\resources\\input1.txt"))
                .filter(s -> !s.isEmpty())
                .map(l -> l.split(" "))
                .flatMap(Arrays::stream)
                .map(dimensionsLine -> RectangularRoomFactory.getInstance().create(dimensionsLine))
                .filter(Objects::nonNull)
                .map(Provider::getResult)
                .forEach(result -> LOGGER.info(result.toString()));
        } catch (IOException e) {
            LOGGER.severe("Unable to process: " + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private static BigDecimal getResult(Room room) {
        return room.getRoomArea().add(room.getSmallestSideArea());
    }
}
