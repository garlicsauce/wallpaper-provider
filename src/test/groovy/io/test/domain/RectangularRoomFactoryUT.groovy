package io.test.domain

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class RectangularRoomFactoryUT extends Specification {

    @Subject
    private RectangularRoomFactory rectangularRoomFactory = RectangularRoomFactory.instance

    @Unroll
    def "should return null for invalid dimensions definition (#input)"() {
        expect:
        rectangularRoomFactory.create(input) == null

        where:
        input << [
                '1x1x', 'x1x1', '1xx1', '', ' ', null
        ]
    }

    def "should return instance of RectangularRoom"() {
        given:
        def input = '1x2x3'

        when:
        def result = rectangularRoomFactory.create(input)

        then:
        result.length == BigDecimal.valueOf(1)
        result.width == BigDecimal.valueOf(2)
        result.height == BigDecimal.valueOf(3)
    }
}
