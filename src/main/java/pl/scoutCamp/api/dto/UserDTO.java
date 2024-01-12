package pl.scoutCamp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    Integer id;
    String firstName;
    String lastName;
    String username;
    String email;
    String password;
}
