package AppNote.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "Notes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Note {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idNote;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @Column(length =  2000)
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable( name = "notes_categories",
                joinColumns = @JoinColumn(name = "idNote"),
                inverseJoinColumns = @JoinColumn(name = "idCategory"))
    private List<Category> categories;
    private boolean condition; // --> 1 : Active & 0 : archived
    private LocalDateTime lastEdition;
    private String title;




}
