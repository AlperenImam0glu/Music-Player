package MusicPlayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import jdk.nashorn.api.tree.ForInLoopTree;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.util.ArrayList;
public class anaEkran extends JFrame {

	private JPanel contentPane;
	private JTable table_tumSarkilar;
	private JScrollPane scrollPane_topPop;
	private JScrollPane scrollPane_topJaz;
	private JScrollPane scrollPane_topKlasik;
	private JScrollPane scrollPane_topGenel;
	private JScrollPane scrollPane_topTurkiye;
	private JTable table_topGenel;
	private JTable table_topTurkiye;
	private JTable table_topKlasik;
	private JTable table_topJaz;
	private JTable table_topPop;
	private JTextField text_sarki_id;
	private JTextField textField_sarkiAdi;
	private JTextField textField_SanatciAdi;
	private JTable table_tumKullanicilar;
	private JTable table_digerKullaniciPop;
	private JTable table_digerKullaniciJaz;
	private JTable table_digerKullaniciKlasik;
	private JTextField txt_kullaniciId;
	private JTextField txt_kullaniciAdi;
	private JButton btn_takipEt;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField txt_digerKullaniciid;
	private JButton btn_tumListeyiAl;
	private JButton btnNewButton_2;
	
	
	DefaultTableModel modelim = new DefaultTableModel();
	DefaultTableModel modelim2 = new DefaultTableModel();
	DefaultTableModel modelim3 = new DefaultTableModel();
	DefaultTableModel modelim4= new DefaultTableModel();
	DefaultTableModel modelim5 = new DefaultTableModel();
	DefaultTableModel modelim6 = new DefaultTableModel();
	DefaultTableModel modelim7 = new DefaultTableModel();
	DefaultTableModel modelim8 = new DefaultTableModel();
	DefaultTableModel modelim9 = new DefaultTableModel();
	DefaultTableModel modelim10 = new DefaultTableModel();
	
	Object[] kolonlar = {"ID","SANATÇI","ÝSÝM","ALBUM","SURE","DÝNLENME","TUR"};
	Object[] satirlar= new Object[7];
	
	Object[] kolonlar2 = {"ID","SANATÇI","ÝSÝM","DÝNLENME"};
	Object[] satirlar2= new Object[4];
	
	Object[] kolonlar3 = {"ID","SANATÇI","ÝSÝM","DÝNLENME"};
	Object[] satirlar3= new Object[4];
	
	Object[] kolonlar4 = {"ID","SANATÇI","ÝSÝM","DÝNLENME"};
	Object[] satirlar4= new Object[4];
	
	Object[] kolonlar5 = {"ID","SANATÇI","ÝSÝM","DÝNLENME"};
	Object[] satirlar5= new Object[4];
	
	Object[] kolonlar6 = {"ID","SANATÇI","ÝSÝM","DÝNLENME"};
	Object[] satirlar6= new Object[4];
	
	Object[] kolonlar7 = {"ID","KULLANÝCÝ","ABONELÝK"};
	Object[] satirlar7= new Object[3];
	
	
	Object[] kolonlar8 = {"ID","SANATCI","SARKI","TUR","SARKI ID"};
	Object[] satirlar8= new Object[5];
	
	Object[] kolonlar9 = {"ID","SANATCI","SARKI","TUR","SARKI ID"};
	Object[] satirlar9= new Object[5];
	
