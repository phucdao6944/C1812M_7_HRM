/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;

/**
 *
 * @author Queen
 * @param <T>
 * @param <Tkey>
 */
public interface IDbHandler<T, Tkey> {
    void insert(T entity);
    void delete(Tkey id);
    List<T> getAll();
    T getById(Tkey id);
    void update(T entity);
}
