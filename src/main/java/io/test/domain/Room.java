package io.test.domain;

import java.math.BigDecimal;

/**
 * In current business case it's useless & I would say it's even an anti-pattern.
 * However I'm providing this interface to prove that it'd be easy to have different shapes of rooms without modifying
 * all codebase - all that is needed is providing mechanism to identify by input what kind of room it is and
 * invoking valid factory while working against this interface.
 */
public interface Room {

    BigDecimal getRoomArea();

    BigDecimal getSmallestSideArea();
}
