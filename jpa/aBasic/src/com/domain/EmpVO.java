package com.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

//*********
@Entity
@Table(name="EMA_A")
public class EmpVO {

   @Id
   private int empno;
   private String ename;
   private int mgr;
   private String job;
   private Date hiredate;
   private int sal;
   private int comm;
   private int deptno;
   
   
}