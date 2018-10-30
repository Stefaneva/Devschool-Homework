package composition;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Furniture {
    private String name;
    private Double height;
    private Double width;
    private Double length;
    private FurnitureDurability durability;
}
