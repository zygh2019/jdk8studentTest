package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liushengbin
 * @date 2022/2/21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  String name;
    private  Integer role;
}
