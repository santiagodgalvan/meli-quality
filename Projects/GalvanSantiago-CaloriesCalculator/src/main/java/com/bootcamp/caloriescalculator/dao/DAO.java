package com.bootcamp.caloriescalculator.dao;

public interface DAO<T> {
    T getByName(String name);
}
