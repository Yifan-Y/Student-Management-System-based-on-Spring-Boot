package com.yifan.yang.StudentMngt.entity.model;

import com.yifan.yang.StudentMngt.entity.model.BaseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseEntityTest {

    private BaseEntity baseEntity;

    @BeforeEach
    void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    @DisplayName("Id is set correctly")
    void idIsSetCorrectly() {
        baseEntity.setId(1);
        assertEquals(1, baseEntity.getId());
    }

    @Test
    @DisplayName("Id is set correctly after construction")
    void idIsSetCorrectlyAfterConstruction() {
        BaseEntity baseEntityWithId = new BaseEntity(2);
        assertEquals(2, baseEntityWithId.getId());
    }

    @Test
    @DisplayName("Id is set correctly after being changed")
    void idIsSetCorrectlyAfterBeingChanged() {
        baseEntity.setId(3);
        baseEntity.setId(4);
        assertEquals(4, baseEntity.getId());
    }
}