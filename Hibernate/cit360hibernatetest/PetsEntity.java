package cit360hibernatetest;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pets", schema = "pets", catalog = "")
public class PetsEntity {
    private int id;
    private String name;
    private String species;
    private String owner;

    public PetsEntity(){}
    public PetsEntity(String p_name,String p_species,String p_owner) {
        name = p_name;
        species = p_species;
        owner = p_owner;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "species", nullable = true, length = 45)
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Basic
    @Column(name = "owner", nullable = true, length = 45)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetsEntity that = (PetsEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(species, that.species) &&
                Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, species, owner);
    }
}
