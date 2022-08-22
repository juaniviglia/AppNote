package entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    private String description;
    @ManyToMany(mappedBy = "categories")
    private List<Note> Notes;

}
