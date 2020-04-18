package icu.mianshi.openjdk.ref;

import java.util.List;
import java.util.ArrayList;
public class Nest {
    public static class Location {
        public float x;
        public float y;
    }

    public Location location;
    private List<ILife> residents = new ArrayList<>();

    public void live(ILife life) {
        residents.add(life);
    }

    public boolean leave(ILife life) {
        return residents.remove(life);
    }
}