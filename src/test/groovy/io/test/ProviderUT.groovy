package io.test

import spock.lang.Specification

class ProviderUT extends Specification {

    def "should throw exception when running program without path to input"() {
        when:
        Provider.main()

        then:
        thrown(IllegalArgumentException)
    }
}
