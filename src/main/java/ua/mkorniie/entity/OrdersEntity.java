package ua.mkorniie.entity;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.Objects;
//
//@Entity
//@Table(name = "orders", schema = "mydb")
//public class OrdersEntity {
//    private int id;
//    private Timestamp date;
//    private boolean isExecuted;
//    private int sum;
//    private int period;
//
//    @Id
//    @Column(name = "id")
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "date")
//    public Timestamp getDate() {
//        return date;
//    }
//
//    public void setDate(Timestamp date) {
//        this.date = date;
//    }
//
//    @Basic
//    @Column(name = "is_executed")
//    public boolean getIsExecuted() {
//        return isExecuted;
//    }
//
//    public void setIsExecuted(boolean isExecuted) {
//        this.isExecuted = isExecuted;
//    }
//
//    @Basic
//    @Column(name = "sum")
//    public int getSum() {
//        return sum;
//    }
//
//    public void setSum(int sum) {
//        this.sum = sum;
//    }
//
//    @Basic
//    @Column(name = "period")
//    public int getPeriod() {
//        return period;
//    }
//
//    public void setPeriod(int period) {
//        this.period = period;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        OrdersEntity that = (OrdersEntity) o;
//        return id == that.id &&
//                isExecuted == that.isExecuted &&
//                sum == that.sum &&
//                period == that.period &&
//                Objects.equals(date, that.date);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, date, isExecuted, sum, period);
//    }
//}
