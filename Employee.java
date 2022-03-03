package bkap.entity;

import java.util.Scanner;

public class Employee {
	private String empId;
	private String empName;
	private int empAge;
	private float empRate;
	private float empSalary;
	private boolean empStatus;

	public Employee() {
	}

	public Employee(String empId, String empName, int empAge, float empRate, float empSalary, boolean empStatus) {
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empRate = empRate;
		this.empSalary = empSalary;
		this.empStatus = empStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public float getEmpRate() {
		return empRate;
	}

	public void setEmpRate(float empRate) {
		this.empRate = empRate;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	public boolean isEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}

	public void inputData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id:");
		this.empId = sc.nextLine();
		System.out.println("Họ và tên:");
		this.empName = sc.nextLine();
		System.out.println("Tuổi:");
		this.empAge = sc.nextInt();
		System.out.println("Hệ số lương:");
		this.empRate = sc.nextFloat();
		System.out.println("Trạng thái (1-Đang làm | 0-Nghỉ việc):");
		this.empStatus = sc.nextInt() > 0;
		System.out.println("\tCảm ơn!");
	}

	public void outputData() {
		System.out.printf("%5s | %20s | %3d | %5.2f | %10.2f | %2s |\n", this.empId, this.empName, this.empAge,
				this.empRate, this.empSalary, this.empStatus ? "OK" : " ");
	}
	
	public void calSalary() {
		this.empSalary = this.empRate * 1_300_000;
	}
}
