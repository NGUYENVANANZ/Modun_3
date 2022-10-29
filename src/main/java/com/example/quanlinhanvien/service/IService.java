package com.example.quanlinhanvien.service;

import java.util.List;

public interface IService<E> {
    List<E> showAll();

    E findById(int id);

    void deleteById(int id);

    void editById(int id, E e);

    void create(E e);


}
