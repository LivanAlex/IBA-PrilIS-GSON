package com.core;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomExclusionStrategy implements ExclusionStrategy {

    private final Class<?> typeToSkip;

    public CustomExclusionStrategy(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {

        // if field name 'salary`, skip
        if ("salary".equals(fieldAttributes.getName())) {
            return true;
        }

        // if found @ExcludeField, skip
        if (fieldAttributes.getAnnotation(ExcludeField.class) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return (aClass == typeToSkip);
    }
}
