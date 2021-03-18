import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class PriorityQueueTest {
    public static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments(new int[]{4,3,6,7} , new int[]{3,4,6,7}),
                arguments(new int[]{5,2,7,8} , new int[]{2,5,7,8}),
                arguments(new int[]{1,9,6,7} , new int[]{1,6,7,9}),
                arguments(new int[]{6,2,4,8} , new int[]{2,4,6,8}),
                arguments(new int[]{4,3,6,7} , new int[]{3,4,6,7})
        );
    }

    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] input, int[] expected) {
        PriorityQueue<Integer> test = new PriorityQueue<>();
        for (int k : input) {
            test.offer(k);
        }
        for (int j : expected) {
            assertEquals(j, test.poll());
        }
    }

    @Test
    public void InitialCapacityTest() {
        assertThrows(IllegalArgumentException.class, ()-> new PriorityQueue(-1,null));
    }

    @Test
    public void AddTest() {
        assertThrows(NullPointerException.class, ()-> new PriorityQueue().add(null));
    }

    @Test
    public void OfferTest() {
        assertThrows(NullPointerException.class, ()-> new PriorityQueue().offer(null));
    }
}
