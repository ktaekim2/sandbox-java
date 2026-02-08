package io.github.ktaekim2.sandbox;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    @Test
    public void add_should_increase_size() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        assertThat(myArrayList.get(0)).isEqualTo(1);
        assertThat(myArrayList.size()).isEqualTo(1);
    }

    @Test
    public void should_resize_when_capacity_full() {
        // Given
        MyArrayList myArrayList = new MyArrayList();
        for(int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }

        // When
        myArrayList.add(10);

        // Then
        assertThat(myArrayList.size()).isEqualTo(11);
    }

    @Test
    public void should_throw_exception_when_index_is_invalid() {
        // given
        MyArrayList list = new MyArrayList();

        // when & then
        assertThatThrownBy(() -> {
            list.get(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
