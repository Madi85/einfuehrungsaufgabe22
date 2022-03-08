package de.uni_passau.fim.einfuehrungsaufgabe22.backing;

import de.uni_passau.fim.einfuehrungsaufgabe22.model.Employee;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BackingEmployee implements Serializable {

    public List<Employee> findeAllEmployees() {
        return null;
    }
}