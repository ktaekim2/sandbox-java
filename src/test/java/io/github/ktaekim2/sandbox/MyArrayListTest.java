package io.github.ktaekim2.sandbox;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

public class MyArrayListTest {

    @Test
    public void add_should_increase_size() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);

        assertThat(myArrayList.size()).isEqualTo(1);
        assertThat(myArrayList.get(0)).isEqualTo(1);
    }

    @Test
    public void should_resize_when_capacity_full() {
        // Given
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 10; i++) {
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

    @Test
    public void remove_should_remove_index_and_return_value() {
        // given
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }

        // when
        int result = myArrayList.remove(5);

        // then
        assertThat(result).isEqualTo(5);
        assertThat(myArrayList.size()).isEqualTo(9);
        assertThat(myArrayList.get(5)).isEqualTo(6);
    }

    @Test
    public void remove_should_remove_first_element() {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i); // [0, 1, 2, 3, 4]
        }

        int removed = list.remove(0);

        assertThat(removed).isEqualTo(0);
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo(1);
    }

    @Test
    public void remove_should_remove_last_element() {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i); // [0, 1, 2, 3, 4]
        }

        int removed = list.remove(list.size() - 1);

        assertThat(removed).isEqualTo(4);
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(list.size() - 1)).isEqualTo(3);
    }

    @Test
    public void remove_should_throw_exception_when_index_is_negative() {
        MyArrayList list = new MyArrayList();
        list.add(10);

        assertThatThrownBy(() -> {
            list.remove(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void set_should_change_the_value() {
        // given
        MyArrayList list = initMyArray();

        // when & then
        assertThat(list.set(3, 99)).isEqualTo(3);
        assertThat(list.get(3)).isEqualTo(99);
        assertThat(list.size()).isEqualTo(5);
    }

    @Test
    public void add_should_push_index_back() {
        // given
        MyArrayList list = initMyArray();

        // when
        list.add(2, 99);

        // then
        assertThat(list.size()).isEqualTo(6);
        assertThat(list.get(2)).isEqualTo(99);
        assertThat(list.get(3)).isEqualTo(2);
    }

    private MyArrayList initMyArray() {
        MyArrayList list = new MyArrayList();
        for (int i = 0; i < 5; i++) {
            list.add(i); // [0, 1, 2, 3, 4]
        }
        return list;
    }
}
