package com.example.demo.entity;

public class FixOrder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.uuid
     *
     * @mbggenerated
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.orderId
     *
     * @mbggenerated
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.creatorUuid
     *
     * @mbggenerated
     */
    private String creatoruuid;

    private String theme;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.detail
     *
     * @mbggenerated
     */
    private String detail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.amount
     *
     * @mbggenerated
     */
    private String amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.orderTime
     *
     * @mbggenerated
     */
    private String ordertime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.finishTime
     *
     * @mbggenerated
     */
    private String finishtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_fix_order.status
     *
     * @mbggenerated
     */
    private String status;

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.uuid
     *
     * @return the value of tb_fix_order.uuid
     *
     * @mbggenerated
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.uuid
     *
     * @param uuid the value for tb_fix_order.uuid
     *
     * @mbggenerated
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.orderId
     *
     * @return the value of tb_fix_order.orderId
     *
     * @mbggenerated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.orderId
     *
     * @param orderid the value for tb_fix_order.orderId
     *
     * @mbggenerated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.creatorUuid
     *
     * @return the value of tb_fix_order.creatorUuid
     *
     * @mbggenerated
     */
    public String getCreatoruuid() {
        return creatoruuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.creatorUuid
     *
     * @param creatoruuid the value for tb_fix_order.creatorUuid
     *
     * @mbggenerated
     */
    public void setCreatoruuid(String creatoruuid) {
        this.creatoruuid = creatoruuid == null ? null : creatoruuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.detail
     *
     * @return the value of tb_fix_order.detail
     *
     * @mbggenerated
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.detail
     *
     * @param detail the value for tb_fix_order.detail
     *
     * @mbggenerated
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.amount
     *
     * @return the value of tb_fix_order.amount
     *
     * @mbggenerated
     */
    public String getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.amount
     *
     * @param amount the value for tb_fix_order.amount
     *
     * @mbggenerated
     */
    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.orderTime
     *
     * @return the value of tb_fix_order.orderTime
     *
     * @mbggenerated
     */
    public String getOrdertime() {
        return ordertime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.orderTime
     *
     * @param ordertime the value for tb_fix_order.orderTime
     *
     * @mbggenerated
     */
    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.finishTime
     *
     * @return the value of tb_fix_order.finishTime
     *
     * @mbggenerated
     */
    public String getFinishtime() {
        return finishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.finishTime
     *
     * @param finishtime the value for tb_fix_order.finishTime
     *
     * @mbggenerated
     */
    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime == null ? null : finishtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_fix_order.status
     *
     * @return the value of tb_fix_order.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_fix_order.status
     *
     * @param status the value for tb_fix_order.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}