package AppNote.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {

    private Integer idUser;
    private String username;
    private String password;
}
