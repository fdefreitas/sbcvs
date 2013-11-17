package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Clase que contiene toda la información de la comunidad
 * @author fernando
 */
public class ComunidadUniversitaria {
    private static ComunidadUniversitaria instance;
    public ArrayList<Person> profesores, estudiantes, egresados, empleados, registro, postulados, comunidad;
    public ArrayList<String> nucleos, eleccionesNucleo;
    public ArrayList<Eleccion> elecciones;
    
    /**
     * Constructor de ComunidadUniversitaria
     */
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
        eleccionesNucleo = new ArrayList<>();
   }
    
   /**
    * Retorna la instancia del singleton de la clase <code>ComunidadUniversitaria</code>
    * @return singleton de ComunidadUniversitaria
    */
   public static ComunidadUniversitaria getInstance() {
      if(instance == null) {
         instance = new ComunidadUniversitaria();
      }
      return instance;
   }
   
   /**
    * Limpia todas las instancias
    */
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
   
   /**
    * Funcion que obtiene la persona con el id y tipo especificado. Retorna la Persona encontrada o <code>null</code>
    * @param id id de la persona
    * @param type tipo de la persona
    * @return persona especificada
    */
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
   
    /**
     * Procedimiento que carga los .txt con información de nucleos, elecciones y miembros de la comunidad universitaria
     */
    public void loadCU(){
        BufferedReader br = null;
        try {
            String sCurrentLine, personType;
            /* Cargar personas de la Comunidad Universitaria */
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
            
            /* Cargar Elecciones generales */
            Eleccion election;
            br = new BufferedReader(new FileReader("elecciones.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                election = new Eleccion(sCurrentLine, sCurrentLine, "General");
                elecciones.add(election);
            }
            
            /* Cargar Elecciones por Nucleo */
            br = new BufferedReader(new FileReader("elecciones_nucleo.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                eleccionesNucleo.add(sCurrentLine);
            }
            /* Cargar Nucleos */
            br = new BufferedReader(new FileReader("nucleos.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                nucleos.add(sCurrentLine);
                for(int j = 0 ; j< eleccionesNucleo.size(); j++){
                    /* Agregar Elecciones de Nucleo a ArrayList de Elecciones */
                    election = new Eleccion(eleccionesNucleo.get(j)+" de "+sCurrentLine, eleccionesNucleo.get(j), sCurrentLine);
                    elecciones.add(election);
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
