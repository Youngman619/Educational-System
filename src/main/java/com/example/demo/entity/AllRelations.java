package com.example.demo.entity;

public class AllRelations {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_schedule_room_teacher_lesson_rel.uuid
     *
     * @mbggenerated
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_schedule_room_teacher_lesson_rel.scheduleId
     *
     * @mbggenerated
     */
    private String scheduleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_schedule_room_teacher_lesson_rel.roomId
     *
     * @mbggenerated
     */
    private String roomid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_schedule_room_teacher_lesson_rel.teacherId
     *
     * @mbggenerated
     */
    private String teacherid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_schedule_room_teacher_lesson_rel.lessonId
     *
     * @mbggenerated
     */
    private String lessonid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_schedule_room_teacher_lesson_rel.uuid
     *
     * @return the value of tb_schedule_room_teacher_lesson_rel.uuid
     *
     * @mbggenerated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_schedule_room_teacher_lesson_rel.uuid
     *
     * @param uuid the value for tb_schedule_room_teacher_lesson_rel.uuid
     *
     * @mbggenerated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_schedule_room_teacher_lesson_rel.scheduleId
     *
     * @return the value of tb_schedule_room_teacher_lesson_rel.scheduleId
     *
     * @mbggenerated
     */
    public String getScheduleid() {
        return scheduleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_schedule_room_teacher_lesson_rel.scheduleId
     *
     * @param scheduleid the value for tb_schedule_room_teacher_lesson_rel.scheduleId
     *
     * @mbggenerated
     */
    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid == null ? null : scheduleid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_schedule_room_teacher_lesson_rel.roomId
     *
     * @return the value of tb_schedule_room_teacher_lesson_rel.roomId
     *
     * @mbggenerated
     */
    public String getRoomid() {
        return roomid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_schedule_room_teacher_lesson_rel.roomId
     *
     * @param roomid the value for tb_schedule_room_teacher_lesson_rel.roomId
     *
     * @mbggenerated
     */
    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_schedule_room_teacher_lesson_rel.teacherId
     *
     * @return the value of tb_schedule_room_teacher_lesson_rel.teacherId
     *
     * @mbggenerated
     */
    public String getTeacherid() {
        return teacherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_schedule_room_teacher_lesson_rel.teacherId
     *
     * @param teacherid the value for tb_schedule_room_teacher_lesson_rel.teacherId
     *
     * @mbggenerated
     */
    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid == null ? null : teacherid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_schedule_room_teacher_lesson_rel.lessonId
     *
     * @return the value of tb_schedule_room_teacher_lesson_rel.lessonId
     *
     * @mbggenerated
     */
    public String getLessonid() {
        return lessonid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_schedule_room_teacher_lesson_rel.lessonId
     *
     * @param lessonid the value for tb_schedule_room_teacher_lesson_rel.lessonId
     *
     * @mbggenerated
     */
    public void setLessonid(String lessonid) {
        this.lessonid = lessonid == null ? null : lessonid.trim();
    }
}