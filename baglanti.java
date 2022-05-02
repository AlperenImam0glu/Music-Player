package MusicPlayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class baglanti {

	static Connection myConn ;
	static Statement myStat;

	static ResultSet yap(String sql_sorgu) {
		ResultSet myRs = null;
		try {
			 myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/prolab3deneme1","root","1234");
			 myStat = myConn.createStatement();
			myRs = myStat.executeQuery(sql_sorgu);
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		return myRs;
	}
	
	static void ekle(String sql_sorgu) {
		
		try {
			myStat.executeUpdate(sql_sorgu);
			JOptionPane.showMessageDialog(null, "BAÞARILI KAYIT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
		}
		
		
	}
	
	
	static void guncelle(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
			
		}
		
		
	}
	
	
	static void sil(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
		}
		
		
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs = null;
		try {
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
		}
		
		return myRs;
		
	}
}



