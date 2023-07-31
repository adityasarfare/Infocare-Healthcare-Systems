package com.javaguides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calculated_results")
public class CalculatedResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num1")
    private double num1;

    @Column(name = "num2")
    private double num2;

    @Column(name = "result")
    private double result;
    

	public CalculatedResult() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "CalculatedResult [id=" + id + ", num1=" + num1 + ", num2=" + num2 + ", result=" + result + "]";
	}


    
    
}

