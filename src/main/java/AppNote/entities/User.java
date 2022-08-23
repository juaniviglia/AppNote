package AppNote.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String username;
    private String password;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = CascadeType.MERGE)
    private List<Note> Notes;
}
