package com.aor.refactoring.example4;

import java.util.HashSet;
import java.util.Set;

public class Supervisor extends Worker {
    Set<Worker> supervisor;
    
    public Supervisor(String name, String phone, String username, String password) {
        super(name, phone, username, password);
        supervisor = new HashSet<>();
    }
    
    public void addSupervisor(Worker worker) {
        supervisor.add(worker);
    }

    public boolean isSupervisor(Worker worker) {
        return supervisor.contains(worker);
    }
}
