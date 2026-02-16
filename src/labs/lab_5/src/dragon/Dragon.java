package dragon;

import core.Coordinates;
import core.BadDataException;

public class Dragon {

    public Dragon(
            String name,
            Coordinates coordinates,
            int age,
            long weight,
            DragonType type,
            DragonHead head) {
        id = java.util.UUID.randomUUID().getLeastSignificantBits();
        this.name = name;
        this.coordinates = coordinates;
        creationDate = java.time.LocalDateTime.now();
        this.age = age;
        this.weight = weight;
        this.type = type;
        this.head = head;
    }

    public Dragon(String name, Coordinates coordinates, int age, long weight) throws BadDataException, NullPointerException {
        this(name, coordinates, age, weight, null, null);
    }



    /**
     * Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть
     * уникальным, Значение этого поля должно генерироваться автоматически
     */
    final private Long id;

    final private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    final private java.time.LocalDateTime
            creationDate; // Поле не может быть null, Значение этого поля должно генерироваться
    // автоматически
    private int age; // Значение поля должно быть больше 0
    private long weight; // Значение поля должно быть больше 0
    private boolean speaking;
    final private DragonType type; // Поле может быть null
    final private DragonHead head;
}
