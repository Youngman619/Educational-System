package com.example.demo.entity;

public class Room {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_room.uuid
     *
     * @mbggenerated
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_room.roomId
     *
     * @mbggenerated
     */
    private String roomid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_room.roomName
     *
     * @mbggenerated
     */
    private String roomname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_room.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_room.uuid
     *
     * @return the value of tb_room.uuid
     *
     * @mbggenerated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_room.uuid
     *
     * @param uuid the value for tb_room.uuid
     *
     * @mbggenerated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_room.roomId
     *
     * @return the value of tb_room.roomId
     *
     * @mbggenerated
     */
    public String getRoomid() {
        return roomid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_room.roomId
     *
     * @param roomid the value for tb_room.roomId
     *
     * @mbggenerated
     */
    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_room.roomName
     *
     * @return the value of tb_room.roomName
     *
     * @mbggenerated
     */
    public String getRoomname() {
        return roomname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_room.roomName
     *
     * @param roomname the value for tb_room.roomName
     *
     * @mbggenerated
     */
    public void setRoomname(String roomname) {
        this.roomname = roomname == null ? null : roomname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_room.type
     *
     * @return the value of tb_room.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_room.type
     *
     * @param type the value for tb_room.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}