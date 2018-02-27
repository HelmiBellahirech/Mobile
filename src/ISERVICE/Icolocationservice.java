/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISERVICE;

import MODEL.Colocation;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface Icolocationservice extends Iservice<Colocation,Integer> {
     public List<Colocation> findByAdresse(String Adresse); 
      public List<Colocation> findId_user(Integer r) ;
    
}
