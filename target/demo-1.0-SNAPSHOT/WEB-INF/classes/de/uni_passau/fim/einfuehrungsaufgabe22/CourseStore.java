// =============================================================================
//
//   CourseStore.java
//
//   (c) 2021, Christian Bachmaier <bachmaier@fim.uni-passau.de>
//
// =============================================================================

package de.uni_passau.fim.einfuehrungsaufgabe22;

import de.uni_passau.fim.einfuehrungsaufgabe22.annotation.Eager;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serial;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Named
@ApplicationScoped
@Eager
public class CourseStore {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    private final Set<Course> courses = new TreeSet<>();
    
    @PostConstruct
    private void init() {
        add(new Course(500, "Business English"));
    }

    public synchronized List<Course> getCourses() {
        return new LinkedList<>(courses);
    }
    
    public synchronized boolean add(Course course) {
        return courses.add(course);
    }
    
    public synchronized boolean containsCourseWithId(int id) {
        return courses.contains(new Course(id, null));
    }

}

// -----------------------------------------------------------------------------
// end of file
// -----------------------------------------------------------------------------
