/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ISERVICE;
import MODEL.Reservationcov; 
import java.util.List;

/**
 *
 * @author OrbitG
 */
public interface IreservationcovService extends Iservice<Reservationcov,Integer>{
     public List<Reservationcov> findByReserve(Integer r );
     public List<Reservationcov> findByChauffeur(Integer r );
     public Reservationcov verifReservation(Reservationcov res) ;
     public List<Reservationcov> findByChauffeurb(Integer r,Boolean b);
}
