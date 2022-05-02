package MusicPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class kullaniciProfil extends JFrame {

	private JPanel contentPane;
	private JTable table_pop;
	private JTable table_jaz;
	private JTable table_klasik;
	private JScrollPane scrollPane_takipEdilenler;
	private JTable table_takipEdilenler;
	
	static String Kullanici_id=giris.giris_id;
	static String Kullanici_nick=anaEkran.kullanici_adi;
	
	DefaultTableModel modelim = new DefaultTableModel();
	
	Object[] kolonlar = {"ID","SANATCI","SARKI","TUR","SARKI ID"};
	Object[] satirlar= new Object[5];
	
	
    DefaultTableModel modelim2 = new DefaultTableModel();
	
	Object[] kolonlar2 = {"ID","SANATCI","SARKI","TUR","SARKI ID"};
	Object[] satirlar2= new Object[5];
	
	 DefaultTableModel modelim3 = new DefaultTableModel();
		
		Object[] kolonlar3 = {"ID","SANATCI","SARKI","TUR","SARKI ID"};
		Object[] satirlar3 = new Object[5];
		
		
		 DefaultTableModel modelim4 = new DefaultTableModel();
			
			Object[] kolonlar4 = {"ID","Kullanýcý adý"};
			Object[] satirlar4 = new Object[2];
		
		
		
		private JTextField text_calmaid;
		private JTextField text_sarkiadi;
		private JTextField textField_id;
		private JTextField textField_isim;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullaniciProfil frame = new kullaniciProfil();
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
	public kullaniciProfil() {
		setBackground(Color.WHITE);
		
		setBounds(175, 50, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 239, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_pop = new JScrollPane();
		
		scrollPane_pop.setBounds(62, 337, 250, 276);
		contentPane.add(scrollPane_pop);
		
		JScrollPane scrollPane_jaz = new JScrollPane();
		
		scrollPane_jaz.setBounds(353, 337, 250, 276);
		contentPane.add(scrollPane_jaz);
		
		JScrollPane scrollPane_klasik = new JScrollPane();
		
		scrollPane_klasik.setBounds(641, 337, 250, 276);
		contentPane.add(scrollPane_klasik);
		
		table_pop = new JTable();
		table_pop.setModel(modelim);
		table_pop.setBounds(75, 294, 151, 110);
		//scrollPane_topTurkiye.setViewportView(table_topTurkiye);
		//contentPane.add(table_pop);
		scrollPane_pop.setViewportView(table_pop);
		
		table_jaz = new JTable();
		table_jaz.setModel(modelim2);
		table_jaz.setBounds(355, 294, 151, 110);
		scrollPane_jaz.setViewportView(table_jaz);
		//contentPane.add(table_jaz);
		
		table_klasik = new JTable();
		table_klasik.setModel(modelim3);
		table_klasik.setBounds(590, 294, 151, 110);
		scrollPane_klasik.setViewportView(table_klasik);
		
		scrollPane_takipEdilenler = new JScrollPane();
		scrollPane_takipEdilenler.setBounds(731, 47, 261, 270);
		contentPane.add(scrollPane_takipEdilenler);
		
		table_takipEdilenler = new JTable();
		table_takipEdilenler.setModel(modelim4);
		table_takipEdilenler.setBounds(684, 277, 65, 152);
		
		
		scrollPane_takipEdilenler.setViewportView(table_takipEdilenler);
		
		modelim.setColumnIdentifiers(kolonlar);
		
		modelim2.setColumnIdentifiers(kolonlar2);
		
		modelim3.setColumnIdentifiers(kolonlar3);
		
		modelim4.setColumnIdentifiers(kolonlar4);
		
		JButton btnNewButton = new JButton("L\u0130STELER\u0130 YEN\u0130LE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql_sorgu;
				ResultSet myRs;
				
				System.out.println("++++++++++++++"+Kullanici_id);
				
				sql_sorgu="SELECT calmalistesi_id,sanatci.sanatci_adi, sarki.sarki_adi, tur.tur_adi,sarki.sarki_id FROM sanatci,album,sarki,tur,calmalistelesi where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and calmalistelesi.sarki_id =sarki.sarki_id and calmalistelesi.tur_id = 1 and calmalistelesi.kullanici_id ="+Kullanici_id+" order by sarki_id asc ;";
				System.out.println(sql_sorgu);
				myRs= baglanti.yap(sql_sorgu);
				modelim.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar[0]= myRs.getString("calmalistesi_id");
					satirlar[1]= myRs.getString("sanatci_adi");
					satirlar[2]= myRs.getString("sarki_adi");
					satirlar[3]= myRs.getString("tur_adi");
					satirlar[4]= myRs.getString("sarki_id");
					modelim.addRow(satirlar);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table_pop.getColumnModel().getColumn(0).setMaxWidth(20);
				table_pop.getColumnModel().getColumn(3).setMaxWidth(40);
				table_pop.setModel(modelim);
				
			
				
				
				
				sql_sorgu="SELECT calmalistesi_id,sanatci.sanatci_adi, sarki.sarki_adi, tur.tur_adi,sarki.sarki_id FROM sanatci,album,sarki,tur,calmalistelesi where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and calmalistelesi.sarki_id =sarki.sarki_id and calmalistelesi.tur_id =2 and calmalistelesi.kullanici_id ="+Kullanici_id+" order by sarki_id asc ;";
				myRs= baglanti.yap(sql_sorgu);
				modelim2.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar2[0]= myRs.getString("calmalistesi_id");
					satirlar2[1]= myRs.getString("sanatci_adi");
					satirlar2[2]= myRs.getString("sarki_adi");
					satirlar2[3]= myRs.getString("tur_adi");
					satirlar2[4]= myRs.getString("sarki_id");
					modelim2.addRow(satirlar2);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table_jaz.getColumnModel().getColumn(0).setMaxWidth(20);
				table_jaz.getColumnModel().getColumn(3).setMaxWidth(40);
				table_jaz.setModel(modelim2);
				
				
				
				sql_sorgu="SELECT calmalistesi_id,sanatci.sanatci_adi, sarki.sarki_adi, tur.tur_adi,sarki.sarki_id FROM sanatci,album,sarki,tur,calmalistelesi where sanatci.sanatci_id=album.sanatci_id \r\n"
						+ "and  (sarki.album_id=album.album_id and album.album_tur = tur.tur_id) and calmalistelesi.sarki_id =sarki.sarki_id and calmalistelesi.tur_id =3 and calmalistelesi.kullanici_id ="+Kullanici_id+" order by sarki_id asc ;";
				
				myRs= baglanti.yap(sql_sorgu);
				modelim3.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar3[0]= myRs.getString("calmalistesi_id");
					satirlar3[1]= myRs.getString("sanatci_adi");
					satirlar3[2]= myRs.getString("sarki_adi");
					satirlar3[3]= myRs.getString("tur_adi");
					satirlar3[4]= myRs.getString("sarki_id");
					modelim3.addRow(satirlar3);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				table_klasik.getColumnModel().getColumn(0).setMaxWidth(20);
				table_klasik.getColumnModel().getColumn(3).setMaxWidth(40);
				table_klasik.setModel(modelim3);
				
				
				sql_sorgu="SELECT takiplistesi.takipedilen_id,kullanici.kullanici_adi FROM takiplistesi, kullanici WHERE takipedilen_id=kullanici.kullanici_id and takiplistesi.kullanici_id="+Kullanici_id;
				myRs= baglanti.yap(sql_sorgu);
				modelim4.setRowCount(0);
				
				try {
					while(myRs.next()) {
					satirlar4[0]= myRs.getString("takipedilen_id");
					satirlar4[1]= myRs.getString("kullanici_adi");
				
					modelim4.addRow(satirlar4);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//table_takipEdilenler.getColumnModel().getColumn(0).setMaxWidth(20);
				//table_takipEdilenler.getColumnModel().getColumn(3).setMaxWidth(40);
				table_takipEdilenler.setModel(modelim4);
				
				
			}
		});
		btnNewButton.setBounds(405, 166, 261, 88);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(81, 22, 200, 200);
		//lblNewLabel.setBackground(Color.black);
		lblNewLabel.setIcon(new ImageIcon("images\\profil.png"));
		//lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);
		
		text_calmaid = new JTextField();
		text_calmaid.setBounds(974, 392, 131, 19);
		contentPane.add(text_calmaid);
		text_calmaid.setColumns(10);
		
		text_sarkiadi = new JTextField();
		text_sarkiadi.setBounds(974, 432, 131, 19);
		contentPane.add(text_sarkiadi);
		text_sarkiadi.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Listeden Sil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,sql_sorgu; 
				
				id = text_calmaid.getText();
				
				sql_sorgu="DELETE  FROM  calmalistelesi WHERE calmalistesi_id="+id;
				
				baglanti.sil(sql_sorgu);
				
				
			}
		});
		btnNewButton_1.setBounds(984, 500, 107, 21);
		contentPane.add(btnNewButton_1);
		
		textField_id = new JTextField();
		textField_id.setBounds(1031, 69, 96, 19);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		textField_isim = new JTextField();
		textField_isim.setBounds(1031, 112, 96, 19);
		contentPane.add(textField_isim);
		textField_isim.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Takipten \u00C7\u0131k");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String takipedilenid,sql_sorgu; 
				
				takipedilenid= textField_id.getText();
				
				
				sql_sorgu="DELETE  FROM  takiplistesi WHERE kullanici_id ="+  Kullanici_id+ " and takipedilen_id = "+takipedilenid;
				
				System.out.println(sql_sorgu);
				baglanti.sil(sql_sorgu);
			}
		});
		btnNewButton_2.setBounds(1020, 171, 107, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(914, 395, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u015Eark\u0131 ad\u0131");
		lblNewLabel_2.setBounds(914, 435, 62, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("kullan\u0131c\u0131 ad\u0131");
		lblNewLabel_3.setText(Kullanici_nick);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_3.setBounds(62, 227, 250, 88);
		contentPane.add(lblNewLabel_3);
		
		
		table_pop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text_calmaid.setText((String) modelim.getValueAt(table_pop.getSelectedRow(), 0));
				text_sarkiadi.setText((String) modelim.getValueAt(table_pop.getSelectedRow(), 2));
				
			}
		});
		
		table_jaz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				text_calmaid.setText((String) modelim2.getValueAt(table_jaz.getSelectedRow(), 0));
				text_sarkiadi.setText((String) modelim2.getValueAt(table_jaz.getSelectedRow(), 2));
			}
		});
		
		table_klasik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				text_calmaid.setText((String) modelim3.getValueAt(table_klasik.getSelectedRow(), 0));
				text_sarkiadi.setText((String) modelim3.getValueAt(table_klasik.getSelectedRow(), 2));
			}
		});
		
		
		table_takipEdilenler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_id.setText((String) modelim4.getValueAt(table_takipEdilenler.getSelectedRow(), 0));
				textField_isim.setText((String) modelim4.getValueAt(table_takipEdilenler.getSelectedRow(), 1));
			}
		});
		
		//contentPane.add(table_klasik);
	}
}
