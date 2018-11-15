package com.csye6225.fall2018.courseservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice.datamodel.Announcement;
import com.csye6225.fall2018.courseservice.datamodel.Course;
import com.csye6225.fall2018.courseservice.datamodel.Professor;
import com.csye6225.fall2018.courseservice.service.AnnouncementsService;
import com.csye6225.fall2018.courseservice.service.CoursesService;

	@Path("announcements")
	public class AnnouncementResource {
		AnnouncementsService annoService = new AnnouncementsService();
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Announcement> getAnnouncementByDeparment(@QueryParam("boardId")String boardId) {
			if(boardId == null) {
				return annoService.getAllAnnouncements();
			}
			return annoService.getAnnouncementsByBoardId(boardId);
		}
		
		@GET
		@Path("/{boardId}_{announcementId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Announcement getAnnouncement(@PathParam("boardId") String boardId,
											@PathParam("announcementId") String announcementId) {
			return annoService.getAnnouncement(boardId,announcementId);
		}
		
		@DELETE
		@Path("/{boardId}_{announcementId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Announcement deleteAnnouncement(@PathParam("boardId") String boardId,
				@PathParam("announcementId") String announcementId) {
			return annoService.deleteAnnouncement(boardId,announcementId);
		}
		
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Announcement addAnnouncement(Announcement anno) {
				return annoService.addAnnouncement(anno);
		}
		
		@PUT
		@Path("/{boardId}_{announcementId}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Announcement updateAnnouncement(@PathParam("announcementId") String announcementId, 
				@PathParam("boardId") String boardId,
				Announcement anno) {
			return annoService.updateAnnouncementInformation(boardId, announcementId,anno);
		}
		

	}


