package composition;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomComponent {
    private String componentName;
    private Double height;
    private Double width;
    private String materialType;
}
