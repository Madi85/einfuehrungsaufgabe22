// =============================================================================
//
//   CourseIdValidator.java
//
//   (c) 2021, Christian Bachmaier <bachmaier@fim.uni-passau.de>
//
// =============================================================================

package de.uni_passau.fim.einfuehrungsaufgabe22;

import jakarta.enterprise.context.Dependent;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@Dependent
@FacesValidator(value = "courseIdValidator", managed = true)
public class CourseIdValidator implements Validator<Integer> {
    
    @Inject
    private CourseStore courseStore;

    @Override
    public void validate(FacesContext fctx, UIComponent component, Integer id)
            throws ValidatorException {
        if (courseStore.containsCourseWithId(id)) {
           FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
               "Duplicate ID.", "ID already in use, please choose another one.");
           throw new ValidatorException(msg);
        }
    }

}

// -----------------------------------------------------------------------------
// end of file
// -----------------------------------------------------------------------------
