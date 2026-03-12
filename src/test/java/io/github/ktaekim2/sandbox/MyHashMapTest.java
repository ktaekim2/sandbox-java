package io.github.ktaekim2.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MyHashMapTest {

    @Test
    public void put_must_work() {
        // given & when
        MyHashMap map = initMyHashMap();

        // then
        assertThat(map.get(1)).isEqualTo(1);
    }

    private MyHashMap initMyHashMap() {
        MyHashMap map = new MyHashMap();

        for (int i = 0; i < 5; i++) {
            map.put(i, i);
        }

        return map;

    }

    @Test
    public void remove_must_work() {
        // given & when
        MyHashMap map = initMyHashMap();

        // when
        map.remove(1);

        // then
        assertThat(map.get(1)).isEqualTo(-1);

    }
}
