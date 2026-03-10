package io.github.ktaekim2.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MyHashMapTest {

    @Test
    public void put_must_work() {
        // given
        MyHashMap map = new MyHashMap();

        // when
        map.put(1, 1);

        // then
        assertThat(map.get(1)).isEqualTo(1);
    }
}
