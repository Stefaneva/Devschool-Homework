package composition;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        List<Furniture> furnitureList = new ArrayList<>();
        List<String> roomObjects = new ArrayList<>();
        List<RoomComponent> roomComponents = new ArrayList<>();

        room.setSuface(30.40);
        room.setHeight(40.30);

        Furniture furniture = new Furniture();
        furniture.setName("Wardrobe");
        furniture.setHeight(12d);
        furniture.setLength(16d);
        furniture.setWidth(18d);
        furniture.setDurability(FurnitureDurability.HIGH);
        furnitureList.add(furniture);
        room.setRoomFurniture(furnitureList);

        String lamp = "Lamp";
        String pencil = "Pencil";
        roomObjects.add(lamp);
        roomObjects.add(pencil);
        room.setRoomObjects(roomObjects);

        RoomComponent roomComponent = new RoomComponent();
        roomComponent.setComponentName("Window");
        roomComponent.setHeight(10d);
        roomComponent.setWidth(14d);
        roomComponent.setMaterialType("Vinyl");
        roomComponents.add(roomComponent);
        roomComponent = new RoomComponent();
        roomComponent.setComponentName("Door");
        roomComponent.setHeight(20d);
        roomComponent.setWidth(12.70);
        roomComponent.setMaterialType("Wood");
        roomComponents.add(roomComponent);
        room.setRoomComponents(roomComponents);

        System.out.println(room.getFurnitureName(0));
        System.out.println(room.getFurnitureName(10000));
        System.out.println(room);
    }
}
