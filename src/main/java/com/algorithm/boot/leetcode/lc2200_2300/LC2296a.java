package com.algorithm.boot.leetcode.lc2200_2300;

public class LC2296a {}
class TextEditor {
    StringBuilder builder;

    int index;

    int capacity;

    public TextEditor() {
        builder = new StringBuilder();
        index = 0;
        capacity = 0;
    }

    public void addText(String text) {
        int textLen = text.length();
        if (builder.isEmpty()) {
            index += textLen;
            capacity = 2 * textLen;
            builder = new StringBuilder(text);
            return;
        }
        String endStr = builder.substring(index);
        builder.delete(index, builder.length())
                .append(text)
                .append(endStr);
        index += textLen;
    }

    public int deleteText(int k) {
        if (k > index) {
            k = index;
        }
        builder.delete(index - k, index);
        index = index - k;
        return k;
    }

    public String cursorLeft(int k) {
        if (k > index) {
            k = index;
        }
        index -= k;
        int start = Math.max(index - 10, 0);
        return builder.substring(start, index);
    }

    public String cursorRight(int k) {
        if (k > builder.length() - index) {
            k = builder.length() - index;
        }
        index += k;
        int start = Math.max(index - 10, 0);
        return builder.substring(start, index);
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
