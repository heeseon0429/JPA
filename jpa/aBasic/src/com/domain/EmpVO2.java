package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import net.bytebuddy.implementation.bytecode.assign.reference.GenericTypeAwareAssigner;

@Data //lombok : setter, getter, tostring ....

//
@Entity
@Table(name="EMP_Z")
public class EmpVO2 {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	// mariadb/mysql
	
	private int empno;
	
	@Column(length=30)
	private String ename;
	
	@Column(length=30, nullable=true)
	private String job;
	
	// DB의 컬럼명과 다른 경우
	@Column(name="hire_date")
	private Date hiredate;
	
	@Column(precision=5)
	private int sal;
	
	@Column(columnDefinition="int check(deptno in(87,88,89))")
	private int deptno;
}
