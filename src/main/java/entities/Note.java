package entities;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="notes")
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "NotesCategories",
            joinColumns = @JoinColumn(name = "idNote"),
            inverseJoinColumns = @JoinColumn(name ="idCategory") )
    List<Category> categories;

    boolean condition; // --> 1 : Active & 0 : archived
    private Date lastEdition;
    private String title;


}
