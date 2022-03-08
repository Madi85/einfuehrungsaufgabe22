// =============================================================================
//
//   NewCourse.java
//
//   (c) 2021, Christian Bachmaier <bachmaier@fim.uni-passau.de>
//
// =============================================================================

package de.uni_passau.fim.einfuehrungsaufgabe22;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Backing bean for newCourse.xhtml .
 */
@Named
@RequestScoped
public class NewCourse {
    
    @Inject
    FacesContext fctx;
    
    @Inject
    private CourseStore courseStore;

    
    private Course course = new Course(1234,"Title");

    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public String createCourse() {
        boolean success = courseStore.add(course);
        if (success) {
            return "listCourses";
        } else {
            FacesMessage fmsg = new FacesMessage(
                "ID already in use, please choose another one.");
            fmsg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fctx.addMessage("createCourse:id", fmsg);
            return null;
        }
    }

}

// -----------------------------------------------------------------------------
// end of file
// -----------------------------------------------------------------------------
