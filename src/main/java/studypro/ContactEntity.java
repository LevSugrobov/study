package studypro;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")

@NamedQueries({
        @NamedQuery(name = "ContactEntity.findAll", query = "select c from ContactEntity c"),
        @NamedQuery(name = "ContactEntity.findById",
                query = "select distinct c from ContactEntity c left join fetch c.contactTelDetails t left join fetch c.hobbies h where c.id = :id"),
        @NamedQuery(name="ContactEntity.findAllWithDetail",
                query="select distinct c from ContactEntity c left join fetch c.contactTelDetails t left join fetch c.hobbies h")
})
public class ContactEntity {
    @Id
    @Column(name = "id", nullable = false,insertable =true, updatable = true)
    private int id;
    @Column(name = "first_name", nullable = false, insertable = true, updatable = true,length = 60)
    private String firstName;
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 40)
    private String lastName;
    @Column(name = "birth_date", nullable = true,insertable = true, updatable = true)
    private Date birthDate;
    @Column(name = "version", nullable = false,insertable = true,updatable = true)
    private int version;
    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private Set<HobbyEntity> hobbies = new HashSet<HobbyEntity>();
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContactTelDetailEntity> contactTelDetails = new HashSet<ContactTelDetailEntity>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<ContactTelDetailEntity> getContactTelDetails() {
        return contactTelDetails;
    }

    public void setContactTelDetails(Set<ContactTelDetailEntity> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    public Set<HobbyEntity> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyEntity> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (hobbies != null ? !hobbies.equals(that.hobbies) : that.hobbies != null) return false;
        return contactTelDetails != null ? contactTelDetails.equals(that.contactTelDetails) : that.contactTelDetails == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", " + firstName + '\'' +
                ", " + lastName + '\'' +
                ", " + birthDate +
                ", " + version +
                '}';
    }
}
