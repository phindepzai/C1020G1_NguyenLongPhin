package bai10_stack_queue.baitap.demerging;

public class Employee implements Comparable {
    public String name;
    public String sex;
    public String birthday;

    public Employee() {
    }

    public Employee(String name, String sex, String birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        String arr[] = this.birthday.split("/");
        String arr2[] = ((Employee) o).getBirthday().split("/");
        if (arr[2].compareTo(arr2[2]) != 0){
            return arr2[2].compareTo(arr[2]);
        } else {
            if (arr[1].compareTo(arr2[1]) != 0){
                return arr[1].compareTo(arr2[1]);
            }else {
                return arr[0].compareTo(arr2[0]);
            }
        }
    }
}
