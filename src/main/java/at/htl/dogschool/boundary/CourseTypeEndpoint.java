package at.htl.dogschool.boundary;

import at.htl.dogschool.control.CourseTypeRepository;
import at.htl.dogschool.entity.CourseType;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("course_type")
@Produces(MediaType.APPLICATION_JSON)
public class CourseTypeEndpoint {

    @Inject
    CourseTypeRepository courseTypeRepository;

    @GET
    public List<CourseType> readAll() {
        return courseTypeRepository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CourseType courseType, @Context UriInfo info) {
        CourseType newCourseType = courseTypeRepository.save(courseType);
        URI uri = info.getAbsolutePathBuilder().path("/" + newCourseType.getId()).build();
        return Response.created(uri).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, CourseType courseType) {
        CourseType ct = courseTypeRepository.findById(id);
        if (ct == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "courseType with id " + id + " does not exist")
                    .build();
        } else {
            ct.setAbbr(courseType.getAbbr());
            ct.setName(courseType.getName());
            courseTypeRepository.save(ct);
            return Response.ok(ct).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        try {
            courseTypeRepository.delete(id);
        } catch (EntityNotFoundException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .header("Reason", "courseType with id " + id + " does not exist")
                    .build();
        }
        return Response.noContent().build();
    }


}
