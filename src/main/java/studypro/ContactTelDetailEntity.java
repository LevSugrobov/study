package studypro;

import javax.persistence.*;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetailEntity {
    @Id
    @Column(nullable = false)
    private int id;
    @Column(name = "tel_type", nullable = false, length = 20)
    private String telType;
    @Column(name = "tel_number", nullable = false, length = 20)
    private String telNumber;
    @Column(name = "version", nullable = false)
    private int version;
    @ManyToOne
    @JoinColumn(name = "contact_by_id")
    private ContactEntity contactById;
    @OneToOne
    @JoinColumn(name = "contact", referencedColumnName = "id", nullable = false)
    private ContactEntity contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public ContactEntity getContactById() {
        return contactById;
    }

    public void setContactById(ContactEntity contactById) {
        this.contactById = contactById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetailEntity that = (ContactTelDetailEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (telType != null ? !telType.equals(that.telType) : that.telType != null) return false;
        if (telNumber != null ? !telNumber.equals(that.telNumber) : that.telNumber != null) return false;
        if (contactById != null ? !contactById.equals(that.contactById) : that.contactById != null) return false;
        return contact != null ? contact.equals(that.contact) : that.contact == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (telType != null ? telType.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        result = 31 * result + version;
        result = 31 * result + (contactById != null ? contactById.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactTelDetailEntity{" +
                "id=" + id +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", version=" + version +
                ", contactById=" + contactById +
                ", contact=" + contact +
                '}';
    }
}
