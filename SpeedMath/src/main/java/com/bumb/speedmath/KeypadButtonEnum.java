package com.bumb.speedmath;

import com.bumb.speedmath.KeypadButtonCategory;

/**
 * Created by manisharora on 8/10/13.
 */

public enum KeypadButtonEnum {
    ONE("1",KeypadButtonCategory.NUMBER)
    , TWO("2",KeypadButtonCategory.NUMBER)
    , THREE("3",KeypadButtonCategory.NUMBER)
    , FOUR("4",KeypadButtonCategory.NUMBER)
    , FIVE("5",KeypadButtonCategory.NUMBER)
    , SIX("6",KeypadButtonCategory.NUMBER)
    , SEVEN("7",KeypadButtonCategory.NUMBER)
    , EIGHT("8",KeypadButtonCategory.NUMBER)
    , NINE("9",KeypadButtonCategory.NUMBER)
    , DECIMAL(".",KeypadButtonCategory.DECIMAL)
    , ZERO("0",KeypadButtonCategory.NUMBER)
    , DELETE("<=",KeypadButtonCategory.DELETE)
    , CLEAR("Clear", KeypadButtonCategory.CLEAR)
    , GO("Go", KeypadButtonCategory.OTHER)
    , DUMMY("Dummy", KeypadButtonCategory.OTHER);

    CharSequence text; // Display Text
    KeypadButtonCategory category;

    KeypadButtonEnum(CharSequence text,KeypadButtonCategory category) {
        this.text = text;
        this.category = category;
    }

    public CharSequence getText() {
        return text;
    }
}