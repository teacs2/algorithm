package com.algorithm.boot.leetcode.lc2200_2300;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cn.hutool.core.util.StrUtil;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorTest {

    TextEditor te;
    String addText1 = "leetcode";
    String addText2 = " Java ";
    @BeforeEach
    void setUp() {
        te = new TextEditor();
    }

    @Test
    void addText() {
        te.addText(addText1);
        assertTrue(StrUtil.equals(te.toString(), addText1));
        te.index = 1;
        te.addText(addText2);
        assertTrue(StrUtil.equals(te.toString(), "l Java eetcode"));
    }

    @Test
    void deleteText() {
        te.addText(addText1);
        assertTrue(StrUtil.equals(te.toString(), addText1));
        te.addText(addText2);
        assertTrue(StrUtil.equals(te.toString(), addText1 + addText2));
        te.index = 0;
        te.deleteText(1);
        assertTrue(StrUtil.equals(te.toString(), addText1 + addText2));
        te.index = addText1.length() + addText2.length();
        te.deleteText(1);
        assertTrue(StrUtil.equals(te.toString(), "leetcode Java"));
        te.deleteText(100);
        assertTrue(StrUtil.equals(te.toString(), ""));
    }

    @Test
    void cursorLeft() {
        te.addText(addText1);
        te.addText(addText2);
        assertTrue(StrUtil.equals(te.cursorLeft(addText2.length()), addText1));
    }

    @Test
    void cursorRight() {
        te.addText(addText1);
        te.addText(addText2);
        assertTrue(StrUtil.equals(te.cursorLeft(addText2.length()), addText1));
        assertTrue(StrUtil.equals(te.cursorRight(2), addText1 + " J"));
    }
}