package api;

import controller.CoursesDataHandler;
import model.Courses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by djones on 1/31/17.
 */
@Path("/courses")
public class CourseService {

    CoursesDataHandler coursesDataHandler = new CoursesDataHandler();

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getCourseById(@PathParam("id") int id) throws SQLException {

        return Response.status(200).entity(coursesDataHandler.getCourse(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllCourses() throws SQLException {

        return Response.status(200).entity(coursesDataHandler.getAllCourses()).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createCourse(Courses courses) throws SQLException {

        int result = coursesDataHandler.insertCourse(courses);

        if (result == 1) {
            return Response.status(201).entity(result).build();
        } else {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("/update/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateCourse(Courses course, @PathParam("id") int id) throws SQLException {

        int result = coursesDataHandler.updateCourse(course, id);

        if (result == 1) {
            return Response.status(200).entity(result).build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteCourseById(@PathParam("id") int id) throws SQLException {

        int result = coursesDataHandler.deleteCourse(id);

        if (result == 1) {
            return Response.status(200).entity(result).build();
        } else {
            return Response.status(404).build();
        }
    }
}
