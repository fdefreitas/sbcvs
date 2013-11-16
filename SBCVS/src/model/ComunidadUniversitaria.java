package model;


import java.util.ArrayList;


/**
 *
 * @author fernando
 */
public class ComunidadUniversitaria {
    private static ComunidadUniversitaria instance;
    ArrayList profesores;
    
    protected ComunidadUniversitaria() {
      // Exists only to defeat instantiation.
   }
   public static ComunidadUniversitaria getInstance() {
      if(instance == null) {
         instance = new ComunidadUniversitaria();
      }
      return instance;
   }
    
}
