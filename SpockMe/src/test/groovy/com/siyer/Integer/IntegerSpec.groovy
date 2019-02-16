package com.siyer.Integer

import spock.lang.*

class IntegerSpec extends  Specification {

    void "An integer can be incremented"() {

        given:
        int i = 1

        when:
        i++

        then:
        i == 2
    }
}
