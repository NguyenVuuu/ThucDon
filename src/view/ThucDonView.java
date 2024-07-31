package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import controll.ThucDonControll;
import modal.ThucDonModal;

public class ThucDonView extends JFrame {
	public ThucDonModal thucDonModal;
	public JLabel jLabel_thongTin;
	public ArrayList<JCheckBox> list_monPhu;
	public ButtonGroup buttonGroup_monChinh;
	public JComboBox<String> jComboBox_monChinh;
	public JList<String> jList_monPhu;

	public ThucDonView() throws HeadlessException {
		this.thucDonModal = new ThucDonModal();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("MENU");
		this.setSize(1200, 550);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		Font font_header = new Font("Sheriff", Font.BOLD, 40);
		Font font_radio = new Font("Sheriff", Font.BOLD, 40);
		Font font_check = new Font("Sheriff", Font.PLAIN, 30);
		Font font_thanhToan = new Font("Sheriff", Font.BOLD, 20);
		Font font_btn = new Font("Sheriff", Font.BOLD, 25);
		Font font_luuY = new Font("Sheriff", Font.ITALIC, 25);

		ActionListener ac = new ThucDonControll(this);

		JLabel jLabel_header = new JLabel("MANGO RESTAURANT", JLabel.CENTER);
		jLabel_header.setFont(font_header);
		jLabel_header.setForeground(Color.orange);
		this.add(jLabel_header, BorderLayout.NORTH);

		JPanel jPanel_monAn = new JPanel();
		jPanel_monAn.setLayout(new BorderLayout());

		JPanel jPanel_monChinh = new JPanel();
		jPanel_monChinh.setLayout(new FlowLayout());
		// <=> select+option trong HTML
		String cacMonChinh[] = new String[] { "Cơm Gà", "Mỳ Quảng", "Phở Bò", "Bún Thịt Nướng", "Phở Gà" };
		jComboBox_monChinh = new JComboBox<>(cacMonChinh);
		jComboBox_monChinh.setFont(font_radio);
		jPanel_monChinh.add(jComboBox_monChinh);
//		jRadioButton_comGa = new JRadioButton("Cơm Gà");
//		jRadioButton_comGa.setFont(font_radio);
//		jRadioButton_myQuang = new JRadioButton("Mỳ Quảng");
//		jRadioButton_myQuang.setFont(font_radio);
//		jRadioButton_phoBo = new JRadioButton("Phở Bò");
//		jRadioButton_phoBo.setFont(font_radio);
//		buttonGroup_monChinh = new ButtonGroup();
//		buttonGroup_monChinh.add(jRadioButton_comGa);
//		buttonGroup_monChinh.add(jRadioButton_myQuang);
//		buttonGroup_monChinh.add(jRadioButton_phoBo);
//		jPanel_monChinh.add(jRadioButton_comGa);
//		jPanel_monChinh.add(jRadioButton_myQuang);
//		jPanel_monChinh.add(jRadioButton_phoBo);

		JPanel jPanel_monPhu = new JPanel();
		jPanel_monPhu.setLayout(new BorderLayout());
		JLabel jLabel_luuY = new JLabel("Giữ CTRL khi chọn nhiều món");
		jLabel_luuY.setFont(font_luuY);
		jLabel_luuY.setForeground(Color.BLUE);
		String cacMonPhu[] = new String[] { "Chè Thái", "Kem Trái Cây", "Bánh Plan", "Nước Ngọt", "Trà Sữa",
				"Nước Trái Cây", "Sinh Tố", "Chè Thập Cẩm" };
		jList_monPhu = new JList<String>(cacMonPhu);
		jList_monPhu.setFont(font_check);
		jPanel_monPhu.add(jLabel_luuY, BorderLayout.NORTH);
		jPanel_monPhu.add(jList_monPhu, BorderLayout.CENTER);
		JScrollPane jScrollPane_monPhu = new JScrollPane();
		jScrollPane_monPhu.setViewportView(jPanel_monPhu);
//		jCheckBox_cheThai = new JCheckBox("Chè Thái");
//		jCheckBox_cheThai.setFont(font_check);
//		jCheckBox_kemTraiCay = new JCheckBox("Kem Trái Cây");
//		jCheckBox_kemTraiCay.setFont(font_check);
//		jCheckBox_banhPlan = new JCheckBox("Bánh Plan");
//		jCheckBox_banhPlan.setFont(font_check);
//		jCheckBox_nuocNgot = new JCheckBox("Nước Ngọt");
//		jCheckBox_nuocNgot.setFont(font_check);
//		list_monPhu = new ArrayList<JCheckBox>();
//		list_monPhu.add(jCheckBox_cheThai);
//		list_monPhu.add(jCheckBox_kemTraiCay);
//		list_monPhu.add(jCheckBox_banhPlan);
//		list_monPhu.add(jCheckBox_nuocNgot);
//		jPanel_monPhu.add(jCheckBox_cheThai);
//		jPanel_monPhu.add(jCheckBox_kemTraiCay);
//		jPanel_monPhu.add(jCheckBox_banhPlan);
//		jPanel_monPhu.add(jCheckBox_nuocNgot);

		jPanel_monAn.add(jPanel_monChinh, BorderLayout.NORTH);
		jPanel_monAn.add(jScrollPane_monPhu, BorderLayout.CENTER);
		this.add(jPanel_monAn, BorderLayout.CENTER);

		JPanel jPanel_thanhToan = new JPanel();
		jPanel_thanhToan.setLayout(new GridLayout(2, 1));
		jLabel_thongTin = new JLabel();
		jLabel_thongTin.setFont(font_thanhToan);
		jLabel_thongTin.setForeground(Color.red);
		JButton jButton_thanhToan = new JButton("Thanh Toán");
		jButton_thanhToan.addActionListener(ac);
		jButton_thanhToan.setFont(font_btn);
		jButton_thanhToan.setBackground(Color.GREEN);
		jButton_thanhToan.setBorderPainted(false);
		jPanel_thanhToan.add(jLabel_thongTin);
		jPanel_thanhToan.add(jButton_thanhToan);
		this.add(jPanel_thanhToan, BorderLayout.SOUTH);

	}

	public void hienThiKetQua() {
		String ketQua = "Món Chính: " + this.thucDonModal.getLuaChon_monChinh() + " | Món Phụ: "
				+ this.thucDonModal.getLuaChon_monPhu() + " | Tổng Tiền: " + this.thucDonModal.getTongTien();
		this.jLabel_thongTin.setText(ketQua);
	}

}
