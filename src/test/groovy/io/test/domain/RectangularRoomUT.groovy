package io.test.domain

import spock.lang.Specification
import spock.lang.Subject

class RectangularRoomUT extends Specification {

    @Subject
    private Room room = new RectangularRoom(
            BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3))

    def "should calculate room area"() {
        expect:
        room.roomArea == BigDecimal.valueOf(22)
    }

    def "should calculate smallest side area"() {
        expect:
        room.smallestSideArea == BigDecimal.valueOf(2)
    }
}
