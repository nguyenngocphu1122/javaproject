package bkap.entity;

import java.util.Scanner;

public class Test {

	private Employee arrEmp[]; // Khai báo mảng nhân viên
	private int empCounter = 0;

	/**
	 * Hiển thị menu lựa chọn cho chương trình console
	 * 
	 * @return
	 */
	private int showMenu() {
		System.out.println(
				"*****************************MENU*************************\r\n" + "1. Nhập thông tin cho n nhân viên\n"
						+ "2. Tính lương tất cả nhân viên\n" + "3. Hiển thị thông tin tất cả nhân viên\r\n"
						+ "4. Sắp xếp nhân viên theo lương tăng dần\n" + "5. Tìm kiếm nhân viên theo tên nhân viên\n"
						+ "6. Cập nhật trạng thái nhân viên theo mã nhân viên\n" + "7. Thoát\n");
		System.out.println("Mời chọn giá trị từ 1-7");
		Scanner sc = new Scanner(System.in);

		return sc.nextInt();
	}

	/**
	 * Nhập thông tin cho n nhân viên
	 */
	private void inputEmployee() {
		if (this.empCounter == 0) {
			System.out.println("Số lượng nhân viên muốn nhập");
			Scanner sc = new Scanner(System.in);
			this.empCounter = sc.nextInt();
			this.arrEmp = new Employee[empCounter];

			for (int i = 0; i < arrEmp.length; i++) {
				System.out.println("Nhân viên thứ: " + (i + 1));
				arrEmp[i] = new Employee();
				arrEmp[i].inputData();
			}
			System.out.printf("Nhập xong thông tin %d nhân viên\n", this.empCounter);
		} else {
			System.out.println("Đã nhập thông tin nhân viên");
		}
	}

	/**
	 * Tính toán lương
	 */
	private void calculateSalary() {
		System.out.println("Tính lương nhân viên.....");
		for (int i = 0; i < arrEmp.length; i++) {
			arrEmp[i].calSalary();
		}
		System.out.println("Tính xong");
	}

	/**
	 * Hiển thị danh sách nhân viên
	 */
	private void printListEmp() {
		System.out.printf("%5s | %20s | %3s | %5s | %10s | %2s |\n", "ID", "Fullname", "Age", "Rate", "Salary", "St");
		for (Employee emp : arrEmp) {
			emp.outputData();
		}
	}

	/**
	 * Sắp xếp theo lương
	 */
	private void sortBySalary() {
		// Thuật toán sắp xếp: bubber sort
		for (int i = 0; i < arrEmp.length - 1; i++) {
			for (int j = i + 1; j < arrEmp.length; j++) {
				if (arrEmp[i].getEmpSalary() > arrEmp[j].getEmpSalary()) {
					Employee e = new Employee();
					e = arrEmp[i];
					arrEmp[i] = arrEmp[j];
					arrEmp[j] = e;
				}
			}
		}
		System.out.println("Danh sách nhân viên sau khi sắp xếp tăng dần theo lương");
		this.printListEmp();
	}

	private void searchEmpByName() {
		System.out.println("Nhập tên nhân viên muốn tìm: ");
		Scanner sc = new Scanner(System.in);
		String search = sc.nextLine();
		System.out.printf("%5s | %20s | %3s | %5s | %10s | %2s |", "ID", "Fullname", "Age", "Rate", "Salary", "St");
		boolean isNotExist = false;
		for (Employee e : arrEmp) {
			if (e.getEmpName().contains(search)) {
				e.outputData();
				isNotExist = true;
			}
		}
		if (isNotExist == false) {
			System.out.printf("Không có nhân viên tên là '%s'\n", search);
		}
	}

	private void updateStatus() {
		System.out.println("Nhập mã nhân viên cần cập nhật");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		boolean isFound = false;
		for (int i = 0; i < arrEmp.length; i++) {
			if (arrEmp[i].getEmpId().equals(id)) {
				System.out.println("Nhập trạng thái mới");
				System.out.println("Trạng thái (1-Đang làm | 0-Nghỉ việc):");
				arrEmp[i].setEmpStatus(sc.nextInt() > 0);
				System.out.println("\tCảm ơn!");
				isFound = true;
			}
		}
		if (isFound == false) {
			System.out.printf("Không tìm thấy nhân viên có mã %s\n", id);
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		int luaChon = 0;
		do {
			luaChon = test.showMenu();
			switch (luaChon) {
			case 1:
				test.inputEmployee();
				break;
			case 2:
				test.calculateSalary();
				break;
			case 3:
				test.printListEmp();
				break;
			case 4:
				test.sortBySalary();
				;
				break;
			case 5:
				test.searchEmpByName();
				break;
			case 6:
				test.updateStatus();
				break;
			case 7:
				System.out.println("Xin chào và hẹn gặp lại");
				break;
			default:
				System.out.println("Lựa chọn không xác định");
				break;
			}

		} while (luaChon > 0 && luaChon < 7);
		System.out.println("Chương trình kết thúc");

//		String strA = "Anh";
//		String strB = "Bach";
//		strA.compareTo(strB); // A - B <=> 1-2 = -1
		// <0: chuỗi 1 trước chuỗi 2
		// =0: chuỗi 1 trùng chuỗi 2
		// >0: chuỗi 1 sau chuỗi 2 >>>>> đảo chỗ
	}

}
