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
    public ArrayList<Person> profesores, estudiantes, egresados, empleados, registro, postulados, comunidad;
    public ArrayList<String> nucleos, elecciones, eleccionesNucleo;
    
    protected ComunidadUniversitaria() {
        comunidad = new ArrayList<>();
        profesores = new ArrayList<>();
        estudiantes = new ArrayList<>();
        egresados = new ArrayList<>();
        empleados = new ArrayList<>();
        registro = new ArrayList<>();
        postulados = new ArrayList<>();
        nucleos = new ArrayList<>();
        elecciones = new ArrayList<>();
        elecciones.add("Rector");
        elecciones.add("Vicerrector"); 
        elecciones.add("Secretario");
        eleccionesNucleo = new ArrayList<>();
   }
   public static ComunidadUniversitaria getInstance() {
      if(instance == null) {
         instance = new ComunidadUniversitaria();
      }
      return instance;
   }
   
   public void clearInstance(){
       profesores.clear();
       estudiantes.clear();
       egresados.clear();
       empleados.clear();
       registro.clear();
       postulados.clear();
       comunidad.clear();
       nucleos.clear();
       elecciones.clear();
       eleccionesNucleo.clear();
       instance = null;
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
                    profesores.add(p);
                }else if(personType.equalsIgnoreCase(Person.ESTUDIANTE)){
                    estudiantes.add(p);
                }else if(personType.equalsIgnoreCase(Person.EGRESADO)){
                    egresados.add(p);
                }else if(personType.equalsIgnoreCase(Person.EMPLEADO)){
                    empleados.add(p);
                }
                comunidad.add(p);
            }

            System.out.println(profesores.size()+" profesores cargados.");
            System.out.println(estudiantes.size()+" estudiantes cargados.");
            System.out.println(egresados.size()+" egresados cargados.");
            System.out.println(empleados.size()+" empleados cargados.");
            
            /*Cargar Elecciones por Nucleo*/
            br = new BufferedReader(new FileReader("elecciones_nucleo.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                eleccionesNucleo.add(sCurrentLine);
            }
            /* Cargar Nucleos */
            br = new BufferedReader(new FileReader("nucleos.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                nucleos.add(sCurrentLine);
                for(int j = 0 ; j< eleccionesNucleo.size(); j++){
                    elecciones.add(eleccionesNucleo.get(j)+" de "+sCurrentLine);
                }
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
