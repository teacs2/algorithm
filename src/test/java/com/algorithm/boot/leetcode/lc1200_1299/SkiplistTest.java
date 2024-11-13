package com.algorithm.boot.leetcode.lc1200_1299;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkiplistTest {

    static Skiplist skiplist;

    @BeforeAll
    static void m() {
        skiplist = new Skiplist();
        for (int i = 0; i < 50; i++) {
            skiplist.add(i * 2);
        }
    }

    @Test
    void search() {
        assertTrue(skiplist.search(0));
        assertTrue(skiplist.search(88));
        assertFalse(skiplist.search(49));
    }

    @Test
    void add() {
        skiplist.add(50);
        skiplist.add(49);
        assertTrue(skiplist.search(50));
        assertFalse(skiplist.search(9));
        skiplist.add(9);
        assertTrue(skiplist.search(9));
        assertTrue(skiplist.search(49));
    }

    @Test
    void erase() {
        assertTrue(skiplist.search(80));
        skiplist.erase(80);
        assertFalse(skiplist.search(80));
    }
}