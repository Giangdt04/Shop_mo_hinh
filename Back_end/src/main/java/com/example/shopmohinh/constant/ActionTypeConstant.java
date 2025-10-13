package com.example.shopmohinh.constant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionTypeConstant {
    TYPE_VIEW(1, "PRODUCT"),

    TYPE_SEARCH(2, "SEARCH"),;

    private final int value;

    private final String label;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ActionTypeConstant parseByValue(Integer value) {
        if (value != null) {
            for (ActionTypeConstant type : values()) {
                if (type.value == value) {
                    return type;
                }
            }
        }
        return null;
    }

    @JsonValue
    public int getValue() {
        return value;
    }
}
