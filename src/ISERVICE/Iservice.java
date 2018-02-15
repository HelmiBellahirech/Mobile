/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISERVICE;

import java.util.List;

/**
 *
 * @author OrbitG
 */
public interface Iservice<T,R>  {
    void add(T t ) ; 
    void update(T t ) ; 
    void remove(R r) ; 
    T findId(R r) ; 
    List<T> getAll() ; 
}
