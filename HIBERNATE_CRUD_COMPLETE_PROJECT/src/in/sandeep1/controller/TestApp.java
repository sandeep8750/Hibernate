package in.sandeep1.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.sandeep2.service.IStudentservice;
import in.sandeep2.servicefactory.StudentServicefactory;
import in.sandeep4.dto.Student;

public class TestApp {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER UR CHOICE, PRESS[1/2/3/4/5]::  ");
			String option = br.readLine();

			switch (option) {
			case "1":
				addStudent();
				break;
			case "2":
				searchStudent();
				break;
			case "3":
				update();
				break;
			case "4":
				deleteStudent();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}

		}
	}

	// Insert student
	private static void addStudent() {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter Student Name :: ");
		String sname = input.next();

		System.out.println("Enter Student Age :: ");
		Integer sage = input.nextInt();

		System.out.println("Enter Student Address :: ");
		String saddress = input.next();

		IStudentservice studentService = StudentServicefactory.getStudentService();
		String addStudent = studentService.addStudent(sname, sage, saddress);
		if (addStudent.equalsIgnoreCase("sucess")) {
			System.out.println("Record inserted successfully");
		}

	}

	// Search student form database
	private static void searchStudent() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter Student id :: ");
		Integer sid = input.nextInt();

		IStudentservice studentService = StudentServicefactory.getStudentService();
		Student getedStudent = studentService.searchStudent(sid);

		if (getedStudent != null) {

			Integer id = getedStudent.getStudentID();
			String name = getedStudent.getStudentName();
			Integer age = getedStudent.getStudentAge();
			String address = getedStudent.getStudentAddress();
			System.out.println("Id" + "\t" + "Name" + "\t" + "Age" + "\t" + "Address");

			System.out.println(id + "\t" + name + "\t" + age + "\t" + address);
			System.out.println();
			System.out.println();
			} else {
			System.out.println("Record in not found for perticular student whose id is " + sid + ".....");
		}
	}

	private static void update() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the student id to be updated:: ");
		String sid = br.readLine();

		IStudentservice studentService = StudentServicefactory.getStudentService();
		Student student = studentService.searchStudent(Integer.parseInt(sid));

		if (student != null) {
			Student newStudent = new Student();

			System.out.println("Student id is :: " + student.getStudentID());
			newStudent.setStudentID(student.getStudentID());

			System.out.print("Student oldName is :: " + student.getStudentName() + "\n Enter newName :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				newStudent.setStudentName(student.getStudentName());
			} else {
				newStudent.setStudentName(newName);
			}
			System.out.print("Student oldAge is :: " + student.getStudentAge() + "\n Enter newAge :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				newStudent.setStudentAge(student.getStudentAge());
			} else {
				newStudent.setStudentAge(Integer.parseInt(newAge));
			}
			System.out.print("Student oldAddress is :: " + student.getStudentAddress() + "\n Enter newAddress :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				newStudent.setStudentAddress(student.getStudentAddress());
			} else {
				newStudent.setStudentAddress(newAddress);
			}

			System.out.println("new Object data is :: " + newStudent);
			System.out.println();

			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("sucess")) {
				System.out.println("record updated succesfully");
			} else {
				System.out.println("record updation failed");
			}

		} else {
			System.out.println("Student record not available for the given id  " + sid + " for updation...");
		}
	}

	private static void deleteStudent() {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter Student id :: ");
		Integer sid = input.nextInt();

		IStudentservice studentService = StudentServicefactory.getStudentService();
		String deletedStudent = studentService.deleteStudent(sid);

		if (deletedStudent.equalsIgnoreCase("success")) {
			System.out.println("Record deletd successfully.....");
		} else if (deletedStudent.equalsIgnoreCase("not found")) {
			System.out.println(" Record not found.....");
		} else {
			System.out.println("Oops! something went wrong....");
		}
	}

}
