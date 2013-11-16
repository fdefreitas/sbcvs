package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fernando
 */
public class ComunidadUniversitaria {
    private static ComunidadUniversitaria instance;
    ArrayList<Person> profesores, estudiantes, egresados, empleados;
    ArrayList<Person> representacionEgresados, representacionEstudiantil, gobierno;
    
    protected ComunidadUniversitaria() {
      // Exists only to defeat instantiation.
   }
   public static ComunidadUniversitaria getInstance() {
      if(instance == null) {
         instance = new ComunidadUniversitaria();
      }
      return instance;
   }
   
    public void loadCU(){
        ArrayList<Person> persons = new ArrayList<>();
        BufferedReader br = null;
        try {
            String sCurrentLine, personType;
            br = new BufferedReader(new FileReader("comunity.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                Person p = new Person(sCurrentLine);
                personType = p.getType();
                if(personType.equalsIgnoreCase(Person.PROFESOR)){
                    profesores.add(p.clone());
                }else if(personType.equalsIgnoreCase(Person.ESTUDIANTE)){
                    estudiantes.add(p.clone());
                }else if(personType.equalsIgnoreCase(Person.EGRESADO)){
                    egresados.add(p.clone());
                }else if(personType.equalsIgnoreCase(Person.EMPLEADO)){
                    empleados.add(p.clone());
                }
            }

            System.out.println(persons.size()+" personas cargadas.");
            for(Person p : persons){
                System.out.println(p.toString());
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ComunidadUniversitaria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null)br.close();
            } catch (Exception ex) {
                Logger.getLogger(ComunidadUniversitaria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
