package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Animal{

    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
    }

    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(location);
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            }
        }
        return null;
    }

    @Override
    public void act(List<Animal> humans) {

            Location newLocation = findFood();
            if (newLocation == null) {
                // No food found - try to move to a free location.
                newLocation = field.freeAdjacentLocation(location);
            }
            // See if it was possible to move.
            if (newLocation != null) {
                setLocation(newLocation);
            }

    }



    @Override
    public int getMaxAge() {
        return 60;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.002;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 25;
    }




}
