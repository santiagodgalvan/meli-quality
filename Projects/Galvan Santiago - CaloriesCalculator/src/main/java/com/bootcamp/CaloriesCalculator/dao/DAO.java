package com.bootcamp.CaloriesCalculator.dao;

public interface DAO<T> {
    T getByName(String name);
}
