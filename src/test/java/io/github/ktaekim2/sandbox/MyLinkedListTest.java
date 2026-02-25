package io.github.ktaekim2.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MyLinkedListTest {

    @Test
    public void add_should_work_TT() {
        // given
        MyLinkedList list = new MyLinkedList();

        // when
        list.add(1);
        list.add(2);

        // then
        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(2);
    }

    @Test
    void should_insert_at_index() {
        // Given
        MyLinkedList list = new MyLinkedList();

        // When
        list.add(10);
        list.add(30);
        list.add(1, 20);

        // Then
        assertThat(list.get(1)).isEqualTo(20);
        assertThat(list.get(2)).isEqualTo(30);
    }

    @Test
    void should_remove_at_index() {
        // Given
        MyLinkedList list = new MyLinkedList();

        // When
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);

        // Then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(1)).isEqualTo(30);
    }
}
