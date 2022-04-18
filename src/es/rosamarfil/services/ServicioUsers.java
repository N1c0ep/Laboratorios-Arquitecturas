package es.rosamarfil.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.rosamarfil.modelo.Person;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Path("/users")
public class ServicioUsers {

    private static Map <Integer, Person> persons = new HashMap<Integer,Person>();
    
    static{
        for(int i=0;i<10; i++){
            Person person =new Person();
            int id=i+1;
            person.setId(id);
            person.setFullName("Persona"+id);
            person.setAge(new Random().nextInt(40)+1);
            person.setSueldo(1000000*person.getAge()/3);
            persons.put(id, person);
        }
        
    }
@GET
@Path("/getPersonByIdXML/ {id}")
@Produces(MediaType.APPLICATION_XML)
public Person getPersonByIdXML(int id){
    return persons.get(id);
}
@GET
@Path("/getPersonByIdJson/ {id}")
@Produces(MediaType.APPLICATION_JSON)
public Person getPersonByIdJson(int id){
    return persons.get(id);
}  
@GET
@Path("/getAllPersonsInXML")
@Produces(MediaType.APPLICATION_XML)
public List<Person> getAllPersonsInXML(){
    return new ArrayList<Person>(persons.values());
}
@GET
@Path("/getAllPersonsInJson")
@Produces(MediaType.APPLICATION_JSON)
public List<Person> getAllPersonsInJson(){
    return new ArrayList<Person>(persons.values());
}
@GET
@Path("/getSalarioSuma")
@Produces(MediaType.APPLICATION_JSON)
public int getSalarioSuma(){
    int sumaSalarios=0;
    
    for(int i=0;i<10; i++){
        sumaSalarios=persons.get(i).getSueldo()+sumaSalarios;
        }
    return sumaSalarios;
}
@GET
@Path("/getSalarioPromedio")
@Produces(MediaType.APPLICATION_XML)
public int getSalarioPromedio(){
    int sumaSalarios=getSalarioSuma();
    return sumaSalarios/10;
}
@POST
@Path("/addPersonInJson")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Person addPersonInJson (Person person){
    System.out.println(person.getId());
    persons.put(person.getId(), person);
    return person;
}


	
    
    

}