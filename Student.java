package com.student.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;
import com.student.util.MyUtil;

public class Student {
	public static String name;
	public static int kor;
	public static int eng;
	public static int math;
	public static double avg;
	public static String grade=null;
	public static Connection con = null;
	public static PreparedStatement ps= null;
	public static ResultSet rs= null;
	
	public static void main(String[] args) {
		int num= Integer.parseInt(JOptionPane.showInputDialog("0.종료\n1.학생 추가\n2.모든 학생 보기(성적순)\n3.모든 학생 보기(번호순)\n4.학생 검색\n5.1등 학생보기\n6.학생 삭제"));
		
		switch(num) {
		case 0: finish();
		break;
		case 1: add();
		break;
		case 2: select_grade();
		break;
		case 3: select_num();
		break;
		case 4: search();
		break;
		case 5: first();
		break;
		case 6: delete();
		break;
		}
		
	}
	private static void grade(double avg,String grade) {
		if(avg>=90) 
			Student.grade="A";
		else if(avg>=80)
			Student.grade="B";
		else if(avg>=70)
			Student.grade="C";
		else
			Student.grade="F";
	}
	private static void add() {
		
		System.out.println("학생 추가");
		Scanner sc= new Scanner(System.in);
		name=sc.next();
		kor=sc.nextInt();
		eng=sc.nextInt();
		math=sc.nextInt();
		avg=(kor+eng+math)/3;
		
		grade(avg,grade);
		
		
		
		String sql="INSERT INTO student VALUES(pok_seq.NEXTVAL, ?, ?, ? , ?, ?, SYSDATE)";
		try {
			con=MyUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, kor);
			ps.setInt(3, eng);
			ps.setInt(4, math);
			ps.setDouble(5, avg);
			ps.setString(6, grade);
			
			ps.execute();
			
			System.out.println(name+"학생이 추가 되었습니다.");
			
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			MyUtil.close(con, ps, rs);
		}
		
		
		
	}
	private static void delete() {
		// TODO Auto-generated method stub
		
	}
	private static void first() {
		// TODO Auto-generated method stub
		
	}
	private static void search() {
		// TODO Auto-generated method stub
		
	}
	private static void select_num() {
		// TODO Auto-generated method stub
		
	}
	private static void select_grade() {
		// TODO Auto-generated method stub
		
	}
	private static void finish() {
		// TODO Auto-generated method stub
		
	}

}
