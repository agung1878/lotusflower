package lotusflower.my.id.lotusflower_journal.entity.security;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lotusflower.my.id.lotusflower_journal.entity.BaseEntity;

@Entity
@Table(name = "c_security_user")
@Data @EqualsAndHashCode(callSuper=false)
public class User extends BaseEntity {

    @Size(max = 100)
    @NotEmpty(message = "Username tidak boleh dikosongkan")
    @Column(nullable = false, unique = true)
    private String username;

    private Boolean active = Boolean.FALSE;

    @JsonIgnore
    @OneToOne(mappedBy = "user", optional = true, orphanRemoval = true)
    @Cascade({CascadeType.ALL})
    private UserPassword userPassword;

    @Transient @JsonIgnore
    private String password;
}
