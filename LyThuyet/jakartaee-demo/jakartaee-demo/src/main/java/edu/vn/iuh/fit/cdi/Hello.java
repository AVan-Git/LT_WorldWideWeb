package edu.vn.iuh.fit.cdi;

import jakarta.inject.Inject;
public class Hello {
    @Inject
    private World world;

    public String helloWorld() {
        return "Hello " + world.world() + "!";
    }
}
