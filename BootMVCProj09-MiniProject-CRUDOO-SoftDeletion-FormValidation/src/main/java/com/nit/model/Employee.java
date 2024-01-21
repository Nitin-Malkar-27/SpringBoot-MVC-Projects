package com.nit.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "boot_emp")
@Data
@SQLDelete(sql = "UPDATE BOOT_EMP SET STATUS='deleted' WHERE EMPNO=?")
@Where(clause = "STATUS <> 'deleted'")
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_no_seq1", initialValue = 3000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.AUTO)
	private Integer empno;
	private String ename;
	private String job;
	private Float sal;
	private Integer deptno = 10;
	private String status = "active";
	@Transient
	private String vflag = "no";
}
