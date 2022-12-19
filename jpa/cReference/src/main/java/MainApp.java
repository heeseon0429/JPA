

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.domain.Department;
import com.domain.Employee;

public class MainApp {

   public static void main(String[] args) {
      
      EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("cReference");
      try {
         
         // [1] 연관관계를 이용한 데이타 검색
         selectData(emf);
         
      // [1] 연관관계를 이용한 데이타 입력
         insertData(emf);
         
      }catch(Exception ex) {
         System.out.println("예외:"+ ex.getMessage());
      }finally {
         emf.close();
      }
      
   }

   
   //[1] 연관관계를 이용한 데이타 검색
   static void selectData(EntityManagerFactory emf) {
      EntityManager em = emf.createEntityManager();
      
      Employee e1 = em.find(Employee.class, 7788);
      System.out.println(e1);
      
      System.out.println(e1.getDeptno().getDname()+"님 정보");
      System.out.println("부서:" + e1.getDeptno());
      
      
      em.close();
   } // end selectData
   
   //[1] 연관관계를 이용한 데이타 검색
   static void insertData(EntityManagerFactory emf) {
      EntityManager em = emf.createEntityManager();
      
      EntityTransaction tx = em.getTransaction();    
      
      
      Employee emp1 = new Employee();
      emp1.setEname("만두");
      
      //Department dept = em.find(Department.class, 40);
      Department dept = new Department();
      dept.setDeptno(50);
      dept.setDname("아이티");
      dept.setLoc("대전");
      em.persist(dept);
      emp1.setDeptno(dept);
      
      tx.begin();
     em.persist(emp1);
      tx.commit();
      
      
      
      em.close();
   }
   
   
}