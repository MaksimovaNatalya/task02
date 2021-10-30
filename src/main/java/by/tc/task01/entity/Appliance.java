package by.tc.task01.entity;

import java.util.Objects;

public class
Appliance {

final String id;

    public Appliance(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return id.equals(appliance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id='" + id + '\'' +
                '}';
    }
}