	Object[] kolonlar10 = {"ID","SANATCI","SARKI","TUR","SARKI ID"};
	Object[] satirlar10= new Object[5];
	
	
	
	
	private JButton btn_listele;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	
	static String kullanici_adi=giris.kullanici_ad,Kullanici_id=giris.giris_id;
	private JTextField textField_listetur;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					anaEkran frame = new anaEkran();
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
	public anaEkran( ) {
		
		
		String sql_sorgu2 ;
		ResultSet myRs2;
		
		sql_sorgu2="SELECT * FROM kullanici WHERE kullanici_adi = '"+kullanici_adi+"'";
		
		
		
		myRs2= baglanti.yap(sql_sorgu2);
		
		try {
			while(myRs2.next()) {
				Kullanici_id= myRs2.getString("kullanici_id");
			
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(Kullanici_id);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 10, 1500, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(179,179,179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_tumSarkilar = new JScrollPane();
		
		scrollPane_tumSarkilar.setBounds(39, 51, 410, 424);
		contentPane.add(scrollPane_tumSarkilar);
		
	
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00DCRK\u0130YE", "\u0130NG\u0130LTERE"}));
		comboBox.setBounds(294, 518, 105, 21);
		contentPane.add(comboBox);
		
		
		table_tumSarkilar = new JTable();
		table_tumSarkilar.setModel(modelim);
		table_tumSarkilar.setBounds(160, 511, 262, 128);
		
		scrollPane_tumSarkilar.setViewportView(table_tumSarkilar);
		
		scrollPane_topPop = new JScrollPane();
		
		scrollPane_topPop.setBounds(462, 51, 208, 183);
		contentPane.add(scrollPane_topPop);
		
		scrollPane_topJaz = new JScrollPane();
		scrollPane_topJaz.setBounds(462, 292, 208, 183);
		contentPane.add(scrollPane_topJaz);
		
		scrollPane_topKlasik = new JScrollPane();
		scrollPane_topKlasik.setBounds(462, 542, 208, 183);
		contentPane.add(scrollPane_topKlasik);
		
		scrollPane_topGenel = new JScrollPane();
		scrollPane_topGenel.setBounds(39, 542, 200, 183);
		contentPane.add(scrollPane_topGenel);
		
		scrollPane_topTurkiye = new JScrollPane();
		scrollPane_topTurkiye.setBounds(249, 542, 200, 183);
		contentPane.add(scrollPane_topTurkiye);
		
		table_topGenel = new JTable();
		table_topGenel.setModel(modelim5);
		table_topGenel.setBounds(64, 600, 127, 97);
		
		scrollPane_topGenel.setViewportView(table_topGenel);
		
		table_topTurkiye = new JTable();
		table_topTurkiye.setModel(modelim6);
		table_topTurkiye.setBounds(305, 600, 113, 89);
		
		scrollPane_topTurkiye.setViewportView(table_topTurkiye);
		
		table_topKlasik = new JTable();
		table_topKlasik.setModel(modelim4);
		table_topKlasik.setBounds(684, 552, 90, 89);
		
		scrollPane_topKlasik.setViewportView(table_topKlasik);
		
		table_topJaz = new JTable();
		table_topJaz.setModel(modelim3);
		table_topJaz.setBounds(684, 326, 113, 103);
		
		scrollPane_topJaz.setViewportView(table_topJaz);
		
		table_topPop = new JTable();
		table_topPop.setModel(modelim2);
		table_topPop.setBounds(684, 89, 118, 116);
		scrollPane_topPop.setViewportView(table_topPop);
		
		JLabel lblNewLabel = new JLabel("T\u00FCm \u015Eark\u0131lar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(39, 10, 410, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TOP 10 D\u00DCNYA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(39, 489, 200, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOP 10 T\u00DCRK\u0130YE");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(249, 489, 200, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TOP 10 JAZ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(459, 244, 211, 38);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TOP 10 KLAS\u0130K");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(462, 485, 208, 41);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TOP 10 POP");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(462, 10, 208, 31);
		contentPane.add(lblNewLabel_5);
		
		text_sarki_id = new JTextField();
		text_sarki_id.setBounds(782, 291, 96, 19);
		contentPane.add(text_sarki_id);
		text_sarki_id.setColumns(10);
		
		JButton btn_listeneEkle = new JButton("Listeye ekle");
		btn_listeneEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String sarki_id,sql_sorgu,tur_id=null; 
				
				sarki_id=text_sarki_id.getText();
				
				
				sql_sorgu="SELECT count(kullanici_id) FROM calmalistelesi WHERE  kullanici_id="+Kullanici_id+" and sarki_id ="+sarki_id+"";
				
				ResultSet myRs = baglanti.yap(sql_sorgu);
				
				try {
					while(myRs.next()){
						if(myRs.getInt("count(kullanici_id)")==1) {
							
							JOptionPane.showMessageDialog(null, "Sarki listenizde mevcut");
						}
						else {
							

							sql_sorgu="SELECT album_tur,sarki_id FROM album,sarki WHERE sarki.album_id = album.album_id and sarki_id="+sarki_id;
							ResultSet myRs3 = baglanti.yap(sql_sorgu);
							
							try {
								while(myRs3.next()){
									tur_id=myRs3.getString("album_tur");
									System.out.println("GÝRDÝ");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							int enBuyukid=0;
							sql_sorgu="SELECT * FROM calmalistelesi order by calmalistesi_id desc limit 1 ;";
							ResultSet myRs4 = baglanti.yap(sql_sorgu);
							
							try {
								while(myRs4.next()){
									//enBuyukid=myRs.getString("calmalistesi_id");
									enBuyukid=myRs4.getInt("calmalistesi_id");
									System.out.println("GÝRDÝ");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							enBuyukid=enBuyukid+1;
				
							
							System.out.println("OLUÞTURULAN ID ="+enBuyukid);
							
							
							sql_sorgu="INSERT INTO calmalistelesi(calmalistesi_id,kullanici_id,sarki_id,tur_id) VALUES ( "+enBuyukid+","+
							Kullanici_id+","+sarki_id+","+tur_id+")"	;
							
							baglanti.ekle(sql_sorgu);
							System.out.println(sql_sorgu);
							
							
							JOptionPane.showMessageDialog(null, "Sarki listenize eklenmistir");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("ALBUM TÜRÜ ="+tur_id);
				
				//sql_sorgu="INSERT INTO calmalistelesi (sarki_id,sarki_adi,sarki_sure,sarki_dinlenmeYerel,sarki_dinlenmeGenel,album_id) VALUES ("+")";
				
				//baglanti.ekle(sql_sorgu);
				
				System.out.println(sql_sorgu);
				
				
			}
		});
		btn_listeneEkle.setBounds(731, 454, 147, 21);
		contentPane.add(btn_listeneEkle);
		
		textField_sarkiAdi = new JTextField();
		textField_sarkiAdi.setBounds(782, 344, 96, 19);
		contentPane.add(textField_sarkiAdi);
		textField_sarkiAdi.setColumns(10);
		
		textField_SanatciAdi = new JTextField();
		textField_SanatciAdi.setBounds(782, 395, 96, 19);
		contentPane.add(textField_SanatciAdi);
		textField_SanatciAdi.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u015Eark\u0131 id");
		lblNewLabel_6.setBounds(713, 294, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u015Eark\u0131 ad\u0131");
		lblNewLabel_7.setBounds(713, 347, 66, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Sanat\u00E7\u0131 ad\u0131");
		lblNewLabel_8.setBounds(713, 398, 66, 13);
		contentPane.add(lblNewLabel_8);
		
		JButton btn_profileGit = new JButton("PROF\u0130LE G\u0130T");
		btn_profileGit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				kullaniciProfil profil = new kullaniciProfil();
				
				profil.setVisible(true);
				
				
			}
		});
		btn_profileGit.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_profileGit.setBounds(721, 232, 175, 50);
		contentPane.add(btn_profileGit);
		
		JScrollPane scrollPane_tumKullanicilar = new JScrollPane();
		scrollPane_tumKullanicilar.setBounds(936, 51, 332, 205);
		contentPane.add(scrollPane_tumKullanicilar);
		
		table_tumKullanicilar = new JTable();
		table_tumKullanicilar.setModel(modelim7);
		table_tumKullanicilar.setBounds(1129, 267, 235, 129);
		 scrollPane_tumKullanicilar.setViewportView(table_tumKullanicilar);
		
		JScrollPane scrollPane_DigerKullaniciPop = new JScrollPane();
		scrollPane_DigerKullaniciPop.setBounds(936, 357, 161, 257);
		contentPane.add(scrollPane_DigerKullaniciPop);
		
		table_digerKullaniciPop = new JTable();
		table_digerKullaniciPop.setModel(modelim8);
		table_digerKullaniciPop.setBounds(962, 593, 148, 108);
		scrollPane_DigerKullaniciPop.setViewportView(table_digerKullaniciPop);
		
		JScrollPane scrollPane_DigerKullaniciJaz = new JScrollPane();
		scrollPane_DigerKullaniciJaz.setBounds(1107, 357, 161, 257);
		contentPane.add(scrollPane_DigerKullaniciJaz);
		
		table_digerKullaniciJaz = new JTable();
		table_digerKullaniciJaz.setModel(modelim9);
		table_digerKullaniciJaz.setBounds(1207, 577, 98, 90);
		scrollPane_DigerKullaniciJaz.setViewportView(table_digerKullaniciJaz);
		
		JScrollPane scrollPane_DigerKullaniciKlasik = new JScrollPane();
		scrollPane_DigerKullaniciKlasik.setBounds(1278, 357, 161, 257);
		contentPane.add(scrollPane_DigerKullaniciKlasik);
		
		table_digerKullaniciKlasik = new JTable();
		table_digerKullaniciKlasik.setModel(modelim10);
		table_digerKullaniciKlasik.setBounds(1365, 593, 121, 90);
		scrollPane_DigerKullaniciKlasik.setViewportView(table_digerKullaniciKlasik);
		
		txt_kullaniciId = new JTextField();
		txt_kullaniciId.setBounds(1363, 92, 96, 19);
		contentPane.add(txt_kullaniciId);
		txt_kullaniciId.setColumns(10);
		
		txt_kullaniciAdi = new JTextField();
		txt_kullaniciAdi.setBounds(1363, 145, 96, 19);
		contentPane.add(txt_kullaniciAdi);
		txt_kullaniciAdi.setColumns(10);
		
		btn_takipEt = new JButton("Takip Et");
		btn_takipEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String takipedilecek_id=null,sql_sorgu;
				
				
				takipedilecek_id=txt_kullaniciId.getText();
				sql_sorgu="SELECT kullanici_abonelik,kullanici_odeme FROM kullanici WHERE kullanici_id ="+takipedilecek_id;
				//ResultSet myRs = baglanti.yap(sql_sorgu);
				ResultSet myRs= baglanti.yap(sql_sorgu);
			
	
				try {
					while(myRs.next()) {
					//satirlar[0]= myRs.getString("sarki_id");
					if(myRs.getString("kullanici_abonelik").equals("1") && myRs.getString("kullanici_odeme").equals("1")) {
						System.out.println("TAKÝP EDÝLEBÝLÝR");
						
						
						sql_sorgu="SELECT count(takiplistesi_id) FROM takiplistesi WHERE  kullanici_id="+Kullanici_id+" and takipedilen_id="+takipedilecek_id;
						
						ResultSet myRs2= baglanti.yap(sql_sorgu); 
						try {
							while(myRs2.next()) {
							//satirlar[0]= myRs.getString("sarki_id");
							if(myRs2.getString("count(takiplistesi_id)").equals("1") ) {
						
								JOptionPane.showMessageDialog(null, "BU KÝÞÝYÝ ZATEN TAKÝP EDÝYORSUNUZ");
							}
							else {
								
								
								int enBuyukid=0;
								sql_sorgu="SELECT * FROM takiplistesi order by takiplistesi_id desc limit 1 ;";
								ResultSet myRs3 = baglanti.yap(sql_sorgu);
								
								try {
									while(myRs3.next()){
										//enBuyukid=myRs.getString("calmalistesi_id");
										enBuyukid=myRs3.getInt("takiplistesi_id");
										System.out.println("GÝRDÝ");
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								enBuyukid+=1;
								
								
								sql_sorgu="INSERT INTO takiplistesi (takiplistesi_id,kullanici_id,takipedilen_id) Values("+enBuyukid+","+Kullanici_id+","+takipedilecek_id+")";
										
										baglanti.ekle(sql_sorgu);
										System.out.println(sql_sorgu);
										
										
										JOptionPane.showMessageDialog(null, "KULLANÝCÝ TAKÝP LÝSTENÝZE EKLENMÝÞTÝR");
								
								
								
								
							}
							}
							
						}
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
						
					}
					else {
						
						JOptionPane.showMessageDialog(null, "KULLANICI PREMIUM DEÐÝL TAKÝP EDLÝEMEZ");
					}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
				
				
			}
		});
		btn_takipEt.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_takipEt.setBounds(1325, 220, 114, 31);
		contentPane.add(btn_takipEt);
		
		lblNewLabel_9 = new JLabel("Kullanici id");
		lblNewLabel_9.setBounds(1278, 95, 75, 13);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Kullanici Adi");
		lblNewLabel_10.setBounds(1278, 148, 75, 13);
		contentPane.add(lblNewLabel_10);
		
		txt_digerKullaniciid = new JTextField();
		txt_digerKullaniciid.setBounds(1153, 621, 96, 19);
		contentPane.add(txt_digerKullaniciid);
		txt_digerKullaniciid.setColumns(10);
		
		btn_tumListeyiAl = new JButton("Tum Listeyi Al");
		btn_tumListeyiAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				String listesahibi,listeturu,sql_sorgu,sql_sorgu2;
				ResultSet myRs,myRs2;
				listesahibi=txt_digerKullaniciid.getText();
				listeturu=textField_listetur.getText();
				int enBuyukid=0;
				

				sql_sorgu="SELECT * FROM calmalistelesi order by calmalistesi_id desc limit 1 ;";
				ResultSet myRs4 = baglanti.yap(sql_sorgu);
				
				try {
					while(myRs4.next()){
						//enBuyukid=myRs.getString("calmalistesi_id");
						enBuyukid=myRs4.getInt("calmalistesi_id");
						System.out.println("GÝRDÝ");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				enBuyukid=enBuyukid+1;
	
				
				System.out.println("OLUÞTURULAN ID ="+enBuyukid);
				
				
				
				sql_sorgu="SELECT sarki_id FROM calmalistelesi WHERE kullanici_id ="+Kullanici_id+" and tur_id = "+listeturu;
				sql_sorgu2="SELECT sarki_id FROM calmalistelesi WHERE kullanici_id ="+listesahibi+" and tur_id = "+listeturu;
				
				System.out.println(sql_sorgu);
				System.out.println(sql_sorgu2);
				System.out.println("liste sahini ="+listesahibi+"liste turu ="+listeturu);
				
				
				ArrayList<Object> liste1=new ArrayList<Object>();
				ArrayList<Object> liste2=new ArrayList<Object>();
				
				myRs=baglanti.yap(sql_sorgu);
				
				try {
					while(myRs.next()) {
					//satirlar[0]= myRs.getString("sarki_id");
					
					 liste1.add(myRs.getString("sarki_id"));
					 
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
				}
				
				myRs2=baglanti.yap(sql_sorgu2);
				
				try {
					while(myRs2.next()) {
					//satirlar[0]= myRs.getString("sarki_id");
					
					 liste2.add(myRs2.getString("sarki_id"));
					 
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "HATALI GÝRÝS");
				}
				
				System.out.println(liste1);
				System.out.println(liste2);
				
				
				for(int i=0;i<liste1.size();i++) {
                        for(int j=0;j<liste2.size();j++){
                        	if(liste1.get(i).equals(liste2.get(j))) {
                        		liste2.remove(j);
                        	}
                        }
				}
				
				
				if(liste2.size()==0) {
					
					JOptionPane.showMessageDialog(null, "LÝSTEDEKÝ TÜM ÞARKILAR ZATEN MEVCUT");
				}
				
				System.out.println(liste2);
				
				
				
				
				for(int i=0;i<liste2.size();i++) {
					sql_sorgu="INSERT INTO calmalistelesi (calmalistesi_id,kullanici_id,sarki_id,tur_id) "+
				"VALUES("+enBuyukid+","+Kullanici_id+","+liste2.get(i)+","+listeturu+")";
					baglanti.ekle(sql_sorgu);
					enBuyukid+=1;
			}
				
				
				
				
			}
		});
		btn_tumListeyiAl.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_tumListeyiAl.setBounds(1129, 704, 139, 21);
		contentPane.add(btn_tumListeyiAl);
		
		btnNewButton_2 = new JButton("\u00C7IKI\u015E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				giris giris_ekrani=new giris();
				giris_ekrani.setVisible(true);
				
				setVisible(false);
				
			}
		});
		btnNewButton_2.setBackground(new Color(255, 99, 71));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(1391, 21, 85, 21);
		contentPane.add(btnNewButton_2);
		
		modelim.setColumnIdentifiers(kolonlar);
		modelim2.setColumnIdentifiers(kolonlar2);
		modelim3.setColumnIdentifiers(kolonlar3);
		modelim4.setColumnIdentifiers(kolonlar4);
		modelim5.setColumnIdentifiers(kolonlar5);
		modelim6.setColumnIdentifiers(kolonlar6);
		modelim7.setColumnIdentifiers(kolonlar7);
		
		btn_listele = new JButton("YEN\u0130LE");
		btn_listele.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_listele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql_sorgu;
				ResultSet myRs;
				
				sql_sorgu="SELECT sarki_id,sanatci.sanatci_adi, sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,tur.tur_adi FROM sanatci,album,sarki,tur where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ " \r\n"
						+ "and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id)  order by sarki_id asc ;";
				myRs= baglanti.yap(sql_sorgu);
				modelim.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar[0]= myRs.getString("sarki_id");
					satirlar[1]= myRs.getString("sanatci_adi");
					satirlar[2]= myRs.getString("sarki_adi");
					
					String sql_sorgu2;
					ResultSet myRs2;
					myRs2= baglanti.yap(sql_sorgu);
					
					
					
					satirlar[3]= myRs.getString("album_adi");
					satirlar[4]= myRs.getString("sarki_sure");
					satirlar[5]= myRs.getString("sarki_dinlenmeGenel");
					satirlar[6]= myRs.getString("tur_adi");
					modelim.addRow(satirlar);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table_tumSarkilar.setModel(modelim);
				table_tumSarkilar.getColumnModel().getColumn(0).setMaxWidth(20);
				table_tumSarkilar.getColumnModel().getColumn(4).setMaxWidth(40);
				table_tumSarkilar.getColumnModel().getColumn(5).setMaxWidth(65);
				table_tumSarkilar.getColumnModel().getColumn(6).setMaxWidth(40);
				
				
				sql_sorgu=" SELECT sarki_id,sanatci.sanatci_adi, sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,tur.tur_adi FROM sanatci,album,sarki,tur where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "						and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and album_tur=1  order by sarki_dinlenmeGenel desc LIMIT 10 ;";
				modelim2.setRowCount(0);
				
				myRs =baglanti.yap(sql_sorgu);
				
				
				try {
					while(myRs.next()) {
					satirlar2[0]= myRs.getString("sarki_id");
					satirlar2[1]= myRs.getString("sanatci_adi");
					satirlar2[2]= myRs.getString("sarki_adi");
					satirlar2[3]= myRs.getString("sarki_dinlenmeGenel");
				
					modelim2.addRow(satirlar2);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_topPop.getColumnModel().getColumn(0).setMaxWidth(20);
				table_topPop.setModel(modelim2);
				
				sql_sorgu=" SELECT sarki_id,sanatci.sanatci_adi, sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,tur.tur_adi FROM sanatci,album,sarki,tur where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "						and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and album_tur=2  order by sarki_dinlenmeGenel desc LIMIT 10 ;";
				modelim3.setRowCount(0);
				
				myRs =baglanti.yap(sql_sorgu);
				
				
				try {
					while(myRs.next()) {
					satirlar3[0]= myRs.getString("sarki_id");
					satirlar3[1]= myRs.getString("sanatci_adi");
					satirlar3[2]= myRs.getString("sarki_adi");
					satirlar3[3]= myRs.getString("sarki_dinlenmeGenel");
				
					modelim3.addRow(satirlar3);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_topJaz.getColumnModel().getColumn(0).setMaxWidth(20);
				table_topJaz.setModel(modelim3);
				
				sql_sorgu=" SELECT sarki_id,sanatci.sanatci_adi, sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,tur.tur_adi FROM sanatci,album,sarki,tur where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "						and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and album_tur=3  order by sarki_dinlenmeGenel desc LIMIT 10 ;";
				modelim4.setRowCount(0);
				
				myRs =baglanti.yap(sql_sorgu);
				
				
				try {
					while(myRs.next()) {
					satirlar4[0]= myRs.getString("sarki_id");
					satirlar4[1]= myRs.getString("sanatci_adi");
					satirlar4[2]= myRs.getString("sarki_adi");
					satirlar4[3]= myRs.getString("sarki_dinlenmeGenel");
				
					modelim4.addRow(satirlar4);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_topKlasik.getColumnModel().getColumn(0).setMaxWidth(20);
				table_topKlasik.setModel(modelim4);
				
				
				
				sql_sorgu=" SELECT sarki_id,sanatci.sanatci_adi, sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,tur.tur_adi FROM sanatci,album,sarki,tur where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "						and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) order by sarki_dinlenmeGenel desc LIMIT 10 ;";
				modelim5.setRowCount(0);
				
				myRs =baglanti.yap(sql_sorgu);
				
				
				try {
					while(myRs.next()) {
					satirlar5[0]= myRs.getString("sarki_id");
					satirlar5[1]= myRs.getString("sanatci_adi");
					satirlar5[2]= myRs.getString("sarki_adi");
					satirlar5[3]= myRs.getString("sarki_dinlenmeGenel");
				
					modelim5.addRow(satirlar5);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_topGenel.getColumnModel().getColumn(0).setMaxWidth(20);
				table_topGenel.setModel(modelim5);
				
				
				int secilen=comboBox.getSelectedIndex() ;
				
				
				if(secilen ==0) {
				sql_sorgu=" SELECT sarki_id,sanatci.sanatci_adi, sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,tur.tur_adi,sarki_dinlenmeYerel FROM sanatci,album,sarki,tur where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "						and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) order by sarki_dinlenmeYerel desc LIMIT 10 ;";
				lblNewLabel_2.setText("TOP 10 TÜRKÝYE");
				}else if(secilen==1) {
					sql_sorgu=" SELECT sarki_id,sanatci.sanatci_adi,sarki.sarki_adi, album.album_adi,sarki.sarki_sure,sarki.sarki_dinlenmeGenel,tur.tur_adi,sarki_dinlenmeYerel,sarki.sarki_dinlenmeUlke2 FROM sanatci,album,sarki,tur where sanatci.sanatci_id=album.sanatci_id \r\n"
							+ "			and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) order by sarki_dinlenmeUlke2 desc LIMIT 10 ; ";
					lblNewLabel_2.setText("TOP 10 ÝNGÝLTERE");
				}				
				
				modelim6.setRowCount(0);
				
				myRs =baglanti.yap(sql_sorgu);
				
				
				try {
					while(myRs.next()) {
					satirlar6[0]= myRs.getString("sarki_id");
					satirlar6[1]= myRs.getString("sanatci_adi");
					satirlar6[2]= myRs.getString("sarki_adi");
					
					if(secilen ==0) {
					satirlar6[3]= myRs.getString("sarki_dinlenmeYerel");
					}
					else if(secilen ==1) {
						satirlar6[3]= myRs.getString("sarki_dinlenmeUlke2");
					}
					modelim6.addRow(satirlar6);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_topTurkiye.getColumnModel().getColumn(0).setMaxWidth(20);
				table_topTurkiye.setModel(modelim6);
				
				
				sql_sorgu="SELECT * FROM kullanici; ";
				modelim7.setRowCount(0);
				
				myRs =baglanti.yap(sql_sorgu);
				
				
				try {
					while(myRs.next()) {
					satirlar7[0]= myRs.getString("kullanici_id");
					satirlar7[1]= myRs.getString("kullanici_adi");
					
					
					if(myRs.getInt("kullanici_abonelik") == 1) {
						satirlar7[2]="Premium Kullanýcý";
						
					}else {
						satirlar7[2]="Normal Kullanýcý";
					}
				
					modelim7.addRow(satirlar7);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table_tumKullanicilar.getColumnModel().getColumn(0).setMaxWidth(20);
				table_tumKullanicilar.setModel(modelim7);
				
				
			}
		});
		
		
		btn_listele.setBounds(748, 14, 121, 31);
		contentPane.add(btn_listele);
		
		modelim8.setColumnIdentifiers(kolonlar8);
		modelim9.setColumnIdentifiers(kolonlar9);
		modelim10.setColumnIdentifiers(kolonlar10);
		
		JButton btnNewButton_3 = new JButton("Listeleri Gör");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim8.setRowCount(0);
				modelim9.setRowCount(0);
				modelim10.setRowCount(0);
				
				ResultSet myRs;
				ResultSet myRs2;
				String sql_sorgu,sql_sorgu2,id="1";
				
				
				id = txt_kullaniciId.getText();
						
						
				
				System.out.println("++++++++++++++"+Kullanici_id);
				
				//premium olanlarýn gozukur sadece
				sql_sorgu="\r\n"
						+ "SELECT calmalistesi_id,sanatci.sanatci_adi, sarki.sarki_adi, tur.tur_adi,sarki.sarki_id FROM sanatci,album,sarki,tur,calmalistelesi,kullanici where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and calmalistelesi.sarki_id =sarki.sarki_id and calmalistelesi.tur_id = 1 and calmalistelesi.kullanici_id ="+id+" and(calmalistelesi.kullanici_id=kullanici.kullanici_id and kullanici.kullanici_odeme=1) order by sarki_id asc ;";
				
				System.out.println(sql_sorgu);
				myRs= baglanti.yap(sql_sorgu);
				modelim8.setRowCount(0);
				
				sql_sorgu2="SELECT count(takiplistesi_id) FROM takiplistesi WHERE kullanici_id = "+Kullanici_id+"  and takipedilen_id ="+id;
				System.out.println("---------------------KULLANÝCÝ ID ="+Kullanici_id+"ARANAN ="+id);
				myRs2= baglanti.yap(sql_sorgu2);
				
				int a=0;
				
				try {
					while(myRs2.next()) {
						if(myRs2.getString("count(takiplistesi_id)").equals("1")){
							a=1;
							
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				if(a==1) {
				
				
				try {
					while(myRs.next()) {
					satirlar8[0]= myRs.getString("calmalistesi_id");
					satirlar8[1]= myRs.getString("sanatci_adi");
					satirlar8[2]= myRs.getString("sarki_adi");
					satirlar8[3]= myRs.getString("tur_adi");
					satirlar8[4]= myRs.getString("sarki_id");
					modelim8.addRow(satirlar8);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//table_digerKullaniciPop.getColumn(0).setMaxWidth(20);
				//table_pop.getColumnModel().getColumn(3).setMaxWidth(40);
				table_digerKullaniciPop.setModel(modelim8);
				
				sql_sorgu="\r\n"
						+ "SELECT calmalistesi_id,sanatci.sanatci_adi, sarki.sarki_adi, tur.tur_adi,sarki.sarki_id FROM sanatci,album,sarki,tur,calmalistelesi,kullanici where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and calmalistelesi.sarki_id =sarki.sarki_id and calmalistelesi.tur_id = 2 and calmalistelesi.kullanici_id ="+id+" and(calmalistelesi.kullanici_id=kullanici.kullanici_id and kullanici.kullanici_odeme=1) order by sarki_id asc ;";
				
				System.out.println("LÝSTELER GÖZÜKÜYOR");
				myRs= baglanti.yap(sql_sorgu);
				modelim9.setRowCount(0);
				
				
				try {
					while(myRs.next()) {
					satirlar9[0]= myRs.getString("calmalistesi_id");
					satirlar9[1]= myRs.getString("sanatci_adi");
					satirlar9[2]= myRs.getString("sarki_adi");
					satirlar9[3]= myRs.getString("tur_adi");
					satirlar9[4]= myRs.getString("sarki_id");
					modelim9.addRow(satirlar9);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//table_pop.getColumnModel().getColumn(3).setMaxWidth(40);
				table_digerKullaniciJaz.setModel(modelim9);
				
				
				sql_sorgu="\r\n"
						+ "SELECT calmalistesi_id,sanatci.sanatci_adi, sarki.sarki_adi, tur.tur_adi,sarki.sarki_id FROM sanatci,album,sarki,tur,calmalistelesi,kullanici where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and calmalistelesi.sarki_id =sarki.sarki_id and calmalistelesi.tur_id = 3 and calmalistelesi.kullanici_id ="+id+" and(calmalistelesi.kullanici_id=kullanici.kullanici_id and kullanici.kullanici_odeme=1) order by sarki_id asc ;";
				
				
				System.out.println("LÝSTELER GÖZÜKÜYOR2");
				myRs= baglanti.yap(sql_sorgu);
				modelim10.setRowCount(0);
				
				
				try {
					while(myRs.next()) {
					satirlar10[0]= myRs.getString("calmalistesi_id");
					satirlar10[1]= myRs.getString("sanatci_adi");
					satirlar10[2]= myRs.getString("sarki_adi");
					satirlar10[3]= myRs.getString("tur_adi");
					satirlar10[4]= myRs.getString("sarki_id");
					modelim10.addRow(satirlar10);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				//table_pop.getColumnModel().getColumn(3).setMaxWidth(40);
				table_digerKullaniciKlasik.setModel(modelim10);
				
				a=0;
				}
				
			}
		});
		btnNewButton_3.setBounds(1107, 292, 161, 31);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(920, 0, 2, 800);
		lblNewLabel_11.setBackground(Color.white);
		lblNewLabel_11.setOpaque(true);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(694, 0, 2, 800);
		lblNewLabel_12.setBackground(Color.white);
		lblNewLabel_12.setOpaque(true);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Kullanici id");
		lblNewLabel_13.setBounds(1082, 624, 75, 13);
		contentPane.add(lblNewLabel_13);
		
		textField_listetur = new JTextField();
		textField_listetur.setBounds(1153, 659, 96, 19);
		contentPane.add(textField_listetur);
		textField_listetur.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Tur ");
		lblNewLabel_14.setBounds(1082, 662, 45, 13);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("POP");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_15.setBounds(936, 328, 161, 31);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("JAZ");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_16.setBounds(1107, 328, 161, 31);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("KLAS\u0130K");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setBounds(1278, 328, 161, 31);
		contentPane.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("T\u00DCM KULLANICILAR");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(936, 10, 332, 28);
		contentPane.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setText(kullanici_adi);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_19.setBounds(721, 187, 175, 38);
		contentPane.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setIcon(new ImageIcon("images\\profil2.png"));
		lblNewLabel_20.setBounds(738, 53, 140, 140);
		contentPane.add(lblNewLabel_20);
		
		lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setBounds(735, 585, 175, 140);
		lblNewLabel_21.setIcon(new ImageIcon("images\\player2.png"));
		contentPane.add(lblNewLabel_21);
		
		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_22.setBounds(694, 559, 232, 26);
		contentPane.add(lblNewLabel_22);
		
		
		String dinlenensarki;
		dinlenensarki=textField_sarkiAdi.getText() ;
		
		
		
		
		
		
		table_tumSarkilar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textField_sarkiAdi.setText((String) modelim.getValueAt(table_tumSarkilar.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim.getValueAt(table_tumSarkilar.getSelectedRow(), 0));
				textField_SanatciAdi.setText((String) modelim.getValueAt(table_tumSarkilar.getSelectedRow(), 1));
				
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
				//txt4_kullaniciid.setText((String) modelim4.getValueAt(table_3.getSelectedRow(), 0));
				
			}
		});
		
		table_topPop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim2.getValueAt(table_topPop.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim2.getValueAt(table_topPop.getSelectedRow(), 0));
				textField_SanatciAdi.setText((String) modelim2.getValueAt(table_topPop.getSelectedRow(), 1));
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
			}
		});
	
		table_topJaz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim3.getValueAt(table_topJaz.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim3.getValueAt(table_topJaz.getSelectedRow(), 0));
				textField_SanatciAdi.setText((String) modelim3.getValueAt(table_topJaz.getSelectedRow(), 1));
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
				
			}
		});
		
		table_topKlasik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim4.getValueAt(table_topKlasik.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim4.getValueAt(table_topKlasik.getSelectedRow(), 0));
				textField_SanatciAdi.setText((String) modelim4.getValueAt(table_topKlasik.getSelectedRow(), 1));
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
			}
		});
		
		table_topGenel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim5.getValueAt(table_topGenel.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim5.getValueAt(table_topGenel.getSelectedRow(), 0));
				textField_SanatciAdi.setText((String) modelim5.getValueAt(table_topGenel.getSelectedRow(), 1));
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
				
			}
		});
		
		table_topTurkiye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim6.getValueAt(table_topTurkiye.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim6.getValueAt(table_topTurkiye.getSelectedRow(), 0));
				textField_SanatciAdi.setText((String) modelim6.getValueAt(table_topTurkiye.getSelectedRow(), 1));
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
				
			}
		});
		
		
		table_tumKullanicilar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_kullaniciId.setText((String) modelim7.getValueAt(table_tumKullanicilar.getSelectedRow(), 0));
				txt_kullaniciAdi.setText((String) modelim7.getValueAt(table_tumKullanicilar.getSelectedRow(), 1));
				txt_digerKullaniciid.setText((String) modelim7.getValueAt(table_tumKullanicilar.getSelectedRow(), 0));
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
				
			}
		});
		
		
		table_digerKullaniciPop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim8.getValueAt(table_digerKullaniciPop.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim8.getValueAt(table_digerKullaniciPop.getSelectedRow(), 4));
				textField_SanatciAdi.setText((String) modelim8.getValueAt(table_digerKullaniciPop.getSelectedRow(), 1));
				textField_listetur.setText("1");
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
				
			}
		});
		
		table_digerKullaniciJaz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim9.getValueAt(table_digerKullaniciJaz.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim9.getValueAt(table_digerKullaniciJaz.getSelectedRow(), 4));
				textField_SanatciAdi.setText((String) modelim9.getValueAt(table_digerKullaniciJaz.getSelectedRow(), 1));
				textField_listetur.setText("2");
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
				
			}
		});
		table_digerKullaniciKlasik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_sarkiAdi.setText((String) modelim10.getValueAt(table_digerKullaniciKlasik.getSelectedRow(), 2));
				text_sarki_id.setText((String) modelim10.getValueAt(table_digerKullaniciKlasik.getSelectedRow(), 4));
				textField_SanatciAdi.setText((String) modelim10.getValueAt(table_digerKullaniciKlasik.getSelectedRow(), 1));
				textField_listetur.setText("3");
				lblNewLabel_22.setText(textField_SanatciAdi.getText()+"-"+textField_sarkiAdi.getText());
			}
		});
		
		//contentPane.add(tablo_tumSarkilar);
	}
}
