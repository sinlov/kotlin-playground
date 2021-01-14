package temp;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import java.util.Random;

import static java.util.UUID.randomUUID;

public abstract class TestTemp {

    protected static final int NUMBER_NEGATIVE_ONE = -1;
    protected static final int NUMBER_ZERO = 0;
    protected static final int NUMBER_ONE = 1;
    protected static final String STRING_EMPTY = "";
    protected static final String STRING_NULL = null;

    protected static final String STRING_UNIQUE = randomUUID().toString();
    protected static final String STRING_UNIQUE2 = randomUUID().toString() + randomUUID().toString();

    protected static final Integer RANDOM_INTEGER = new Random().nextInt();
    protected static final Integer RANDOM_INTEGER_POSITIVE = new Random().nextInt(Integer.SIZE - 1);
    protected static final Long RANDOM_LONG = new Random().nextLong();
    protected static final Double RANDOM_DOUBLE = new Random().nextDouble();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }
}
