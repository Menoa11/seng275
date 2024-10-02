import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class LeapYearTest {
    @Property
    void leapYearDivisibleBy400(@ForAll @From("divisibleBy400") int year) {
        assertThat(LeapYear.isLeapYear(year)).isTrue();
    }

    @Property
    void notLeapYearDivisibleBy100ButNot400(@ForAll @From("divisibleBy100Not400") int year) {
        assertThat(LeapYear.isLeapYear(year)).isFalse();
    }

    @Property
    void leapYearDivisibleBy4ButNot100(@ForAll @From("divisibleBy4Not100") int year) {
        assertThat(LeapYear.isLeapYear(year)).isTrue();
    }

    @Property
    void notLeapYearNotDivisibleBy4(@ForAll @From("notDivisibleBy4") int year) {
        assertThat(LeapYear.isLeapYear(year)).isFalse();
    }

    @Property
    void invalidYear(@ForAll @From("invalidYearRange") int year) {
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> divisibleBy400() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 400 == 0);
    }

    @Provide
    private Arbitrary<Integer> divisibleBy100Not400() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 100 == 0 && n % 400 != 0);
    }

    @Provide
    private Arbitrary<Integer> divisibleBy4Not100() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 4 == 0 && n % 100 != 0);
    }

    @Provide
    private Arbitrary<Integer> notDivisibleBy4() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 4 != 0);
    }

    @Provide
    private Arbitrary<Integer> invalidYearRange() {
        return Arbitraries.integers().filter(n -> n < 1);
    }

}