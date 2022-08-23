package AppNote.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryResponse {

    private Integer idCategory;
    private UserResponse user;
    private String description;
    private List<NoteResponse> notes;
}
