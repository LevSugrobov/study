package studypro;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class HobbyEntity {
    @Id
    @Column(name = "hobby_id", nullable = false, insertable = true, length = 20)
    private int hobbyId;
    @Column
    private String description;
    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "hobby_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Set<ContactEntity> contacts = new HashSet<ContactEntity>();

    public int getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(int hobbyId) {
        this.hobbyId = hobbyId;
    }

    public Set<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HobbyEntity that = (HobbyEntity) o;

        if (hobbyId != that.hobbyId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return contacts != null ? contacts.equals(that.contacts) : that.contacts == null;
    }

    @Override
    public int hashCode() {
        int result = hobbyId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HobbyEntity{" +
                "hobbyId=" + hobbyId +
                ", description='" + description + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}