package com.sinlov.kotlin.design.patterns;

import org.junit.Test;
import temp.TestTemp;

import static org.junit.Assert.*;

public class BaseMockTest extends TestTemp {

    private BaseMock baseMock;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        baseMock = new BaseMock();
    }

    @Test
    public void test_01_sum() {
        int sum = baseMock.sum(1, 2);
        assertEquals(3, sum);
    }
}