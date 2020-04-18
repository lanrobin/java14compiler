package icu.mianshi.openjdk.ref;

public interface ILife {
    default boolean isAlive() {
        return true;
    }

    float weight();
}