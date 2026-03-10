package io.github.ktaekim2.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    @Test
    public void add_should_increase_size() {
        MyLinkedList list = new MyLinkedList();
        list.add(5);

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo(5);
    }

    private MyLinkedList initLinkedList() {
        MyLinkedList list = new MyLinkedList();

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        return list;
    }

    @Test
    public void remove_should_decrease_sise() {
        // given
        MyLinkedList list = initLinkedList();

        // when
        list.remove(1);

        // then
        assertThat(list.size()).isEqualTo(4);
    }
}
