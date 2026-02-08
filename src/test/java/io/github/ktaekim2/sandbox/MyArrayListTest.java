package io.github.ktaekim2.sandbox;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    @Test
    void add_should_increase_size() {
        MyArrayList list = new MyArrayList();
        list.add(10);
        list.add(20);

        // 검증: "리스트 사이즈는 2여야 한다"
        assertThat(list.size()).isEqualTo(2);

        // 검증: "0번째 요소는 10이어야 한다."
        assertThat(list.get(0)).isEqualTo(10);
    }

    @Test
    void shoud_resize_when_capacity_is_full() {
        // 1. Given: make list which size of 10
        MyArrayList list = new MyArrayList();

        // 2. add 11 elements in it
        for (int i = 0; i < 11; i ++) {
            list.add(i);
        }

        // 3. Then:
        // can find 11th data
        assertThat(list.get(10)).isEqualTo(10);

        // size have to be 11
        assertThat(list.size()).isEqualTo(11);
    }
}
