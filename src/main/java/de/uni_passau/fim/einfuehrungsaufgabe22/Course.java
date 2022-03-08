// =============================================================================
//
//   Course.java
//
//   (c) 2021, Christian Bachmaier <bachmaier@fim.uni-passau.de>
//
// =============================================================================

package de.uni_passau.fim.einfuehrungsaufgabe22;

public class Course implements Comparable<Course> {
    
    private int id;
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private String title;
    
    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public int compareTo(Course other) {
        return Integer.compare(id, other.id);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Course course) {
            return id == course.id;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return id;
    }
    
}

// -----------------------------------------------------------------------------
// end of file
// -----------------------------------------------------------------------------
