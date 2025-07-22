package api.data;

import api.model.Pet;

import java.util.stream.Stream;

public class PetProvider {
    public static Stream<Pet> providePets() {
        return Stream.of(
                new Pet(1001, "Max", "available"),
                new Pet(1002, "Bella", "pending"),
                new Pet(1003, "Charlie", "sold")
        );
    }
}