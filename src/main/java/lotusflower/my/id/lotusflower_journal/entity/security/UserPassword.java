package lotusflower.my.id.lotusflower_journal.entity.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lotusflower.my.id.lotusflower_journal.entity.BaseEntity;


@Entity
@Table(name = "c_security_user_password")
@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class UserPassword extends BaseEntity {

    private static final long serialVersionUID = -7064711860149422914L;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user", nullable = false, columnDefinition = "varchar(36)")
    private User user;

    @Column(nullable = false, name = "user_password")
    private String password;
}
