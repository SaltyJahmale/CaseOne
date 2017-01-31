package api;

import controller.StudentsDataHandler;
import model.Students;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by djones on 1/31/17.
 */
@Path("/students")
public class StudentService {

    private StudentsDataHandler studentsDataHandler = new StudentsDataHandler();

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStudentById(@PathParam("id") int id) throws SQLException {

        return Response.status(200).entity(studentsDataHandler.getStudent(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllStudents() throws SQLException {

        return Response.status(200).entity(studentsDataHandler.getAllStudents()).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createStudent(Students student) throws SQLException {

        int result = studentsDataHandler.insertStudent(student);

        if(result == 1) {
            return Response.status(201).entity(result).build();
        } else {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("/update/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateStudent(Students student, @PathParam("id") int id) throws SQLException {

        int result = studentsDataHandler.updateStudent(student, id);

        if(result == 1) {
            return Response.status(200).entity(result).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteStudentById(@PathParam("id") int id) throws SQLException {

        int result = studentsDataHandler.deleteStudent(id);

        if(result == 1) {
            return Response.status(200).entity(result).build();
        } else {
            return Response.status(404).build();
        }
    }

}
