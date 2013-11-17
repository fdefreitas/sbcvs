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
    public ArrayList<Person> profesores, estudiantes, egresados, empleados, registro, postulados;
    
    protected ComunidadUniversitaria() {
        profesores = new ArrayList<>();
        estudiantes = new ArrayList<>();
        egresados = new ArrayList<>();
        empleados = new ArrayList<>();
        registro = new ArrayList<>();
        postulados = new ArrayList<>();
   }
   public static ComunidadUniversitaria getInstance() {
      if(instance == null) {
         instance = new ComunidadUniversitaria();
      }
      return instance;
   }
   
   
   public Person getPerson(String id, String type){
        Object obj = new Person(null, id, type, null, null, null);
        if(type.equalsIgnoreCase(Person.PROFESOR)){
            int x = profesores.lastIndexOf(obj);
            return profesores.get(x);
        }else if(type.equalsIgnoreCase(Person.ESTUDIANTE)){
            int x = estudiantes.lastIndexOf(obj);
            return estudiantes.get(x);
        }else if(type.equalsIgnoreCase(Person.EGRESADO)){
            int x = egresados.lastIndexOf(obj);
            return egresados.get(x);
        }else if(type.equalsIgnoreCase(Person.EMPLEADO)){
            int x = empleados.lastIndexOf(obj);
            return empleados.get(x);
        }
        return null;
   }
   
    public void loadCU(){
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

            System.out.println(profesores.size()+" profesores cargadas.");
            System.out.println(estudiantes.size()+" estudiantes cargadas.");
            System.out.println(egresados.size()+" egresados cargadas.");
            System.out.println(empleados.size()+" empleados cargadas.");
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
