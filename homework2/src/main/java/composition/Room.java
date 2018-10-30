package composition;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {
    private Double height;
    private Double suface;
    private List<Furniture> roomFurniture;
    private List<String> roomObjects;
    private List<RoomComponent> roomComponents;

    public String getFurnitureName(int index) {
        if (checkIndexAndList(this.roomFurniture, index))
            return this.roomFurniture.get(index).getName();
        return null;
    }

    public Double getFurnitureHeight(int index) {
        if (checkIndexAndList(this.roomFurniture, index))
            return this.roomFurniture.get(index).getHeight();
        return null;
    }

    public Double getFurnitureWidth(int index) {
        if (checkIndexAndList(this.roomFurniture, index))
            return this.roomFurniture.get(index).getWidth();
        return null;
    }

    public Double getFurnitureLength(int index) {
        if (checkIndexAndList(this.roomFurniture, index))
            return this.roomFurniture.get(index).getLength();
        return null;
    }

    public FurnitureDurability getFurnitureDurability(int index) {
        if (checkIndexAndList(this.roomFurniture, index))
            return this.roomFurniture.get(index).getDurability();
        return null;
    }

    private static boolean checkIndexAndList(List list, int index) {
        if (list == null) {
            System.out.println("List is null");
            return false;
        }
        else if (index < 0 || index >= list.size()) {
            System.out.println("Index out of bounds");
            return false;
        }
        return true;
    }
}
