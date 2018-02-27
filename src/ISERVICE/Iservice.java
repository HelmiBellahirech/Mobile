package ISERVICE;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nadaghanem
 
 */
public interface Iservice<T,R>
{
    boolean add(T t);
    boolean update(T t);
    boolean remove(R r);
    T findId(R r);
    List<T> getAll() ; 
}
