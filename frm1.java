package MusicPlayer;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class frm1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel modelim = new DefaultTableModel();
	DefaultTableModel modelim2 = new DefaultTableModel();
	DefaultTableModel modelim3 = new DefaultTableModel();
	DefaultTableModel modelim4 = new DefaultTableModel();
	DefaultTableModel modelim5 = new DefaultTableModel();
	
	Object[] kolonlar = {"ID","SANATÇI","ÞARKI ÝSÝM","ALBUM","SURE","DÝNLENME","YEREL DÝNLENME","ALBUM"};
	Object[] satirlar= new Object[8];
	
	Object[] kolonlar2 = {"ID","ALBUM ADI","ALBUM TARÝHÝ","ALBUM TÜRÜ","SANATCI ID"};
	Object[] satirlar2= new Object[5];
	
	Object[] kolonlar3 = {"ID","SANATCI ADI","ULKE"};
	Object[] satirlar3= new Object[3];
	
	
	Object[] kolonlar4 = {"ID","KULLANÝCÝ ADÝ","E-MAÝL","ÞÝFRE","ABONELÝK","ÖDEME"};
	Object[] satirlar4= new Object[6];
	
	Object[] kolonlar5 = {"ÝD","SANATÇI ÝD","ÞARKI ÝD"};
	Object[] satirlar5= new Object[3];
	
	
	private JTextField txt_sarkiAdi;
	private JTextField txt_sure;
	private JTextField txt_dinlenmeSayisiGenel;
	private JTextField txt_albumId;
	private JTextField txt_sarkiid;
	private JTable table_1;
	private JTextField txt2_albumýd;
	private JTextField txt2_albumadi;
	private JTextField txt2_albumtarihi;
	private JTextField txt2_albumtur;
	private JTextField txt2_albumsanatci;
	private JTable table_2;
	private JTextField txt3_sanatciid;
	private JTextField txt3_sanatciadi;
	private JTextField txt3_sanatciulke;
	private JTable table_3;
	private JTextField txt4_kullaniciid;
	private JTextField txt4_kullaniciadi;
	private JTextField txt4_kullaniciemail;
	private JTextField txt4_kullanicisifre;
	private JTextField txt4_kullaniciabonelik;
	private JTextField txt4_kullaniciodeme;
	private JTable table_4;
	private JTextField txt5_id;
	private JTextField txt5_sanatci;
	private JTextField txt5_album;
	private JTextField txt_dinlenmeSayisiYerel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm1 frame = new frm1();
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
	public frm1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 10, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(179,179,179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 41, 530, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table.setBounds(191, 283, 274, 110);
		scrollPane.setViewportView(table);
		
		
	
		JButton btnNewButton = new JButton("\u015EARKLILARI L\u0130STELE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sql_sorgu=" SELECT sarki_id,sanatci.sanatci_adi, sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,sarki.sarki_dinlenmeYerel,sarki.album_id FROM sanatci,album,sarki where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "and  sarki.album_id=album.album_id order by sarki_id asc;  ";
				ResultSet myRs= baglanti.yap(sql_sorgu);
				modelim.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar[0]= myRs.getString("sarki_id");
					satirlar[1]= myRs.getString("sanatci_adi");
					satirlar[2]= myRs.getString("sarki_adi");
					satirlar[3]= myRs.getString("album_adi");
					satirlar[4]= myRs.getString("sarki_sure");
					satirlar[5]= myRs.getString("sarki_dinlenmeGenel");
					satirlar[6]= myRs.getString("sarki_dinlenmeYerel");
					satirlar[7]= myRs.getString("album_id");
					modelim.addRow(satirlar);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
				}
				
				
				
				table.setModel(modelim);
				table.getColumnModel().getColumn(0).setMaxWidth(20);
				table.getColumnModel().getColumn(4).setMaxWidth(40);
				table.getColumnModel().getColumn(5).setMaxWidth(65);
				table.getColumnModel().getColumn(6).setMaxWidth(50);
				table.getColumnModel().getColumn(7).setMaxWidth(50);
			}
		});
		
		
		
		JButton btnNewButton_8 = new JButton("SANATCILARI L\u0130STELE");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_sorgu="SELECT * FROM sanatci";
				
				ResultSet myRs= baglanti.yap(sql_sorgu);
				modelim3.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar3[0]= myRs.getString("sanatci_id");
					satirlar3[1]= myRs.getString("sanatci_adi");
					satirlar3[2]= myRs.getString("sanatci_ulke");
					
					modelim3.addRow(satirlar3);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
				}
				
				table_2.setModel(modelim3);
				
				table_2.getColumnModel().getColumn(0).setMaxWidth(20);
			}
		});
		btnNewButton_8.setBounds(1262, 12, 184, 42);
		contentPane.add(btnNewButton_8);
		
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(574, 11, 170, 45);
		contentPane.add(btnNewButton);
		
		txt_sarkiAdi = new JTextField();
		txt_sarkiAdi.setHorizontalAlignment(SwingConstants.LEFT);
		txt_sarkiAdi.setBounds(635, 92, 123, 19);
		contentPane.add(txt_sarkiAdi);
		txt_sarkiAdi.setColumns(10);
		
		txt_sure = new JTextField();
		txt_sure.setBounds(635, 124, 123, 19);
		contentPane.add(txt_sure);
		txt_sure.setColumns(10);
		
		txt_dinlenmeSayisiGenel = new JTextField();
		txt_dinlenmeSayisiGenel.setBounds(635, 153, 123, 19);
		contentPane.add(txt_dinlenmeSayisiGenel);
		txt_dinlenmeSayisiGenel.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Kaydet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// INSERT INTO ogrenci (sarki_id,sarki_adi,sarki_sure,sarki_dinlenmeGenel,album_id) VALUES(41,'Deneme','2:22',1234,1)
				
				String sarki_id,sarki_adi,sarki_sure,sarki_dinlenmeGenel,album_id,sql_sorgu,sarki_dinlenmeYerel; 
				
				sarki_id = txt_sarkiid.getText();
				sarki_adi=txt_sarkiAdi.getText();
				sarki_sure=txt_sure.getText();
				sarki_dinlenmeGenel=txt_dinlenmeSayisiGenel.getText();
				album_id=txt_albumId.getText();
				sarki_dinlenmeYerel=txt_dinlenmeSayisiYerel.getText();
				
				sql_sorgu="INSERT INTO sarki (sarki_id,sarki_adi,sarki_sure,sarki_dinlenmeYerel,sarki_dinlenmeGenel,album_id) VALUES ("+
				
				sarki_id+",'"+sarki_adi+"',"+"'"+sarki_sure+"',"+"'"+sarki_dinlenmeYerel+"','"+sarki_dinlenmeGenel+"',"+album_id+")";
				
				baglanti.ekle(sql_sorgu);
				
				System.out.println(sql_sorgu);
				
			}
		});
		btnNewButton_1.setBounds(550, 244, 78, 21);
		contentPane.add(btnNewButton_1);
		
		txt_albumId = new JTextField();
		txt_albumId.setBounds(635, 215, 123, 19);
		contentPane.add(txt_albumId);
		txt_albumId.setColumns(10);
		
		txt_sarkiid = new JTextField();
		txt_sarkiid.setBounds(635, 66, 123, 19);
		contentPane.add(txt_sarkiid);
		txt_sarkiid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("sarki id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(550, 69, 45, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("sarki adi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(550, 98, 65, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("sarki suresi");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(550, 127, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dinlenme Genel");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(550, 156, 78, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("album id");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(550, 205, 65, 13);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("G\u00FCncelle");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Update sarki SET sarki_id
				
				String sarki_id,sarki_adi,sarki_sure,sarki_dinlenmeGenel,album_id,sql_sorgu,sarki_dinlenmeYerel;
				
				
				sarki_id = txt_sarkiid.getText();
				sarki_adi=txt_sarkiAdi.getText();
				sarki_sure=txt_sure.getText();
				sarki_dinlenmeGenel=txt_dinlenmeSayisiGenel.getText();
				sarki_dinlenmeYerel=txt_dinlenmeSayisiYerel.getText();
				album_id=txt_albumId.getText();
				
				sql_sorgu="UPDATE sarki SET sarki_id ="+ sarki_id+ ","+"sarki_adi ='"+sarki_adi+"',sarki_sure ='"+sarki_sure+"',"+"sarki_dinlenmeYerel="+sarki_dinlenmeYerel+","+"sarki_dinlenmeGenel ="+ sarki_dinlenmeGenel+""+",album_id="+album_id
						+" WHERE sarki_id ="+sarki_id;
				
				baglanti.guncelle(sql_sorgu);
				
				System.out.println(sql_sorgu);
				
				
			}
		});
		btnNewButton_2.setBounds(638, 244, 92, 21);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(10, 322, 530, 189);
		contentPane.add(scrollPane_1);
		
		
		table_1 = new JTable();
		modelim2.setColumnIdentifiers(kolonlar2);
		modelim2.addRow(satirlar2);
		
		table_1.setModel(modelim2);
		
		
		
		table_1.setBounds(625, 400, 220, 152);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_5 = new JLabel("\u015EARKILAR");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5.setBounds(10, 6, 530, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ALB\u00DCMLER");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_6.setBounds(10, 284, 530, 28);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_3 = new JButton("ALB\u00DCMLER\u0130 L\u0130STELE");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_sorgu="SELECT * FROM album;";
				
				ResultSet myRs= baglanti.yap(sql_sorgu);
				modelim2.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar2[0]= myRs.getString("album_id");
					satirlar2[1]= myRs.getString("album_adi");
					satirlar2[2]= myRs.getString("album_tarih");
					satirlar2[3]= myRs.getString("album_tur");
					satirlar2[4]= myRs.getString("sanatci_id");
					modelim2.addRow(satirlar2);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
				}
				
				table_1.setModel(modelim2);
				
				table_1.getColumnModel().getColumn(0).setMaxWidth(20);
				
			}
		});
		btnNewButton_3.setBounds(574, 294, 184, 42);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sil");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sarki_id,sql_sorgu; 
				
				sarki_id = txt_sarkiid.getText();
				
				sql_sorgu="DELETE  FROM sarki WHERE sarki_id="+sarki_id;
				
				baglanti.sil(sql_sorgu);
				
				
			}
		});
		btnNewButton_4.setBounds(740, 244, 55, 21);
		contentPane.add(btnNewButton_4);
		
		txt2_albumýd = new JTextField();
		txt2_albumýd.setBounds(635, 360, 123, 19);
		contentPane.add(txt2_albumýd);
		txt2_albumýd.setColumns(10);
		
		txt2_albumadi = new JTextField();
		txt2_albumadi.setBounds(635, 389, 123, 19);
		contentPane.add(txt2_albumadi);
		txt2_albumadi.setColumns(10);
		
		txt2_albumtarihi = new JTextField();
		txt2_albumtarihi.setBounds(635, 418, 123, 19);
		contentPane.add(txt2_albumtarihi);
		txt2_albumtarihi.setColumns(10);
		
		txt2_albumtur = new JTextField();
		txt2_albumtur.setBounds(635, 447, 123, 19);
		contentPane.add(txt2_albumtur);
		txt2_albumtur.setColumns(10);
		
		txt2_albumsanatci = new JTextField();
		txt2_albumsanatci.setBounds(635, 476, 123, 19);
		contentPane.add(txt2_albumsanatci);
		txt2_albumsanatci.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Kaydet");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_sorgu,album_id,album_adi,album_tarih,album_tur,album_sanatci;
				
				album_id=txt2_albumýd.getText();
				album_adi=txt2_albumadi.getText();
				album_tarih=txt2_albumtarihi.getText();
				album_tur=txt2_albumtur.getText();
				album_sanatci=txt2_albumsanatci.getText();
				
				//sql_sorgu="INSERT INTO sarki (sarki_id,sarki_adi,sarki_sure,sarki_dinlenmeGenel,album_id) VALUES ("+
				//sarki_id+",'"+sarki_adi+"',"+"'"+sarki_sure+"',"+"'"+sarki_dinlenmeGenel+"',"+album_id+")";
				sql_sorgu="INSERT INTO album (album_id,album_adi,album_tarih,album_tur,sanatci_id) VALUES ("+album_id+
						",'"+album_adi+"',"+"'"+album_tarih+"',"+album_tur+","+album_sanatci+")";
						
				baglanti.ekle(sql_sorgu);
				System.out.println(sql_sorgu);
				
			}
		});
		btnNewButton_5.setBounds(550, 505, 78, 21);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_7 = new JLabel("alb\u00FCm id");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(550, 363, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("album ad\u0131");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(550, 392, 65, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("album tarih");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_9.setBounds(550, 421, 65, 13);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("album t\u00FCr");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_10.setBounds(550, 450, 65, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("sanat\u00E7\u0131");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_11.setBounds(550, 479, 45, 13);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_6 = new JButton("G\u00FCncelle");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sql_sorgu,album_id,album_adi,album_tarih,album_tur,album_sanatci;
				
				album_id=txt2_albumýd.getText();
				album_adi=txt2_albumadi.getText();
				album_tarih=txt2_albumtarihi.getText();
				album_tur=txt2_albumtur.getText();
				album_sanatci=txt2_albumsanatci.getText();
				
			
				sql_sorgu="UPDATE album SET album_id="+album_id+" , album_adi='"+album_adi+"',"+"album_tarih='"+album_tarih+"',album_tur="+album_tur+",sanatci_id="+album_sanatci+
						" WHERE album_id ="+album_id;
				
				System.out.println(sql_sorgu);
				
				baglanti.guncelle(sql_sorgu);
			}
		});
		btnNewButton_6.setBounds(638, 505, 92, 21);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Sil");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql_sorgu,album_id;
				album_id=txt2_albumýd.getText();
				sql_sorgu="DELETE  FROM album WHERE album_id="+album_id;
				
				baglanti.sil(sql_sorgu);
				
			}
		});
		btnNewButton_7.setBounds(740, 505, 55, 21);
		contentPane.add(btnNewButton_7);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(812, 41, 380, 233);
		contentPane.add(scrollPane_2);
		
		
		
		table_2 = new JTable();
		table_2.setModel(modelim3);
		modelim3.setColumnIdentifiers(kolonlar3);
		modelim3.addRow(satirlar3);
		table_2.setBounds(1104, 319, 277, 128);
		scrollPane_2.setViewportView(table_2);
		
		
		txt3_sanatciid = new JTextField();
		txt3_sanatciid.setBounds(1323, 115, 123, 19);
		contentPane.add(txt3_sanatciid);
		txt3_sanatciid.setColumns(10);
		
		txt3_sanatciadi = new JTextField();
		txt3_sanatciadi.setBounds(1323, 144, 123, 19);
		contentPane.add(txt3_sanatciadi);
		txt3_sanatciadi.setColumns(10);
		
		txt3_sanatciulke = new JTextField();
		txt3_sanatciulke.setBounds(1323, 173, 123, 19);
		contentPane.add(txt3_sanatciulke);
		txt3_sanatciulke.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Sanatci Id");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_12.setBounds(1243, 118, 70, 13);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Sanatci Adi");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_13.setBounds(1243, 147, 70, 13);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Ulke");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_14.setBounds(1243, 176, 45, 13);
		contentPane.add(lblNewLabel_14);
		
		JButton btnNewButton_9 = new JButton("Kaydet");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sanatci_id,sanatci_adi,sanatci_ulke,sql_sorgu;
				
			sanatci_id= txt3_sanatciid.getText();
			sanatci_adi=txt3_sanatciadi.getText();
			sanatci_ulke=txt3_sanatciulke.getText();
			
			sql_sorgu="INSERT INTO sanatci (sanatci_id,sanatci_adi,sanatci_ulke) Values ("+sanatci_id+",'"+sanatci_adi+"','"+sanatci_ulke+"')";
				
			baglanti.ekle(sql_sorgu);
				
			}
		});
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_9.setBounds(1202, 244, 85, 21);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Guncelle");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql_sorgu,sanatci_id,sanatci_adi,sanatci_ulke;
				
				sanatci_id=txt3_sanatciid.getText();
				sanatci_adi=txt3_sanatciadi.getText();
				sanatci_ulke=txt3_sanatciulke.getText();
				
				sql_sorgu="UPDATE sanatci SET sanatci_id="+sanatci_id+",sanatci_adi ='"+sanatci_adi+"', sanatci_ulke ='"+sanatci_ulke+"' WHERE sanatci_id ="+sanatci_id;
				
				System.out.println(sql_sorgu);
				baglanti.ekle(sql_sorgu);
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_10.setBounds(1297, 244, 85, 21);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Sil");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql_sorgu,sanatci_id;
				
				sanatci_id=txt3_sanatciid.getText();
				
				sql_sorgu="DELETE  FROM sanatci WHERE sanatci_id = "+sanatci_id;
				
				System.out.println(sql_sorgu);
				baglanti.sil(sql_sorgu);
				
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_11.setBounds(1391, 244, 85, 21);
		contentPane.add(btnNewButton_11);
		
		
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(812, 322, 380, 189);
		contentPane.add(scrollPane_3);
		
		
		
		table_3 = new JTable();
		modelim4.setColumnIdentifiers(kolonlar4);
		modelim4.addRow(satirlar4);
		table_3.setModel(modelim4);
		table_3.setBounds(1000, 545, 227, 115);
		scrollPane_3.setViewportView(table_3);
		table_3.getColumnModel().getColumn(0).setPreferredWidth(8);
	
		
		JButton btnNewButton_12 = new JButton("KULLANICILARI L\u0130STELE");
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql_sorgu ="SELECT * FROM kullanici";
				modelim4.setRowCount(0);
				
				ResultSet myRs= baglanti.yap(sql_sorgu);
				
				
				try {
					while(myRs.next()) {	
					satirlar4[0]= myRs.getString("kullanici_id");
					
					satirlar4[1]= myRs.getString("kullanici_adi");
					satirlar4[2]= myRs.getString("kullanici_email");
					satirlar4[3]= myRs.getString("kullanici_sifre");
					satirlar4[4]= myRs.getString("kullanici_abonelik");
					satirlar4[5]= myRs.getString("kullanici_odeme");
					modelim4.addRow(satirlar4);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
				}
				
				System.out.println(satirlar4);
				
				table_3.setModel(modelim4);
				table_3.getColumnModel().getColumn(0).setPreferredWidth(20);
				table_3.getColumnModel().getColumn(0).setMaxWidth(30);
				table_3.getColumnModel().getColumn(3).setMaxWidth(50);
				table_3.getColumnModel().getColumn(4).setMaxWidth(80);
				table_3.getColumnModel().getColumn(5).setMaxWidth(70);
				
			}
		});
		btnNewButton_12.setBounds(1262, 294, 184, 42);
		contentPane.add(btnNewButton_12);
		
		txt4_kullaniciid = new JTextField();
		txt4_kullaniciid.setBounds(1333, 345, 96, 19);
		contentPane.add(txt4_kullaniciid);
		txt4_kullaniciid.setColumns(10);
		
		txt4_kullaniciadi = new JTextField();
		txt4_kullaniciadi.setBounds(1333, 373, 96, 19);
		contentPane.add(txt4_kullaniciadi);
		txt4_kullaniciadi.setColumns(10);
		
		txt4_kullaniciemail = new JTextField();
		txt4_kullaniciemail.setBounds(1333, 402, 96, 19);
		contentPane.add(txt4_kullaniciemail);
		txt4_kullaniciemail.setColumns(10);
		
		txt4_kullanicisifre = new JTextField();
		txt4_kullanicisifre.setBounds(1333, 431, 96, 19);
		contentPane.add(txt4_kullanicisifre);
		txt4_kullanicisifre.setColumns(10);
		
		txt4_kullaniciabonelik = new JTextField();
		txt4_kullaniciabonelik.setBounds(1333, 460, 96, 19);
		contentPane.add(txt4_kullaniciabonelik);
		txt4_kullaniciabonelik.setColumns(10);
		
		JButton btnNewButton_13 = new JButton("Kaydet");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kullanici_id,kullanici_adi,kullanici_email,kullanici_sifre,kullanici_abonelik,kullanici_odeme,sql_sorgu;
				
				kullanici_id=txt4_kullaniciid.getText();
				kullanici_adi=txt4_kullaniciadi.getText();
				kullanici_email=txt4_kullaniciemail.getText();
				kullanici_sifre=txt4_kullanicisifre.getText();
				kullanici_abonelik=txt4_kullaniciabonelik.getText();
				kullanici_odeme=txt4_kullaniciodeme.getText();
				
				
				sql_sorgu="INSERT INTO kullanici (kullanici_id,kullanici_adi,kullanici_email,kullanici_sifre,kullanici_abonelik,kullanici_odeme)"+
						"VALUES ("+kullanici_id+",'"+kullanici_adi+"','"+kullanici_email+"','"+kullanici_sifre+"','"+kullanici_abonelik+"','"+kullanici_odeme+"')";
				
				System.out.println(sql_sorgu);
				baglanti.ekle(sql_sorgu);
			}
		});
		btnNewButton_13.setBounds(1202, 521, 85, 21);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("G\u00FCncelle");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				String kullanici_id,kullanici_adi,kullanici_email,kullanici_sifre,kullanici_abonelik,kullanici_odeme,sql_sorgu;
				
				kullanici_id=txt4_kullaniciid.getText();
				kullanici_adi=txt4_kullaniciadi.getText();
				kullanici_email=txt4_kullaniciemail.getText();
				kullanici_sifre=txt4_kullanicisifre.getText();
				kullanici_abonelik=txt4_kullaniciabonelik.getText();
				kullanici_odeme=txt4_kullaniciodeme.getText();
				
				sql_sorgu="UPDATE kullanici SET kullanici_id="+kullanici_id+",kullanici_adi ='"+kullanici_adi+"',kullanici_email='"+kullanici_email+"',kullanici_sifre='"+kullanici_sifre
						+"',kullanici_abonelik='"+kullanici_abonelik+"',kullanici_odeme='"+kullanici_odeme+"' WHERE kullanici_id="+kullanici_id;
				
				System.out.println(sql_sorgu);
				baglanti.guncelle(sql_sorgu);
				
				
			}
		});
		btnNewButton_14.setBounds(1297, 521, 85, 21);
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Sil");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_sorgu,kullanici_id;
				
				kullanici_id=txt4_kullaniciid.getText();
				
				sql_sorgu="DELETE  FROM kullanici WHERE kullanici_id = "+kullanici_id;
				
				System.out.println(sql_sorgu);
				baglanti.sil(sql_sorgu);
				
			}
		});
		btnNewButton_15.setBounds(1391, 521, 85, 21);
		contentPane.add(btnNewButton_15);
		
		JLabel lblNewLabel_15 = new JLabel("Id");
		lblNewLabel_15.setBounds(1262, 345, 51, 13);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Kullanici ");
		lblNewLabel_16.setBounds(1262, 376, 61, 13);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("E-mail");
		lblNewLabel_17.setBounds(1262, 405, 61, 13);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("\u015Eifre");
		lblNewLabel_18.setBounds(1262, 434, 45, 13);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Abonelik");
		lblNewLabel_19.setBounds(1262, 463, 61, 13);
		contentPane.add(lblNewLabel_19);
		
		txt4_kullaniciodeme = new JTextField();
		txt4_kullaniciodeme.setBounds(1333, 489, 96, 19);
		contentPane.add(txt4_kullaniciodeme);
		txt4_kullaniciodeme.setColumns(10);
		
		JLabel lblNewLabel_20 = new JLabel("Odeme");
		lblNewLabel_20.setBounds(1262, 492, 61, 19);
		contentPane.add(lblNewLabel_20);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		scrollPane_4.setBounds(10, 568, 530, 185);
		contentPane.add(scrollPane_4);
		
		table_4 = new JTable();
		modelim5.setColumnIdentifiers(kolonlar5);
		modelim5.addRow(satirlar5);
		
		table_4.setModel(modelim5);
		table_4.setBounds(385, 654, 251, 131);
			scrollPane_4.setViewportView(table_4);
			
			JButton btnNewButton_16 = new JButton("L\u0130STELE");
			btnNewButton_16.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton_16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String sql_sorgu;
					sql_sorgu="SELECT * FROM sanatci_sarki";
					
					ResultSet myRs=baglanti.yap(sql_sorgu);
					

					modelim5.setRowCount(0);
					
					try {
						while(myRs.next()) {
						satirlar5[0]= myRs.getString("saantcý_sarki_id");
						satirlar5[1]= myRs.getString("sanatci_id");
						satirlar5[2]= myRs.getString("sarki_id");
						
						modelim5.addRow(satirlar5);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
					}
					
					table_4.setModel(modelim5);
					
					table_4.getColumnModel().getColumn(0).setMaxWidth(20);
					
					
				}
			});
			btnNewButton_16.setBounds(574, 572, 184, 42);
			contentPane.add(btnNewButton_16);
			
			txt5_id = new JTextField();
			txt5_id.setBounds(635, 635, 123, 19);
			contentPane.add(txt5_id);
			txt5_id.setColumns(10);
			
			txt5_sanatci = new JTextField();
			txt5_sanatci.setBounds(635, 664, 123, 19);
			contentPane.add(txt5_sanatci);
			txt5_sanatci.setColumns(10);
			
			txt5_album = new JTextField();
			txt5_album.setBounds(635, 693, 123, 19);
			contentPane.add(txt5_album);
			txt5_album.setColumns(10);
			
			JLabel lblNewLabel_21 = new JLabel("ID");
			lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblNewLabel_21.setBounds(550, 638, 45, 13);
			contentPane.add(lblNewLabel_21);
			
			JLabel lblNewLabel_22 = new JLabel("sanat\u00E7\u0131 id");
			lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblNewLabel_22.setBounds(550, 667, 65, 13);
			contentPane.add(lblNewLabel_22);
			
			JLabel lblNewLabel_23 = new JLabel("album id");
			lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblNewLabel_23.setBounds(550, 696, 65, 13);
			contentPane.add(lblNewLabel_23);
			
			JButton btnNewButton_17 = new JButton("Kaydet");
			btnNewButton_17.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql_sorgu,id,sanatci_id,album_id;
					
					id = txt5_id.getText();
					sanatci_id=txt5_sanatci.getText();
					album_id = txt5_album.getText();
					
					sql_sorgu="INSERT INTO sanatcialbum(sanatciAlbum_id,sanatci_sanatci_id,album_album_id) VALUES ("+id+","+sanatci_id+","+album_id+")";
					
					baglanti.ekle(sql_sorgu);
					
				}
			});
			btnNewButton_17.setBounds(550, 732, 78, 21);
			contentPane.add(btnNewButton_17);
			
			JButton btnNewButton_18 = new JButton("G\u00FCncelle");
			btnNewButton_18.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
		
					String sql_sorgu,id,sanatci_id,album_id;
					
					id = txt5_id.getText();
					sanatci_id=txt5_sanatci.getText();
					album_id = txt5_album.getText();
					
					sql_sorgu="UPDATE sanatcialbum SET sanatciAlbum_id="+id+", sanatci_sanatci_id ="+sanatci_id+",album_album_id ="+album_id+" WHERE sanatciAlbum_id ="+id;
					
					System.out.println(sql_sorgu);
					baglanti.ekle(sql_sorgu);
				}
			});
			btnNewButton_18.setBounds(638, 732, 92, 21);
			contentPane.add(btnNewButton_18);
			
			JButton btnNewButton_19 = new JButton("Sil");
			btnNewButton_19.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql_sorgu,id;
					
					id = txt5_id.getText();
					
					sql_sorgu="DELETE  FROM sanatcialbum WHERE sanatciAlbum_id = "+id;
					
					baglanti.sil(sql_sorgu);
					
				}
			});
			btnNewButton_19.setBounds(740, 732, 55, 21);
			contentPane.add(btnNewButton_19);
			
			JLabel lblNewLabel_24 = new JLabel("SANAT\u00C7I - \u015EARKI E\u015ELE\u015ET\u0130RME");
			lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_24.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_24.setBounds(10, 529, 530, 29);
			contentPane.add(lblNewLabel_24);
			
			JLabel lblNewLabel_25 = new JLabel("KULLANICILAR");
			lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_25.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_25.setBounds(812, 284, 380, 27);
			contentPane.add(lblNewLabel_25);
			
			JLabel lblNewLabel_26 = new JLabel("SANAT\u00C7ILAR");
			lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_26.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_26.setBounds(812, 6, 380, 31);
			contentPane.add(lblNewLabel_26);
			
			JButton btnNewButton_20 = new JButton("\u00C7IKI\u015E");
			btnNewButton_20.setBackground(new Color(255, 153, 153));
			btnNewButton_20.setForeground(new Color(0, 0, 0));
			btnNewButton_20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					giris giris_ekrani=new giris();
					giris_ekrani.setVisible(true);
					
					setVisible(false);
					
				}
			});
			btnNewButton_20.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnNewButton_20.setBounds(1217, 664, 212, 62);
			contentPane.add(btnNewButton_20);
			
			txt_dinlenmeSayisiYerel = new JTextField();
			txt_dinlenmeSayisiYerel.setBounds(635, 182, 123, 19);
			contentPane.add(txt_dinlenmeSayisiYerel);
			txt_dinlenmeSayisiYerel.setColumns(10);
			
			JLabel lblNewLabel_27 = new JLabel("Dinlenme Yerel");
			lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblNewLabel_27.setBounds(550, 182, 78, 13);
			contentPane.add(lblNewLabel_27);
			
			JLabel lblNewLabel_28 = new JLabel("Admin Ekran\u0131");
			lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_28.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_28.setBounds(860, 588, 271, 95);
			contentPane.add(lblNewLabel_28);

		
		

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				txt_sarkiid.setText((String) modelim.getValueAt(table.getSelectedRow(), 0));
				txt_sarkiAdi.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
				txt_sure.setText((String) modelim.getValueAt(table.getSelectedRow(), 4));
				txt_dinlenmeSayisiGenel.setText((String) modelim.getValueAt(table.getSelectedRow(), 5));
				txt_dinlenmeSayisiYerel.setText((String) modelim.getValueAt(table.getSelectedRow(), 6));
				txt_albumId.setText((String) modelim.getValueAt(table.getSelectedRow(), 7));
				
				
				
				
			}
		});
		
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				txt2_albumýd.setText((String) modelim2.getValueAt(table_1.getSelectedRow(), 0));
				txt2_albumadi.setText((String) modelim2.getValueAt(table_1.getSelectedRow(), 1));
				txt2_albumtarihi.setText((String) modelim2.getValueAt(table_1.getSelectedRow(), 2));
				txt2_albumtur.setText((String) modelim2.getValueAt(table_1.getSelectedRow(), 3));
				txt2_albumsanatci.setText((String) modelim2.getValueAt(table_1.getSelectedRow(), 4));
				

			}
		});
		
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt3_sanatciid.setText((String) modelim3.getValueAt(table_2.getSelectedRow(), 0));
				txt3_sanatciadi.setText((String) modelim3.getValueAt(table_2.getSelectedRow(), 1));
				txt3_sanatciulke.setText((String) modelim3.getValueAt(table_2.getSelectedRow(), 2));
			}
		});
		
		
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt4_kullaniciid.setText((String) modelim4.getValueAt(table_3.getSelectedRow(), 0));
				txt4_kullaniciadi.setText((String) modelim4.getValueAt(table_3.getSelectedRow(), 1));
				txt4_kullaniciemail.setText((String) modelim4.getValueAt(table_3.getSelectedRow(), 2));
				txt4_kullanicisifre.setText((String) modelim4.getValueAt(table_3.getSelectedRow(), 3));
				txt4_kullaniciabonelik.setText((String) modelim4.getValueAt(table_3.getSelectedRow(), 4));
				txt4_kullaniciodeme.setText((String) modelim4.getValueAt(table_3.getSelectedRow(), 5));
				
			}
		});
		
		
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt5_id.setText((String) modelim5.getValueAt(table_4.getSelectedRow(), 0));
				txt5_sanatci.setText((String) modelim5.getValueAt(table_4.getSelectedRow(), 1));
				txt5_album.setText((String) modelim5.getValueAt(table_4.getSelectedRow(), 2));
				
			}
		});
		
	}
}
