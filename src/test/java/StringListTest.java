import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringListTest {

    private StringList1 stringList;

    @Before
    public void setUp() {
        stringList = new StringList1();
    }

    @Test
    public void addShouldAddNewStringAtTheEndOfTheList() {
        assertTrue(stringList.add("hello"));
        assertArrayEquals(new String[] {"hello"}, stringList.get());
    }

    @Test
    public void addShouldAddNewStringAtTheEndIfStringAlreadyPresent() {
        assertTrue(stringList.add("hello"));
        assertTrue(stringList.add("charlie"));
        assertArrayEquals(new String[] {"hello", "charlie"}, stringList.get());
    }

    @Test
    public void addShouldReturnFalseIfStringAlreadyPresent() {
        assertTrue(stringList.add("hello"));
        assertTrue(stringList.add("charlie"));
        assertFalse(stringList.add("hello"));
        assertArrayEquals(new String[] {"hello", "charlie"}, stringList.get());
    }

    @Test
    public void containsShouldReturnTrueIfStringIsPresent() {
        stringList.add("hello");
        stringList.add(("bye"));
        assertTrue(stringList.contains("hello"));
    }

    @Test
    public void containsShouldReturnFalseIfStringIsNotPresent() {
        stringList.add("hello");
        stringList.add(("bye"));
        assertFalse(stringList.contains("charlie"));
    }

    @Test
    public void deleteShouldReturnTrueIfStringIsRemoved() {
        stringList.add("hello");
        stringList.add(("bye"));
        assertTrue(stringList.delete("hello"));
        assertArrayEquals(new String[] {"bye"}, stringList.get());
    }

    @Test
    public void deleteShouldReturnFalseIfStringNotPresent() {
        stringList.add("hello");
        stringList.add(("bye"));
        assertFalse(stringList.delete("charlie"));
        assertArrayEquals(new String[] {"hello", "bye"}, stringList.get());
    }
}
