package MusicPlayer;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class giris extends JFrame {

	private JPanel contentPane;
	private JTextField txt_kullaniciAdi;
	private JTextField txt_sifre;
	static String kullanici_ad;
	static String sifre;
	static String giris_id;
	private JTextField txt_email;
	private JTextField txt_uyelik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris frame = new giris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public giris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 801, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txt_kullaniciAdi = new JTextField();
		txt_sifre = new JTextField();
		JButton btnNewButton_2 = new JButton("Giriþ");
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 ad\u0131 ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JButton btnNewButton_1 = new JButton("KULLAN\u0130C\u0130 G\u0130R\u0130\u015E\u0130");
		JButton btnNewButton = new JButton("ADM\u0130N G\u0130R\u0130\u015E\u0130");
		JButton btnNewButton_3 = new JButton("giri\u015F admin");
		
		JButton btnNewButton_5 = new JButton("Kaydet");
		
		btnNewButton_5.setBounds(351, 262, 120, 30);
		
		
		
		JComboBox comboBox_uyelik = new JComboBox();
		comboBox_uyelik.setModel(new DefaultComboBoxModel(new String[] {"Normal Uyelik", "Premium Uyelik"}));
		comboBox_uyelik.setBounds(330, 118, 122, 21);
		contentPane.add(comboBox_uyelik);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(187, 99, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_2.setVisible(false);
		
		comboBox_uyelik.setVisible(false);
		
		btnNewButton_5.setVisible(false);
		txt_email = new JTextField();
		txt_email.setBounds(345, 318, 96, 19);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		txt_email.setVisible(false);
		
		txt_uyelik = new JTextField();
		txt_uyelik.setBounds(345, 369, 96, 19);
		contentPane.add(txt_uyelik);
		txt_uyelik.setColumns(10);
		txt_uyelik.setVisible(false);
		
		
		JButton btnNewButton_4 = new JButton("\u00DCYE OL");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(489, 286, 169, 49);
		btnNewButton_4.setVisible(false);
		
	
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// admin giriþi
				txt_sifre.setBounds(345, 204, 96, 19);
				
				btnNewButton_3.setBounds(345, 250, 96, 19);
				btnNewButton_2.setVisible(true);
				lblNewLabel_1.setBounds(254, 204, 96, 19);
				
				txt_email.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_5.setVisible(false);
				btnNewButton_2.setVisible(false);
				
				 lblNewLabel_2.setVisible(false);
				txt_kullaniciAdi.setVisible(false); 
				
				comboBox_uyelik.setVisible(false);
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(true);
				
				
				
				btnNewButton_3.setVisible(true);
				txt_sifre.setVisible(true); 
				btnNewButton.setVisible(false);
				lblNewLabel_1.setVisible(true);
				btnNewButton_1.setBounds(38, 320, 161, 49);
				btnNewButton_1.setVisible(true);
				
				
	
			}
		});
		btnNewButton.setBounds(138, 188, 161, 49);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//kullanici girisi
				btnNewButton_3.setVisible(false);
				btnNewButton_2.setVisible(true);
				btnNewButton_2.setBounds(351,262 , 70, 30);
				
				btnNewButton_5.setVisible(false);
				comboBox_uyelik.setVisible(false);
				lblNewLabel_2.setVisible(false);
				txt_email.setVisible(false);
				lblNewLabel.setBounds(254, 161, 96, 19);
				btnNewButton_4.setVisible(true);
				btnNewButton.setVisible(true);
				btnNewButton_2.setVisible(true);
				txt_kullaniciAdi.setVisible(true); 
				txt_kullaniciAdi.setBounds(345, 161, 96, 19);
				txt_sifre.setVisible(true); 
				txt_sifre.setBounds(345, 204, 96, 19);
				btnNewButton_1.setVisible(false);
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				
				btnNewButton.setBounds(38, 320, 161, 49);
				btnNewButton_4.setBounds(600, 20, 161, 49);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(489, 188, 169, 49);
		contentPane.add(btnNewButton_1);
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//kullanici girisi
				// SELECT count(kullanici_id) FROM kullanici WHERE  kullanici_adi='nkullanici1' and kullanici_sifre = '1234';
				
				
				txt_email.setVisible(false);
				lblNewLabel_2.setVisible(false);
				kullanici_ad=txt_kullaniciAdi.getText();
				sifre=txt_sifre.getText();
				
				String sql_sorgu;
				sql_sorgu="SELECT count(kullanici_id) FROM kullanici WHERE  kullanici_adi='"+kullanici_ad+"' and kullanici_sifre = '"+sifre+"'";
				
				ResultSet myRs = baglanti.yap(sql_sorgu);
				
				try {
					while(myRs.next()){
						if(myRs.getInt("count(kullanici_id)")==1) {
							System.out.println("GÝRÝÞ YAPILDI");
							anaEkran anaEkran1=new anaEkran();
							anaEkran1.setVisible(true);
							
							setVisible(false);
							
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				sql_sorgu="SELECT kullanici_id FROM kullanici WHERE  kullanici_adi='"+kullanici_ad+"' and kullanici_sifre = '"+sifre+"'";
				
				myRs = baglanti.yap(sql_sorgu);
				String id=null;
				try {
					while(myRs.next()){
						
							id=myRs.getString("kullanici_id");
							
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				giris_id=id;
				System.out.println("------------------"+id);
				
				
				
			}
		});
		btnNewButton_2.setBounds(207, 317, 85, 21);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		
		txt_kullaniciAdi.setBounds(345, 161, 96, 19);
		txt_kullaniciAdi.setVisible(false);
		contentPane.add(txt_kullaniciAdi);
		txt_kullaniciAdi.setColumns(10);
		
		
		txt_sifre.setText("");
		txt_sifre.setBounds(345, 204, 96, 19);
		contentPane.add(txt_sifre);
		txt_sifre.setVisible(false);
		txt_sifre.setColumns(10);
		
		
		lblNewLabel.setBounds(254, 165, 80, 13);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(254,  204, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//admin giriþi
				
				String sifre;
				sifre=txt_sifre.getText();
				if(sifre.equals("12345")) {
					frm1 adminekrani=new frm1();
					adminekrani.setVisible(true);
					
					setVisible(false);
					
			}	
					
				
				
			}
		});
		btnNewButton_3.setBounds(187, 267, 85, 21);
		btnNewButton_3.setVisible(false);
	
		contentPane.add(btnNewButton_3);
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_uyelik.setVisible(true);
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setBounds(3450, 103, 96, 19);
				btnNewButton_3.setBounds(3450, 103, 96, 19);
				btnNewButton_5.setVisible(true);
				btnNewButton_2.setVisible(false);
				
				txt_kullaniciAdi.setBounds(345, 150, 96, 19);
				txt_sifre.setVisible(true); 
				txt_sifre.setBounds(345, 170, 96, 19);
				
				txt_email.setBounds(345, 190, 96, 19);
				comboBox_uyelik.setBounds(345, 220, 120, 19);
				txt_email.setVisible(true);
				
				lblNewLabel.setBounds(254, 150, 96, 19);
				lblNewLabel_1.setBounds(254, 170, 96, 19);
				lblNewLabel_2.setBounds(254,190 ,94 ,19 );
				
				lblNewLabel_2.setVisible(true);
				btnNewButton_4.setVisible(false);
				btnNewButton.setVisible(true);
				btnNewButton_2.setVisible(true);
				txt_kullaniciAdi.setVisible(true); 
				txt_sifre.setVisible(true); 
				btnNewButton_1.setVisible(false);
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				
			}
		});
		
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sql_sorgu,kullanici_adi,kullanici_sifre,kullanici_email,ýd;
				
				kullanici_adi=txt_kullaniciAdi.getText();
				kullanici_sifre=txt_sifre.getText();
				kullanici_email=txt_email.getText();
				
				int secilen = comboBox_uyelik.getSelectedIndex();
				int enBuyukid=0;
				
				sql_sorgu="SELECT * FROM kullanici order by kullanici_id desc limit 1 ;";
				ResultSet myRs = baglanti.yap(sql_sorgu);
				
				try {
					while(myRs.next()){
						//enBuyukid=myRs.getString("calmalistesi_id");
						enBuyukid=myRs.getInt("kullanici_id");
						System.out.println("GÝRDÝ");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				enBuyukid=enBuyukid+1;
				
				System.out.println(enBuyukid);
				
				if(secilen ==0) {

					sql_sorgu="INSERT INTO kullanici(kullanici_id,kullanici_adi,kullanici_email,kullanici_sifre,kullanici_abonelik,kullanici_odeme)"+
							"VALUES ("+enBuyukid+",'"+kullanici_adi+"','"+kullanici_email+"','"+kullanici_sifre+"',0,0)";
					
				}else if (secilen ==1) {
					
					sql_sorgu="INSERT INTO kullanici(kullanici_id,kullanici_adi,kullanici_email,kullanici_sifre,kullanici_abonelik,kullanici_odeme)"+
							"VALUES ("+enBuyukid+",'"+kullanici_adi+"','"+kullanici_email+"','"+kullanici_sifre+"',1,1)";
				}
				
				
		
				baglanti.ekle(sql_sorgu);
				
				System.out.println(sql_sorgu);
				System.out.println(secilen);
				
			}
		});
		
		contentPane.add(btnNewButton_4);
		
		
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00DCZIK DOSYAM");
		lblNewLabel_3.setForeground(new Color(147, 112, 219));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 70));
		lblNewLabel_3.setBounds(52, 20, 659, 152);
		contentPane.add(lblNewLabel_3);
		
		
		
		
		
		
	}
}
