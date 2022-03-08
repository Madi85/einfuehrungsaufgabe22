// =============================================================================
//
//   ListCourses.java
//
//   (c) 2021, Christian Bachmaier <bachmaier@fim.uni-passau.de>
//
// =============================================================================

package de.uni_passau.fim.einfuehrungsaufgabe22;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

/**
 * Backing bean for listCourses.xhtml .
 */
@Named("listCourses")
@RequestScoped
public class ListCourses {
    
    @Inject
    @Named("courseStore")
    private CourseStore courseStore;
    
    public List<Course> getCourses() {
        return courseStore.getCourses();
    }

}

// -----------------------------------------------------------------------------
// end of file
// -----------------------------------------------------------------------------
