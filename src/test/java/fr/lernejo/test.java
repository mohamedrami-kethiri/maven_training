package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SampleTest {

    private Sample sample;

    @BeforeEach
    void setUp() {
        sample = new Sample();
    }

    @Test
    void test_add_operation() {
        int a = 212;
        int b = 1;
        int expected = a + b;
        int result = sample.op(Sample.Operation.ADD, a, b);
        Assertions.assertThat(result).as("Sum of " + a + " + " + b).isEqualTo(expected);
    }

    @Test
    void test_mult_operation() {
        int a = 213;
        int b = 213;
        int expected = a * b;
        int result = sample.op(Sample.Operation.MULT, a, b);
        Assertions.assertThat(result).as("Mult of " + a + " * " + b).isEqualTo(expected);
    }

    @Test
    void test_factorial_negative() {
        int n = -1;
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(n));
    }

    @Test
    void test_factorial_easy() {
        int n = 5;
        int expected = 120;
        int result = sample.fact(n);
        Assertions.assertThat(result).as("Factorial of 5").isEqualTo(expected);
    }
}
