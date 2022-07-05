package com.daryl.constant;

/**
 * @author wl
 * @date 2022-06-29
 */
public enum DataTypeEnum {
    INT32("int32"),
    INT64("int64"),
    FLOAT("float"),
    DOUBLE("double"),
    ENUM("enum"),
    BOOL("bool"),
    STRING("string"),
    STRUCT("struct"),
    BITMAP("bitMap"),
    DATE("date"),
    ARRAY("array"),
    ;

    private final String type;

    DataTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
