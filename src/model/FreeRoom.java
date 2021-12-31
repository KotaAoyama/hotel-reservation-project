package model;

public class FreeRoom extends Room {

    public FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, enumeration);
        this.price = 0.0;
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price= Free" +
                ", enumeration=" + enumeration +
                '}';
    }
}
