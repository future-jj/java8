import java.util.ArrayList;

import java.util.List;

public class compare {
    public static void main(String[] args) {
        List<entity> entityList1 =new ArrayList<>();
        entity e1=new entity("01","zjj ",18);
        entity e2=new entity("02","zjj ",19);
        entity e3=new entity("03","zjj ",20);
        entity e4=new entity("04","zjj ",99);
        entity e5=new entity("05","zjj ",22);
        entity e6=new entity("06","zjj ",23);
        entityList1.add(e1);
        entityList1.add(e2);
        entityList1.add(e3);
        entityList1.add(e4);
        entityList1.add(e5);
        entityList1.add(e6);
//        将list进行顺序排序
        entityList1.sort((entity o1,entity o2)->o1.getAge().compareTo(o2.getAge()));
        System.out.println(entityList1);
    }
}
