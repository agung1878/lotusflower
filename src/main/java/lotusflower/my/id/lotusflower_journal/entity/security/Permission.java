package lotusflower.my.id.lotusflower_journal.entity.security;

import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lotusflower.my.id.lotusflower_journal.entity.BaseEntity;

@Entity
@Table(name = "c_security_permission")
@Data @EqualsAndHashCode(callSuper=false)
public class Permission extends BaseEntity {

    @Size(max = 100)
    @NotEmpty(message = "label tidak boleh kosong")
    @Column(name = "permission_label", nullable = false, length = 100)
    private String permissionLabel;

    @Size(max = 100)
    @NotEmpty(message = "value tidak boleh kosong")
    @Column(name = "permission_value", nullable = false, length = 100)
    private String permissionValue;

    public String getPermissionType() {
        if(StringUtils.isNotBlank(this.getId()) && this.getId().substring(0, 2).equals("M1")) {
            return "MANAGEMENT";
        } else {
            return "MERCHANT";
        }
    }
}
